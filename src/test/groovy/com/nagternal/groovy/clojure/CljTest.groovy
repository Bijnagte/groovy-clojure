package com.nagternal.groovy.clojure

import org.junit.Test

import clojure.lang.IPersistentMap
import clojure.lang.Keyword
import clojure.lang.RT
import clojure.lang.Symbol
import clojure.lang.Var

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
        Var a = Clj['user/a']
        Var b = Clj['user/b']
        assert b.deref() == 'value'
        assert a.deref() == 0
    }

    @Test
    void testDefineFunction() {
        Var var = Clj.define('hello') { 'hello' }
        assert var.ns == Clj.namespace(this.class)
        assert var.invoke() == 'hello'
    }

    @Test
    void testDefineFunctionHashMapMeta() {
        def docString = 'doc string'
        Var var = Clj.define('!', [doc: docString]) { arg ->
            "${arg}!"
        }

        def meta = var.meta()
        assert meta.size() == 3
        meta.each { k, v ->
            assert k instanceof Keyword
        }
        use(ClojureExtension) {
            def doc = 'doc'.keyword()
            def ns = 'ns'.keyword()
            assert 'woot!' == var('woot')
            assert Clj.namespace(this.class) == ns(meta)
            assert doc(meta) == docString
        }
    }

    @Test
    void testDoall() {
        def list = []
        def result = Clj.doall( { list << 'test' }, 'done')
        assert result == 'done'
        assert list.size() == 1
        assert list[0] == 'test'
    }
	
	
	@Test
	void testRequire() {
		//RT.load('test/test', true)
		def require = RT.var('clojure.core', 'require')
		require.invoke(Symbol.intern('test.test'))
		Var foo = RT.var('test.test', 'foo')
        assert foo.isBound()
		def result = foo.invoke('value')
		assert result instanceof IPersistentMap
        assert Keyword.intern('arg').invoke(result) == 'value'
	}
}
