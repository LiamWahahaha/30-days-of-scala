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
