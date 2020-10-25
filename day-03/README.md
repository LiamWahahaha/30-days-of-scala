# Data Structure -  All about Array

## Key points:
* Use an **Array** i th lenggth is fixed, and an **ArrayBuffer** i the length can vary.
* Don't use **new** whe supplyingg initial values.
* Use () instead of [] to access elements.
* Use for (elem <- arr) to traverse th elements.
* Use for (elem <- arr if ...) ... yield ... to transform into a new array.
* Scala and Java arrays are interoperable; with **ArrayBuffer**, use scala.collection.JavaConversions.

## Fixed-Length Arrays
```
val nums = new Array[Int](10) // An array of ten integers, all initialized with zero
```
```
val a = new Array[String](10) // A strin array with ten elements, all initialized with null
```
```
val s = Array("Hello", "World") // An Array[String] of length 2  the type is inferred
```
```
s(0) = "Goodbye" // now the Array is Array("Goodbye", "World")
```
```
val int_array = Array(2, 3, 5, 7, 11)
for (elem <- int_array) println(elem)
// 2
// 3
// 5
// 7
// 11
```
* A Scala Array i implemented as a Java array.

## Variable-Length Arrays: Array Buffers
```
import scala.collection.mutable.ArrayBuffer
val buffer = ArrayBuffer[Int]()
// Or new ArrayBuffer[Int]
```
* Append element to buffer
```
buffer += 1 // ArrayBuffer(1)
```
```
buffer += (1, 2, 3, 5) // ArrayBuffer(1, 1, 2, 3, 5)
// deprecated function, use `++=`(addAll) instead of `+=`
```
```
buffer ++= Array(8, 13, 21) // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)
```
* Insert element (Not as efficient as append)
```
buffer.insert(2, 6) // ArrayBuffer(1, 1, 6, 2, 3, 5, 8, 13, 21)
buffer.insert(2, 7, 8, 9) // ArrayBuffer(1, 1, 7, 8, 9, 6, 2, 3, 5, 8, 13, 21)
```
* Remove element (Not as efficient as trimEnd or trimStart)
```
buffer.remove(2) // ArrayBuffer(1, 1, 8, 9, 6, 2, 3, 5, 8, 13, 21)
buffer.remove(2, 3) // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)
```
* Method: trimEnd, trimStart
```
buffer.trimEnd(5) // Removes the last five elements => ArrayBuffer(1, 1, 2)
buffer.trimStart(1) // Removes the first elements => ArrayBuffer(1, 2)
buffer trimStart 1 // ArrayBuffer(2)
buffer trimStart 1 // ArrayBuffer()
```
* Method: trimToSize
This method is used to trim an ArrayList instance to the number of elements it contains.
* Convert ArrayBuffer to Array
```
buffer.toArray
```
* Convert Array to ArrayBuffer
```
val arr = Array(1, 2, 3)
arr.toBuffer
```

## Traversing Arrays and Array Buffers
* Use **until** method to traverse an Array or Array Buffer. **until** will excludes the last value
```
for (i <- 0 until a.length)
    println(s"$i: ${a(i)}")
```
or
```
for (i <- a.indices)
    println(s"$i: ${a(i)}")
```
* To visit every second element
```
for (i <- 0 until a.length by 2)
```
* To visit the elements startingg from the end of the array
```
for (i <- 0 until a.length by -1) // not working
for (i <- a.length - 1 to 0 by -1)
```
or
```
for (i <- a.indices.reverse)
```

## Transforming Arrays
```
val a = Array(2, 3, 5, 7, 11)
val result = for (elem <- a) yield 2 * elem
// result is Array(2, 6, 10, 14, 22)
```
* To double every even elemnt and drop the odd ones:
```
for (elem <- a i elem % 2 == 0) yield 2 * elem
```
or
```
a.filter(_ % 2 == 0).map(2 * _)
```
or
```
a.filter { _ % 2 == 0 } map { 2 * _ }
```
* To remove all negative elements from an array buffer of integers
```
var n = a.length
var i = 0
while (i < n) {
    if (a(i) >= 0) i += 1
    else { a.remove(i); n -= 1 }
}
```
a better alternative
```
val result = for (elem <- a if elem >= 0) yield elem
```
* What if we want to modify the original array buffer instead?
```
val positionsToRemove = for (i <- a.indices if a(i) < 0) yield i
for (i <- positionsToRemove.reverse) a.remove(i)
```
or
```
val positionsToKeep = for (i <- a.indices if a(i) >= 0) yield i
for (j <- positionsToKeep.indices) a(j) = a(positionsToKeep(j))
a.trimEnd(a.length - positionsToKeep.length)
```
**It's better to have all index values together instead of seeing them one by one**

## Common Algorithms
* A large percentage of business computations are nothing but computing sums and sorting.
* Trivial built-in functions
  * sum, max, min
* Nontrivial built-in functions
  * sorted
    * sorts an array or array buffer and **returns** the sorted array or array buffer without modifying the original
    ```
    val b = ArrayBuffer(1, 7, 2, 9)
    val bSorted = b.sorted
    // b is unchanged; bSorted is ArrayBuffer(1, 2, 7, 9)
    ```
    * descending order
    ```
    val bDescending = b.sortWith(_ > _)
    // ArrayBuffer(9, 7, 2, 1)
    ```
  * sort an array in place **(can not sort an array buffer in place)**
  ```
  val a = Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(a)
  // a is now Array(1, 2, 7, 9)
  ```
  ```
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer[Int]()
  b ++= Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(b)
  // error: ... cannot be applied to (scala.collection.mutable.ArrayBuffer[Int])
  ```
* For the min, max, quickSort methods, the element type must have a comparison operation.
  * This is the case for numbers, strings, and other types with the **Ordered** trait.
* mkString **(similar to python's join function)**
```
a.mkString(" and ")
// "1 and 2 and 7 and 9"
```
  * can give prefix and suffix too
  ```
  a.mkString("<", ",", ">")
  // "<1,2,7,9>"
  ```
* toString
  * use toString on an Array => not very useful
  * use toString on an ArrayBuffer => the toString method will report the type, which is useful for debugging

## Deciphering Scaladoc
* Check the book (p.42 - 43)

## Multidimensional Arrays
* To construct an n-d array
```
val matrix = Array.ofDim[Double](3, 4) // Three rows, four columns
```
* To access an element
```
matrix(row)(column) = 42
```
* Can make ragged arrays!
```
val triangle = new Array[Array[Int]](10)
for (i <- triangle.indices)
    triangle(i) = new Array[Int](i + 1)
```

## Interoperating with Java (skip until familiar with Java)

## Exercises
