package com.nagternal.groovy.clojure

import clojure.lang.Keyword
import clojure.lang.Var
import clojure.lang.Namespace
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: Dylan
 * Date: 8/25/13
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
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
        def fn = new Function({ String name -> 'hello' })
        assert fn.parameterTypes.size() == 1
        assert fn.parameterTypes[0] == String
        assert fn instanceof Closure
    }

    @Test
    void testCallArg() {
        def fn = new Function({ String name ->
            "hello $name"
        })
        assert fn.invoke('joe') == 'hello joe'
        assert fn.call('joe') == 'hello joe'
        assert fn('joe') == 'hello joe'
    }

    @Test
    void testDefine() {
        Var var = Function.define('hello') { 'hello' }
        assert var.ns.name.name == this.class.name.toLowerCase()
        assert var.invoke() == 'hello'
    }

    @Test
    void testDefineHashMapMeta() {
        def docString = 'doc string'
        Var var = Function.define('!', [doc: docString]) { arg ->
            "${arg}!"
        }

        def meta = var.meta()
        assert meta.size() == 2
        meta.each { k, v ->
            assert k instanceof Keyword
        }
        def doc = ClojureExtension.keyword('doc')
        def ns = ClojureExtension.keyword('ns')

        use(ClojureExtension) {
            assert 'woot!' == var('woot')
            assert this.class.name.toLowerCase() == ns(meta).toString()
            def ref = var.deref()
            assert doc(ref.meta()) == docString
        }
    }
}
