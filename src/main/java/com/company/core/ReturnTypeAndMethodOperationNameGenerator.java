/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core;

import io.leangen.graphql.metadata.strategy.query.OperationNameGenerator;
import io.leangen.graphql.metadata.strategy.query.ReturnTypeOperationNameGenerator;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author rmoutray
 */
public class ReturnTypeAndMethodOperationNameGenerator implements OperationNameGenerator {

    private final String returnType;

    public ReturnTypeAndMethodOperationNameGenerator(String returnType) {
        this.returnType = returnType;
    }
    
    @Override
    public String generateQueryName(Method queryMethod, AnnotatedType declaringType, Object instance) {
        return this.returnType + "_" + queryMethod.getName();
    }

    @Override
    public String generateQueryName(Field queryField, AnnotatedType declaringType, Object instance) {
        return this.returnType + "_" + queryField.getName() + this.returnType;
    }

    @Override
    public String generateMutationName(Method mutationMethod, AnnotatedType declaringType, Object instance) {
        return this.returnType + "_" + mutationMethod.getName() + this.returnType;
    }

    @Override
    public String generateSubscriptionName(Method subscriptionMethod, AnnotatedType declaringType, Object instance) {
        return this.returnType + "_" + subscriptionMethod.getName() + this.returnType;
    }
    
}
