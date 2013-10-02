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
import org.junit.Test

/**
 * User: Dylan
 * Date: 8/23/13
 */
class DataStructureExtensionTest {
    @Test
    void testAsTypeMap() {
        use(DataStructureExtension) {
            assert ([test: 'val'] as IPersistentMap) instanceof IPersistentMap
            assert ([test: 'val'] as PersistentHashMap) instanceof PersistentHashMap
        }
    }

    @Test
    void testPersistentMap() {
        use(DataStructureExtension) {
            IPersistentMap pMap = [test: 'val'].persistent()
            assert pMap instanceof PersistentHashMap
        }
    }

    @Test
    void testPlusMap() {
        use(DataStructureExtension) {
            IPersistentMap pMap = [test: 'val'].persistent()
            IPersistentMap updated = pMap + [second: 'val2']
            assert pMap.size() == 1
            assert updated.size() == 2
            assert updated != pMap
            assert pMap['test'].is(updated['test'])
        }
    }

    @Test
    void testMinusMap() {
        use(DataStructureExtension) {
            def pMap = [first: 'val', second: 'val2'].persistent()
            pMap -= 'second'
            assert pMap.size() == 1
            assert pMap.containsKey('first')
        }
    }

    @Test
    void testListAsTypeVector() {
        use(DataStructureExtension) {
            assert ([1, 'val'] as IPersistentVector) instanceof PersistentVector
            assert ([1, 'val'] as PersistentVector) instanceof PersistentVector
        }
    }

    @Test
    void testPersistentList() {
        use(DataStructureExtension) {
            assert [1, 'val'].persistent() instanceof PersistentVector
        }
    }

    @Test
    void testPlusList() {
        use(DataStructureExtension) {
            IPersistentList list = ['a', 'b'] as IPersistentList
            IPersistentList updated = DataStructureExtension.plus(list, 'c')
            assert list.size() == 2
            assert updated.size() == 3
            ISeq seq = updated.seq()
            assert seq.first() == 'c'
            seq = seq.more()
            assert seq.first() == 'a'
            seq = seq.more()
            assert seq.first() == 'b'
        }
    }

    @Test
    void testPlusVector() {
        use(DataStructureExtension) {
            IPersistentVector vec = ['a', 'b'].persistent()
            IPersistentVector updated = vec + 'c'
            assert vec.size() == 2
            assert updated.size() == 3
            assert updated[0] == 'a'
            assert updated[1] == 'b'
            assert updated[2] == 'c'
        }
    }

    @Test
    void testPlusVectorCollection() {
        use(DataStructureExtension) {
            IPersistentVector vec = ['a', 'b'].persistent()
            IPersistentVector updated = vec + ['c', 'd']
            assert vec.size() == 2
            assert updated.size() == 4
            assert updated[0] == 'a'
            assert updated[1] == 'b'
            assert updated[2] == 'c'
            assert updated[3] == 'd'
        }
    }
}
