groovy-clojure
=========================================
*a Groovy to Clojure bridge*
----------------------------
[![Build Status](https://travis-ci.org/Bijnagte/groovy-clojure.png)](https://travis-ci.org/Bijnagte/groovy-clojure)

Goals
-------------
To provide a Groovy api for working with the core Clojure library that allows Groovy and Clojure code to seamlessly inter-twine

*Immutable persistent data structures
*Usage of Clojure functions from Groovy code
*Usage of Groovy closures as functions from Clojure
*Concurrent programming support via STM, Atoms, Refs, and Agents
*Support for using EDN

Approach
-------------
Leverage Groovy's Extension Module system, meta-programming, operator overloading and AST transformations

Documentation
-------------
##Data Structures
###Maps
###Lists
###Vectors
###Sets

##Functions and Vars
###Groovy closures as Clojure functions
###Define Vars in Groovy

##Concurrency

##EDN
