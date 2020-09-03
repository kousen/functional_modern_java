## Topics:

* Lambda expressions
* Method references
* Streams
* Optional
* Lazy streams
* Deferred execution
* The `peek` method
* `map` vs `flatMap`
* Closure composition
* The `reduce` method
* File I/O
* Partitioning and grouping
* Downstream collectors
* Parallel streams
* Exception handling
* The `java.time` package

## Parallel streams

For parallelization to be beneficial:

* Either a _lot_ of data, or a process that takes a lot of time per element
* Data that is easy to partition
* Stateless and associative operations

_Don't do anything stateful in parallel_

Books:

* _Modern Java Recipes_, me, O'Reilly Media,
https://www.amazon.com/Modern-Java-Recipes-Solutions-Difficult/dp/149197317X

* _Modern Java in Action_, Urma, Fusco, and Mycroft, Manning, https://www.manning.com/books/modern-java-in-action

* _Java SE 8 for the Really Impatient_, Horstmann, Addison-Wesley, https://horstmann.com/java8/

* _Functional Programming in Java_, Subramaniam, Pragmatic Bookshelf, https://www.safaribooksonline.com/library/view/functional-programming-in/9781941222690/