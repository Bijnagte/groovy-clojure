package com.nagternal.groovy.clojure.transform
/**
 * User: Dylan
 * Date: 9/30/13
 * Time: 9:05 PM
 */

import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.FIELD])
@GroovyASTTransformationClass(['com.nagternal.groovy.clojure.transform.RequireASTTransformation'])
@interface Require {
    String value()
}