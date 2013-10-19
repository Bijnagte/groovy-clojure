groovy-clojure
=========================================
*a Groovy to Clojure bridge*
----------------------------
[![Build Status](https://travis-ci.org/Bijnagte/groovy-clojure.png)](https://travis-ci.org/Bijnagte/groovy-clojure)

Goal
-------------
To create a two-way interoperability between Groovy and Clojure and primarily create the capability for working with the core Clojure library from Groovy, but
secondly to offer the key integration ability of being able to use Groovy closures as functions within Clojure.  Having two-way interoperability is important 
because most developers are not doing green field work and thus have to apply a phased and risk-managed approach towards using Clojure in real projects. 
Language choice is a highly technical matter and it is often politically infeasible to make a strong argument for adopting a non-Java language until concrete examples
can be demonstrated as to why making such a change is valuable.  It is also financially infeasible to justify investment in the re-writing of existing applications 
in order to follow functional programming principles.  So what can we do?  We can make it easier for development teams to add Clojure in their projects, 
and that makes it less risky for them to experiment with true functional programming and lower the bar towards mainstream acceptance.


Why Clojure?
-------------
Clojure's functional programming capabilities are highly desirable.  The original interest in developing this library was to
be able to utilized Clojure's truly immutable, persistent data structures in our applications.  While other libraries such as Guava do offer immutable 
collections, Clojure stands out in terms of memory optimization in the sense that they are truly persistent.

In addition to having the best functional collections available on the JVM, Clojure offers excellent concurrent programming
support via STM, Atoms, Refs, and Agents.

EDN is a highly-advantageous serialization mechanism that has superior characteristics as compared to XML, JSON, or YAML.  


How Does it Work?
-------------
It works by leveraging Groovy's Extension Module system, meta-programming, operator overloading, and AST transformation capabilities. In other words,
we have dug deeply into Groovy's best features in order to make such inter-operaability quite manageable.

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
