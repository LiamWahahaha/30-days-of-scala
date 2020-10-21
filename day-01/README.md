# The Basics

## Declaring Values and Variables
* Use **val** to declare a value. This value is a constant.
* Use **var** to declare a variable.
* Don't need to specify the type of a value or variable.

### Rule of Thumb
* Use `val` instead of `var`, unless we really need to change the contents.

## Commonly Used Types
* Numeric types: **Byte**, **Char**, **Short**, **Int**, **Long**, **Float**, **Double**, and **Boolean**.
* Use **method** to convert between numeric types instead of **cast**.
  * 35.toChar => '#'.
  * 99.123.toInt => 99.

## Arithmetic and Operator Overloading
* Operators(+ - * / %) and bit operators(& | ^ >> <<) are actually **methods**.
* Don't have ++ or -- operators.

## More about Calling Methods
* If the method has no parameters, we don't have to use parentheses.
  * "312".toSeq.sorted.unwrap => 123.
  * '312'.toSeq.sorted.unwrap => error: unclosed character literal (or use " not ' for string literal).
  * "312".toSeq.sorted.unwrap() => error: not enough arguments for method apply.
* If a package that starts with scala., we can omit the scala prefix.

## The apply Method
* Occasionally, th () notation conflicts with another Scala feature.
  * "312".toSeq.sorted(1) => error: type mismatch.
  * "312".toSeq.sorted.unwrap.apply(1) => equivalent to ("312".toSeq.sorted.unwrap(1) => 2.
* Using the apply method of a companion object is a common Scala idiom for constructing objects.

## [Scaladoc](https://www.scala-lang.org/api/current/)

## Exercises
1.
![Methods that can be applied...](https://github.com/LiamWahahaha/30-days-of-scala/blob/day-01/day-01/images/methods%20that%20can%20be%20applied%20to%20a%20number.png)
2. 
```
val root = math.sqrt(3)
3 - root * root
```
3.
res variables are val.
