package com.nagternal.groovy.clojure

import clojure.lang.PersistentVector
import org.junit.Test

/**
 * User: Dylan
 * Date: 8/25/13
 * Time: 7:47 PM
 */
class FunctionTest {

    @Test
    void testCall() {
        def closure = {
            'hello'
        }
        def fn = new Function(closure)
        assert fn.invoke() == 'hello'
        assert 'hello' == fn.call()
        assert fn() == 'hello'
    }

    @Test
    void testDelegate() {
        def fn = new Function( { String name -> 'hello' } )
        assert fn.parameterTypes.size() == 1
        assert fn.parameterTypes[0] == String
        assert fn instanceof Closure
    }

    @Test
    void testCallArg() {
        def fn = new Function( { String name -> "hello $name" } )
        assert fn.invoke('joe') == 'hello joe'
        assert fn.call('joe') == 'hello joe'
        assert fn('joe') == 'hello joe'
    }

    @Test
    void testApply() {
        def fn = new Function( { first, second -> first + second } )
        PersistentVector args = DataStructureExtension.persistent([4, 5])
        assert 9 == fn.applyTo(args.seq())
    }
}
