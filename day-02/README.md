# Control Structures and Functions

## Conditional Expressions
* Scala
```
val s = if (x > 0) 1 else -1
```
is equivalent to
```
if (x > 0) s = 1 else s = -1
```
**In Scala, every expression is supposed to have some value**
```
if (x > 0) 1
```
is equivalent to
```
if (x > 0) 1 else ()
```
Treat () as a placeholder for 'no useful value'

```
if (x > 0) {
    1
} else if (x == 0) {
    0
} else {
    -1
}
```

* Python
```
s = 1 if x > 0 else -1
```
```
if x > 0:
    1
elif x == 0:
    0
else:
    -1
```

## Statement Termination
* Use semicolon to separate statements
```
if (n > 0) { r = r * n; n -= 1 }
```
is equivalent to
```
if (n > 0) {
    r = r * n
    n -= 1
}
```
* Use // to tell the parser that this i not the end
```
s = s0 + (v - v0) * t + //
    0.5 * (a - a0) * t * t
```

## Block Expressions and Assignments
* A { } block contains a sequence of expressions
* The value of the block is the value of the last expression
```
val distance = { val dx = x - x0; val dy = y - y0; **sqrt(dx * dx + dy * dy)** }
```
* A block that ends with an assignment has a **Unit** value
```
{ r = r * n; n -= 1 }
```

## Input and Output
* Print with string interpolation
```
print(f"Hello, $name! In six months, you'll be ${age + 0.5}%7.2f years old.%n")
```
* Formatted strings are one of three predefined string interpolators in the Scala library
  * With a prefix of s, strings can contain expressions but not format directives
  * With a prefix of raw, escape sequences in a string are not evaluated
  * To include a $ sign in an interpolated string, double it
 ```
 s"$$$price"
 ```
* Read a line of input from the console with the **readLine** method of the **scala.io.StdIn** class.
* To read a numeric value use **readInt**, **readDouble**, **readByte**, **readShort**, **readLong**, **readFloat**
* To read a Boolean value use **readBoolean**
* To read character value use **readChar**
```
import scala.io
val name = StdIn.readLine("Your name: ")
print("Your age: ")
val age = StdIn.readInt()
println(s"Hello, ${name}! Next year, you will be ${age + 1}.")
```

## Loops
* While loop
```
while (n > 0) {
    r = r * n
    n -= 1
}
```
* For loop
```
for (i <- 1 to n) {
    r = r * i
}
```
* The call 1 to n returns a Range of the numbers from 1 to n inclusively.
* **In Scala, loops are not used as often as in other languages.**
* **Scala has no break or continue statements to break out of a loop**
  * Use a Boolean control variable, or
  * Use nested functions - we can return from the middle of a function, or
  * Use the break method in the Breaks object. The control transfer is done by throwing and catching an exception.
    * This mechanism could be an issue when time is of essence.
    
## Advanced for Loops
* Scala provides multiple generators of the form variable <- expression. Separate each generator by semicolons.
```
for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d")
// Prints 11 12 13 21 22 23 31 32 33
```
```
for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d")
// Prints 12 13 21 23 31 32
```
* We can have any number of definitions
```
for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d")
// Prints 13 22 23 31 32 33
```
* When the body of the for loop starts with yield, the loop constructs a collection of values
```
for (i <- 1 to 10) yield i %3
// Yields Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
```

## Functions
* A method operates on an object, but a function doesn't
```
def abs(x: Double) = if (x >= 0) x else -x
```
```
def fac(n: Int) {
    var r = 1
    for (i <- 1 to n) r = r * i
    r
}
```
* There is no need for the **return** keyword.
* It's possible to use **return** as in Java or C++ to exit a function immediately
  * This is not commonly done in Scala.
* With a recursive function, we must specify the **return** type.
```
def fac(n: Int): Int = if (n <= 0) else n * fac(n - 1)
```

## Default and Named Argument
```
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
```
```
decorate("Hello", right="]<<<") // Valid, Calls decorate("Hello", "[", "]<<<")
decorate("Hello", "<<<", ">>>") // Valid
decorate(left="<<<", str="Hello", right=">>>") // Valid
```

## Variable Arguments
```
def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
}
```
```
val s = sum(1, 4, 9, 16, 25)
val s = sum(1 to 5) // Error
```

## Procedures
* If the function body is enclosed in braces without a preceding = symbol, then the return type is Unit.
* Such a function is called a procedure.
* A procedure returns no value.

## Lazy Values
* When a val is declared as lazy, its initialization is deferred until it is accessed for the first time
* Lazy values are useful to delay costly initialization statements
* We can think of lazy values as halfway between val and def
* Laziness is not cost-free
  * whether the value has already been initialized, every time a lazy value is accessed, a method is called that checks in a threadsafe manner
  
## Exceptions
* Work the same way as in Java or C++ => throw an exception
* try and catch
  * As in Java or C++, the more general exception types should come after the more specific ones

## Exercises
1. 
```
def signum(num: Double) = if (num > 0) 1 else if (num < 0) -1 else 0
```

2.
val is () and type is Unit

3.
```
var y: Int = 0
val x: Unit = y = 1
```

4.
```
for (i <- 1 to 10) println(10-i)
for (i <- 10 to (0, -1)) println(i)
```

5.
```
def countdown(n: Int): Unit = {
    for (idx <- n to (0, -1)) {
        println(idx)
    }
}
```
```
countdown(5)
\\ 5
\\ 4
\\ 3
\\ 2
\\ 1
\\ 0
```
