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

import clojure.lang.*
import org.codehaus.groovy.runtime.DefaultGroovyMethods

/**
 * User: Dylan
 * Date: 8/23/13
 * Time: 8:50 PM
 */
class DataStructureExtension {
    static <T> T asType(Map map, Class<T> clazz) {
        if (clazz == IPersistentMap || clazz == PersistentHashMap) {
            PersistentHashMap.create(map)
        } else if (clazz == PersistentTreeMap) {
            PersistentTreeMap.create(map)
        } else {
            DefaultGroovyMethods.asType(map, clazz)
        }
    }

    static IPersistentMap persistent(Map map) {
        PersistentHashMap.create(map)
    }

    static IPersistentMap plus(IPersistentMap self, Map map) {
        def result
        map.each { k, v ->
            result = self.assoc(k, v)
        }
        result
    }

    static IPersistentMap plus(PersistentHashMap self, Map map) {
        def result
        map.each { k, v ->
            result = self.assoc(k, v)
        }
        result
    }

    static IPersistentMap minus(IPersistentMap self, Object key) {
        self.without(key)
    }

    static <T> T asType(List list, Class<T> clazz) {
        if (clazz == IPersistentVector || clazz == PersistentVector) {
            PersistentVector.create(list)
        } else if (clazz == IPersistentList || clazz == PersistentList) {
            PersistentList.create(list)
        } else if (clazz == IPersistentSet || clazz == PersistentHashSet) {
            PersistentHashSet.create(list)
        } else {
            DefaultGroovyMethods.asType(list, clazz)
        }
    }

    static IPersistentVector persistent(List self) {
        PersistentVector.create(self)
    }

    static IPersistentVector plus(IPersistentVector self, Object value) {
        self.cons(value)
    }

    static IPersistentVector plus(PersistentVector self, Object value) {
        self.cons(value)
    }

    static IPersistentVector plus(PersistentVector self, Collection values) {
        def result = self
        values.each { value ->
            result = result.cons(value)
        }
        result
    }

    static IPersistentList plus(IPersistentList self, Object value) {
        self.cons(value)
    }

    static IPersistentSet persistent(Set self) {
        PersistentHashSet.create(* self)
    }

    static IPersistentSet plus(IPersistentSet self, Object value) {
        self.cons(value)
    }

    static IPersistentSet plus(PersistentHashSet self, Object value) {
        self.cons(value)
    }
}