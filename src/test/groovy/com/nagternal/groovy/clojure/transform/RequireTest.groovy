package com.nagternal.groovy.clojure.transform

import clojure.lang.Var
import org.junit.Test

/**
 * User: Dylan
 * Date: 9/30/13
 * Time: 10:46 PM
 */
class RequireTest {
    @Require('clojure.core/+')
    def plusFn

    @Test
    void testRequire() {

        def plus = RequireTest.plusFn
        assert plus instanceof Var
        assert plus.invoke(1, 2) == 3
    }
}
