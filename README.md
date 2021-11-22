# Java 8 - Studies

### Lambda Expressions
Lambda expressions provide a clear and concise way to represent one method, interface using an expression. They also make it easier to iterate through, filter and extract data from a collection using streams.

#### Functional Interfaces
An interface that contains <b>at most 1 abstract function</b> or method. Ex:
* <b>Supplier</b>: do not accept arguments, produces a result.
* <b>Consumer</b>: accepts 1 argument, no return value.
* <b>BiConsumer</b>: accepts 2 arguments, no return value.
* <b>Predicate</b>: takes 1 argument, returns a boolean.
* <b>BiPredicate</b>: takes 2 arguments, retuns a boolean.
* <b>Function</b>: accepts 1 argument, produces a result.
* <b>BiFunction</b>: accepts 2 arguments, produces a result.
* <b>UnaryOperator</b>: take a single argument, with a single return value. All of them must be of the same type.
* <b>BinaryOperator</b>: takes 2 arguments, and return one single value. All of them must be of the same type.

