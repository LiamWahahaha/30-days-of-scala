# The Basics

## Declaring Values and Variables
* Use **val** to declare a value. This value is a constant.
* Use **var** to declare a variable.
* Don't need to specify the type of a value or variable.

### Rule of Thumb
* Use `val` instead of `var`, unless we really need to change the contents.

## Commonly Used Types
* Numeric types: **Byte**, **Char**, **Short**, **Int**, **Long**, **Float**, **Double**, and **Boolean**
* Use **method** to convert between numeric types instead of **cast**
  * 35.toChar => '#'
  * 99.123.toInt => 99

## Arithmetic and Operator Overloading
* Operators(+ - * / %) and bit operators(& | ^ >> <<) are actually **methods**
* Don't have ++ or -- operators

## More about Calling Methods
* If the method has no parameters, we don't have to use parentheses
  * "312".toSeq.sorted.unwrap => 123
  * '312'.toSeq.sorted.unwrap => error: unclosed character literal (or use " not ' for string literal)
  * "312".toSeq.sorted.unwrap() => error: not enough arguments for method apply
