JavaTuples
==========

JavaTuples is a simple java library that provides a set of tuple classes. It provides:

  * A general tuple interface: `io.arxila.javatuples.Tuple`
  * A set of _named_ tuple classes: `Empty`, `Solo`, `Pair`, `Trio`, `Quartet`, `Quintet`, `Sextet`, `Septet`, `Octet`, `Nonet`, `Decet`.
  * A set of _numbered_ tuple classes: `Tuple0`, `Tuple1`, `Tuple2`, `Tuple3`, `Tuple4`, `Tuple5`, `Tuple6`, `Tuple7`, `Tuple8`, `Tuple9`, `Tuple10`.
  * Some common tuple-shaped utility classes: `KeyValue`, `LabelValue`, `MapEntry`.

All tuples are <ins>**immutable**</ins>, and therefore <ins>**thread-safe**</ins>.

JavaTuples is open-source and distributed under the **Apache License 2.0**.

> [!NOTE]
> This library is the new incarnation of the previous `org.javatuples` library which could be found 
> at [javatuples](http://www.javatuples.org). The new library starts in version 2.x and is a complete rewrite of 
> the previous one, breaking backwards compatibility. 


Requirements
------------

JavaTuples requires **Java 17**.


Tuples? What are tuples?
------------------------

A tuple is just a sequence of objects that do not necessarily relate to each other in any way. For
example: [23, "Saturn", java.sql.Connection@li734s] can be considered a tuple of three elements (a triple,
or _trio_) containing an Integer, a String, and a JDBC Connection object. As simple as that.
