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

/**
 *
 */
package com.nagternal.groovy.clojure

import clojure.lang.*
import org.codehaus.groovy.runtime.DefaultGroovyMethods
import org.codehaus.groovy.runtime.StringGroovyMethods

/**
 * @author Dylan
 *
 */
class ClojureExtension {

    static call(IFn self, Object... args) {
        self.invoke(* args)
    }

    static Function asFn(Closure self) {
        new Function(self)
    }

    static <T> T asType(Closure self, Class<T> clazz) {
        if (clazz == Function || clazz == IFn) {
            asFn(self)
        } else {
            DefaultGroovyMethods.asType(self, clazz)
        }
    }

    static <T> T asType(String self, Class<T> clazz) {
        if (clazz == Keyword) {
            keyword(self)
        } else {
            StringGroovyMethods.asType(self, clazz)
        }
    }

    static Keyword keyword(String self) {
        Keyword.intern(self)
    }

    static Keyword keyword(String self, Object owner) {
        keyword(owner.getClass(), self)
    }

    static Keyword keyword(String self, Class namespace) {
        Keyword.intern(namespace.name.toLowerCase(), self)
    }

    static Map<Keyword, Object> keyword(Map<String, Object> self) {
        self.collectEntries { key, value ->
            [keyword(key), value]
        }
    }
    @SuppressWarnings('ImplementationAsType')//PersistentHashMap implements Map also
    static IObj withMeta(IObj self, HashMap<String, Object> meta) {
        IPersistentMap keywordMeta = DataStructureExtension.persistent(meta.collectEntries { key, val ->
            [keyword(key), val]
        })
        self.withMeta(keywordMeta)
    }

    static IObj xor(IObj self, Map<String, Object> meta) {
        withMeta(self, meta)
    }

    static IObj xor(IObj self, IPersistentMap meta) {
        self.withMeta(meta)
    }

    static edn(String self) {
        EdnReader.readString(self, PersistentHashMap.EMPTY)
    }

    static edn(String self, IPersistentMap opts) {
        EdnReader.readString(self, opts)
    }

    static edn(Reader self) {
         EdnReader.read(new PushbackReader(self), PersistentHashMap.EMPTY)
    }

    static edn(Reader self, IPersistentMap opts) {
        EdnReader.read(new PushbackReader(self), opts)
    }
}
