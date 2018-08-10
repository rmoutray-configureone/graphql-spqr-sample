/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core;

import com.company.core.managers.base.CoGenericAbstractManager;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.generator.mapping.TypeMapper;
import io.leangen.graphql.generator.mapping.common.ObjectTypeMapper;
import io.leangen.graphql.generator.mapping.strategy.AbstractInterfaceMappingStrategy;
import io.leangen.graphql.generator.mapping.strategy.SuperTypeBasedInterfaceStrategy;
import io.leangen.graphql.metadata.strategy.query.OperationNameGenerator;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.ResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rmoutray
 */
@RestController
public class GraphQLController {

    private GraphQL graphQL;
    
    private final Map<String, CoGenericAbstractManager> managerServices;
    
    private ListableBeanFactory beanFactory;
    
    @Autowired
    public GraphQLController(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        this.managerServices = BeanFactoryUtils.beansOfTypeIncludingAncestors(this.beanFactory, CoGenericAbstractManager.class);
        createGraphQLController();
        
    }
    
    public void createGraphQLController() {
        
        GraphQLSchemaGenerator schemaGenerator = new GraphQLSchemaGenerator()
            .withBasePackages("com.company.core.model", "org.springframework.data")
        ;
                                
        for (Map.Entry<String, CoGenericAbstractManager> serviceEntry : this.managerServices.entrySet()) {
            CoGenericAbstractManager managerService = serviceEntry.getValue();
            
            OperationNameGenerator repoTypeOperationNameGenerator = new ReturnTypeAndMethodOperationNameGenerator(managerService.getClass().getSimpleName().replace("Manager", ""));
            ResolverBuilder typeResolverBuilder = new PublicResolverBuilder("com.company.core.managers")
                .withOperationNameGenerator(repoTypeOperationNameGenerator)
            ;
            schemaGenerator.withOperationsFromSingleton(managerService, typeResolverBuilder);
            
            continue;
        }
        
        GraphQLSchema schema = schemaGenerator
            .withValueMapperFactory(new JacksonValueMapperFactory())
            .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    
    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }
}
