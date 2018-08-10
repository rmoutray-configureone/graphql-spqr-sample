/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core.managers.base;

/**
 *
 * @author rmoutray
 */
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rmoutray
 * @param <T>
 * @param <ID>
 * @param <R>
 */
public abstract class CoGenericAbstractManager<T, ID, R extends JpaRepository<T, ID>> {

    protected final JpaRepository<T, ID> repo;
    
    //private final Map<String, FluxSink<Issue>> sinks = new ConcurrentHashMap<>();

    public CoGenericAbstractManager(R repo) {
        this.repo = repo;
    }

    public Page<T> findAll(@GraphQLArgument(name = "page", defaultValue = "0")int page, @GraphQLArgument(name="size", defaultValue = "10")int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
    
    public void save(T entity) {
        repo.save(entity);
    }
        
    public void deleteById(ID id) {
        repo.deleteById(id);
    }

}
