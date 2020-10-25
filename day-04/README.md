# Data Structure: Maps and Tuples
* Key points:
  * Scala has a pleasant syntax for creating, querying, and traversing maps.
  * How to choose between mutable and immutable maps?
  * Default is hash map, but can get a tree map.
  * Tuples are useful for aggregating values.
## Constructing a Map
* How to construct a map?
  * Construct a immutable map
  ```
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  // scores: scala.collection.immutable.Map[String, Int] = Map(Alice -> 10, Bob -> 3, Cindy -> 8)
  ```
  or
  ```
  val scores = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
  ```
  * Construct a mutable map
  ```
  val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  // scores: scala.collection.mutable.Map[String, Int] = HashMap(Bob -> 3, Cindy -> 8, Alice -> 10)
  ```
  * Construct a mutable map with a blank map
  ```
  val scores = scala.collection.mutable.Map[String, Int]()
  ```
## Accessing Map Values
* Use the () notation to look up key values. If the map doesn't contain a value for the requested key, an exception is thrown.
```
val bobsScore = scores("Bob")
```
* How to handle exception?
```
val bobsScore = if (scores.contains("Bob")) scores("Bob") else 0
``
or
```
val bobsScore = scores.getOrElse("Bob", 0)
```
## Updating Map Values (mutable map only)
* Update a map value
```
scores("Bob") = 10
```
or
```
scores += ("Bob" -> 7) // can also use (("Bob", 7))
```
* Add a new one
```
scores("Fred") = 7
```
or
```
scores += ("Fred" -> 7)
```
* Add multiple associations
```
scores ++= scala.collection.mutable.Map("Bob" -> 10, "Fred" -> 7)
```
* Remmove a key and its associated value
```
scores -= "Alice"
```
* Can use -= to remove multiple keys (it is legal to remove any unexisting key)
```
scores -= ("Bob", "Fred")
```
* What about immutable map?
## Iterating over Maps
## Sorted Maps
## Interoperating with Java (Skip)
## Tuples
## Zipping
## Exercises
