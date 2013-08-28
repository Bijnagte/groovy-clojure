package com.nagternal.groovy.clojure

import clojure.lang.*
import org.junit.Test

class ClojureExtensionTest {

//    @Test
//    void test() {
//        use(ClojureExtension) {
//
//            Var plus = RT.var('clojure.core', '+')
//            println plus.meta()
//            def doc = Keyword.find('doc')
//            println doc(plus.meta())
//            def isNumber = RT.var('clojure.core', 'number?')
//            assert plus instanceof IFn
//            println doc(isNumber.meta())
//            def args = [1, 3] as IPersistentVector
//            def v = plus(1, 2)
//            println v
//        }
//
//    }

    @Test
    void addFn() {
        use(ClojureExtension) {
            def plus = RT.var('clojure.core', '+')
            Namespace user = Namespace.findOrCreate(Symbol.intern('user'));
            def fn = new Function({ println plus(3, 6) })
            Var hi = Var.intern(user, Symbol.intern('hello'), fn)
            def hello = RT.var('user', "hello")
            assert hello == hi
            hello()
        }
    }

    @Test
    void testClosureAsTypeFunction() {
        use(ClojureExtension) {
            Function fn = { 'hello' }.asFn()
            assert 'hello' == fn()
            Function fn1 = { 'hello' } as Function
            assert 'hello' == fn1()
            IFn fn2 = { 'hello' } as IFn
            assert fn2() == 'hello'
        }
    }

    @Test
    void testStringAsTypeKeyword() {
        use(ClojureExtension) {
            Keyword doc = 'doc' as Keyword
            assert doc instanceof Keyword
        }
    }

    @Test
    void testStringKeyword() {
        use(ClojureExtension) {
            Keyword doc = 'doc'.keyword()
            assert doc instanceof Keyword
        }
    }


}
