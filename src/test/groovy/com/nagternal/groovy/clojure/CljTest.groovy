package com.nagternal.groovy.clojure

import clojure.lang.Var
import org.junit.Test

class CljTest {

    @Test
    void testGetAtString() {
        Var plus = Clj['clojure.core/+']
        assert 5 == plus.invoke(3, 2)
    }

    @Test
    void testPutAt() {
        use(ClojureExtension) {
            Clj['user/addOne'] = { int val -> val + 1 }.asFn()
            def addOne = Clj['user/addOne']
            assert 5 == addOne(4)
        }
    }

    @Test
    void testDefine() {
        Clj.define('user', a: 0, b: 'value')
        def a = Clj['user/a']
        def b = Clj['user/b']
        assert b.deref() == 'value'

    }
}
