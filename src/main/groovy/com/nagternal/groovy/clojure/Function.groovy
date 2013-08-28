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

import clojure.lang.IFn
import clojure.lang.ISeq
import clojure.lang.Var

class Function extends Closure implements IFn {

    final Closure closure

    Function(Closure closure) {
        super(closure.owner, closure.thisObject)
        this.closure = closure
    }

    Object call() {
        closure.call()
    }

    Object call(Object... args) {
        closure.call(* args)
    }

    Object invoke() {
        closure.call()
    }

    Object invoke(Object arg1) {
        closure.call(arg1)
    }

    Object invoke(Object arg1, Object arg2) {
        closure.call(arg1, arg2)
    }

    Object invoke(Object arg1, Object arg2, Object arg3) {
        closure.call(arg1, arg2, arg3)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        closure.call(arg1, arg2, arg3, arg4)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13, Object arg14) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16, Object arg17) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16, Object arg17, Object arg18) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17,
                arg18)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16, Object arg17,
                  Object arg18, Object arg19) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17,
                arg18, arg19)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16, Object arg17,
                  Object arg18, Object arg19, Object arg20) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17,
                arg18, arg19, arg20)
    }

    Object invoke(Object arg1, Object arg2, Object arg3, Object arg4,
                  Object arg5, Object arg6, Object arg7, Object arg8, Object arg9,
                  Object arg10, Object arg11, Object arg12, Object arg13,
                  Object arg14, Object arg15, Object arg16, Object arg17,
                  Object arg18, Object arg19, Object arg20, Object... args) {
        closure.call(arg1, arg2, arg3, arg4,
                arg5, arg6, arg7, arg8, arg9,
                arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17,
                arg18, arg19, arg20, * args)
    }

    Object applyTo(ISeq arglist) {

        // TODO Auto-generated method stub
        null
    }

    static Var define(String name, Closure closure) {
        Class owner = closure.delegate.getClass()
        owner.name.toLowerCase()
        Clj.var(owner.name.toLowerCase(), name, new Function(closure))
    }


    /**
     * Sets the strategy which the closure uses to resolve property references and methods.
     * The default is Closure.OWNER_FIRST
     *
     * @param resolveStrategy The resolve strategy to set
     *
     * @see groovy.lang.Closure#DELEGATE_FIRST
     * @see groovy.lang.Closure#DELEGATE_ONLY
     * @see groovy.lang.Closure#OWNER_FIRST
     * @see groovy.lang.Closure#OWNER_ONLY
     * @see groovy.lang.Closure#TO_SELF
     */
    void setResolveStrategy(int resolveStrategy) {
        closure.resolveStrategy = resolveStrategy
    }

    /**
     * Gets the strategy which the closure users to resolve methods and properties
     *
     * @return The resolve strategy
     *
     * @see groovy.lang.Closure#DELEGATE_FIRST
     * @see groovy.lang.Closure#DELEGATE_ONLY
     * @see groovy.lang.Closure#OWNER_FIRST
     * @see groovy.lang.Closure#OWNER_ONLY
     * @see groovy.lang.Closure#TO_SELF
     */
    int getResolveStrategy() {
        closure.resolveStrategy
    }

    Object getThisObject() {
        closure.thisObject
    }

    Object getProperty(final String property) {
           closure.getProperty(property)
    }

    void setProperty(String property, Object newValue) {
        closure.setProperty(property, newValue)
    }

    /**
     * @return the owner Object to which method calls will go which is
     *         typically the outer class when the closure is constructed
     */
    Object getOwner() {
        closure.owner
    }

    /**
     * @return the delegate Object to which method calls will go which is
     *         typically the outer class when the closure is constructed
     */
    Object getDelegate() {
        closure.delegate
    }

    /**
     * Allows the delegate to be changed such as when performing markup building
     *
     * @param delegate the new delegate
     */
    void setDelegate(Object delegate) {
        closure.delegate = delegate
    }

    /**
     * @return the parameter types of the longest doCall method
     * of this closure
     */
    Class[] getParameterTypes() {
        closure.parameterTypes
    }

    /**
     * @return the maximum number of parameters a doCall method
     * of this closure can take
     */
    int getMaximumNumberOfParameters() {
        closure.maximumNumberOfParameters
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    void run() {
        call()
    }


}