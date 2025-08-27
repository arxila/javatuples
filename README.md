JavaTuples
==========

JavaTuples is a simple Java library that provides a set of tuple classes. It includes:

  * A general tuple interface: `io.arxila.javatuples.Tuple`
  * A set of _named_ tuple classes: `Empty`, `Solo`, `Pair`, `Trio`, `Quartet`, `Quintet`, `Sextet`, `Septet`, `Octet`, `Nonet`, `Decet`
  * A set of _numbered_ tuple classes: `Tuple0`, `Tuple1`, `Tuple2`, `Tuple3`, `Tuple4`, `Tuple5`, `Tuple6`, `Tuple7`, `Tuple8`, `Tuple9`, `Tuple10`
  * Some common tuple-shaped utility classes: `KeyValue`, `LabelValue`, `MapEntry`

All tuples are <ins>**immutable**</ins>, and therefore <ins>**thread-safe**</ins>. They are also **iterable**
and **serializable**. Tuples are implemented as Java [records](https://docs.oracle.com/en/java/javase/17/language/records.html).

JavaTuples is open-source and distributed under the **Apache License 2.0**.

> [!NOTE]
> This library is a new incarnation of the previous `org.javatuples` library which could be previously found 
> at [javatuples](https://github.com/javatuples/javatuples). This new library starts at version 2.x, it is a
> complete rewrite of the previous one and it is not backward compatible.


Requirements
------------

JavaTuples requires **Java 17**.


Tuples
------

A tuple is just a sequence of objects that do not necessarily relate to each other in any way. For
example, `[23, "Saturn", java.sql.Connection@li734s]` can be considered a tuple of three elements (a triple,
or _trio_) containing an `Integer`, a `String`, and a JDBC `Connection` object.

JavaTuples offers two types of tuples: **named** and **numbered**. Named tuples have names that represent
their arity (e.g. `Trio`), while numbered tuples include arity in their names (e.g. `Tuple3`). All
tuple implementations reside in the `io.arxila.javatuples` package, and they all implement
the `io.arxila.javatuples.Tuple` interface.

Named tuples are:

  * `Empty` (0 elements)
  * `Solo<A>` (1 element)
  * `Pair<A,B>` (2 elements)
  * `Trio<A,B,C>` (3 elements)
  * `Quartet<A,B,C,D>` (4 elements)
  * `Quintet<A,B,C,D,E>` (5 elements)
  * `Sextet<A,B,C,D,E,F>` (6 elements)
  * `Septet<A,B,C,D,E,F,G>` (7 elements)
  * `Octet<A,B,C,D,E,F,G,H>` (8 elements)
  * `Nonet<A,B,C,D,E,F,G,H,I>` (9 elements)
  * `Decet<A,B,C,D,E,F,G,H,I,J>` (10 elements)

Numbered tuples are:

  * `Tuple0` (0 elements)
  * `Tuple1<A>` (1 element)
  * `Tuple2<A,B>` (2 elements)
  * `Tuple3<A,B,C>` (3 elements)
  * `Tuple4<A,B,C,D>` (4 elements)
  * `Tuple5<A,B,C,D,E>` (5 elements)
  * `Tuple6<A,B,C,D,E,F>` (6 elements)
  * `Tuple7<A,B,C,D,E,F,G>` (7 elements)
  * `Tuple8<A,B,C,D,E,F,G,H>` (8 elements)
  * `Tuple9<A,B,C,D,E,F,G,H,I>` (9 elements)
  * `Tuple10<A,B,C,D,E,F,G,H,I,J>` (10 elements)

Additionally, JavaTuples provides a small set of tuple-shaped utility classes:

  * `KeyValue<K,V>`
  * `LabelValue<L,V>`
  * `MapEntry<K,V>` (implements the `java.util.Map.Entry` interface)


Usage
-----

Library dependency: `io.arxila.javatuples:javatuples:{version}`

From Maven:
```xml
<dependency>
  <groupId>io.arxila.javatuples</groupId>
  <artifactId>javatuples</artifactId>
  <version>{version}</version>
</dependency>
```

### Creating Tuples

Tuples are easy to create using constructors:
```java
// Named tuples
var pair = new Pair<>("Hello", 42);              // pair : Pair<String, Integer>
var trio = new Trio<>("A", "B", "C");            // trio : Trio<String, String, String>

// Numbered tuples 
var tuple2 = new Tuple2<>("Hello", 42);          // tuple2 : Tuple2<String, Integer>
```
Or using static `of(...)` factory methods:
```java
// Named tuples
var pair = Pair.of("Hello", 42);                 // pair : Pair<String, Integer>
var trio = Trio.of("A", "B", "C");               // trio : Trio<String, String, String>

// Numbered tuples 
var tuple2 = Tuple2.of("Hello", 42);             // tuple2 : Tuple2<String, Integer>
```
They can also be created from arrays or lists of the exact size, though in that case, all elements of
the tuple are treated as the same type (the component type of the array or list):
```java
var valuesList = List.of("Hello", 42);           // valuesList: List<Object> (effectively)
var valuesArray = new String[] {"A", "B", "C"};  // valuesArray: String[]
// ...
var pair = Pair.of(valuesList);                  // pair : Pair<Object, Object>
var trio = Trio.of(valuesArray);                 // trio : Trio<String, String, String>
```

### Accessing Values

Values in tuples are numbered from 0 to N-1, and can be accessed using the `valueN()` methods:

```java
// Direct access
String value0 = pair.value0();
Integer value1 = pair.value1();
Long value9 = decet.value9();

// All values as a list
var values = tuple.values();     // values: List<Object>
```
Tuples are also iterable and provide several useful `contains*` methods:

```java
// Iteration
for (final Object value : tuple) {
    // ...do things
}

// Contains methods
if (tuple.contains("Hello")) {...}        // true if a single value is contained in the tuple
if (tuple.containsAll("Hello", 42)) {...} // true if all specified values are contained in the tuple
if (tuple.containsAny(41,4 2)) {...}      // true if any of the specified values are contained in the tuple
```

An `equalsIgnoreOrder()` method is also provided to compare tuples ignoring the order of their values:

```java
if (tuple.equalsIgnoreOrder(otherTuple)) {...}  // true if tuples contain the same values in any order
```

### Modifying Values

Tuples are immutable, but you can create new instances with modified contents using _wither_ methods
(methods that return a new tuple with one value replaced):

```java
var pair = Pair.of("Hello", 42);            // Pair<String,Integer>("Hello", 42)
var newPair = pair.withValue1("World");     // Pair<String,String>("Hello", "World")
```

### Growing and Shrinking

Adding a new element at index N (`withValueN(...)`) will grow the tuple: a new tuple one element
larger is created, with the new element appended.

Removing an element from any index (`withoutValueX(...)`) will shrink the tuple: a new tuple one
element smaller is created, with that element removed.

```java
var pair = Pair.of("Hello", 42);            // Pair<String,Integer>
var trio = pair.withValue2("!");            // Grow to Trio<String,Integer,String>
var solo = pair.withoutValue1();            // Shrink to Solo<String>
```

