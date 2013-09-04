/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Dylan Bijnagte
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.nagternal.groovy.clojure

import clojure.lang.Namespace
import clojure.lang.Symbol

import java.util.concurrent.Callable

import clojure.lang.LockingTransaction
import clojure.lang.RT
import clojure.lang.Var

class Clj extends RT {

	static Var getAt(String ns, String name) {
		var(ns, name)
	}

	static Var getAt(List<String> nsname) {
		var(*nsname)
	}

	static Var getAt(String qualifiedName) {
		var(*nsname(qualifiedName))
	}

	static Var putAt(String qualifiedName, Object value) {
		var(*nsname(qualifiedName), value)
	}

    static nsname(String nsname) {
        int delim = nsname.indexOf('/')
        String ns = nsname[0..delim - 1]
        String name = nsname[delim + 1..-1]
        [ns, name]
    }

	static Var putAt(List<String> nsname, Object value) {
		var(*nsname, value)
	}

	static void define(Map vars, String namespace) {
		vars.each { name, value -> var(namespace, name, value) }
	}

	static sync(Closure closure) {
		LockingTransaction.runInTransaction(closure)
	}

	static dosync(Object... expresions) {
		sync { doall(expresions) }
	}

	static doall(Object... expresions) {
		def result
		expresions.each { result = it instanceof Callable ? it.call() : it }
		result
	}

    static Namespace namespace(String ns) {
        Namespace.find(Symbol.intern(null, ns))
    }

    static Namespace namespace(Class clazz) {
        namespace(clazz.name.toLowerCase())
    }
}