# Class
* Key points:
  * Fields in classes automatically come with getters and setters.
  * We can replace  field with a custom getter/setter without changing th client of a class - that is th "uniform access principle."
  * Use the @BeanProperty annotation t generate the JavaBeans getXxx/setXxx methods.
  * Every class has a primmary constructor that is "interwoven" with th class definition.
    * Its parameters turn into th fields of the class.
    * The primary constructor executes all statements in th body of the class.
  * Auxiliary constructors are optional.

## Simple Classes and Parameterless Methods
* In Scala, a clas i not declared as **public**.
* A scala sourc file can contaiun multiple classes, and all of them have public visibility.
* It is considered good style to use () for a **mutator** method, and drop the () for an **accessor** method.
* A parameterless method can be called with or without parentheses.

## Properties with Getters and Setters and Properties with Only Getters
* Getters and setters are better than pubblic fields beccause they let us start with simple get/set semantics and evolve them as needed.
* Just because getters and setters are better than pubblic fields doesn't mean they are always good.
  * It is plainly bad if every client can get or set bits and peces of an object's state.
* Scala provides getter and setter methodds for every field.
* If the field is private, the getter and setter are private.
* If the field is a val, only a getter is generated.
* If we don't want any getter or setter, declare the field as private[this].
* There are four choices for implementing properties:
  * var foo: Scala synthesizes a getter and a setter.
  * val foo: Scala synthesizes a getter.
  * define methods foo and foo_=.
  * define a method foo.
* In scala, it is impossible to have a write-only property.
* When see a field in a Scala class, remeber that it is not the same as a field in Java or C++.
  * It is a private field together with a getter (for a val field) or a getter and a setter (for a var field).

## Object-Private Fields
* A method can access th private fields of all objects of its class. For example,
```
class Counter {
    private var value = 0
    def increment():Unit = { valu += 1 }
    
    def isLess(other : Counter) = value < other.value // Can access private field of other object
}
```
* Use private[this] qualifier to have a more severe access restriction:
```
class Counter {
    private[this] var value = 0
    def increment():Unit = { valu += 1 }
    
    def isLess(other : Counter) = value < other.value // Can access private field of other object
}
```
Now the methods of the Counter class can only access the value field of the current object, not of other objects of type Counter.
* For an object-private field, no getters and setters are generated at all.
* For a class-private field, Scala generates private getter and setter methods.

## Beab Properties
```
import scala.beans.BeanProperty

class Person {
    @BeanProperty var name: String = _
}
```
generates four methods:
1. name: String
2. name_=(newValue: String): Unit
3. getName(): String
4. setName(newValue: String): Unit

## Auxiliary Constructors
* The auxiliary constructors are called **this**.
* Each auxiliary constructor must start with a call to a previously defined auxiliary constructor or the primary constructor.
```
:load AuxiliaryConstructors/Person.scala

val p1 = new Person // Primary.constructor
val p2 = new Person("Fred") // First auxiliary constructor
val p3 = new Person("Fred", 30) // Second auxiliary constructor
```

## The Primary Constructor
* Every class has a primary constructor.
* The parameters of the primary constructor are placed **immediately after the class name**.
```
:load PrimaryConstructor/Person.scala

val p1 = new Person("Fred", 42)
// Just constructed another person
```
* Primary constructor parameters can have any of the forms.
* Construction parameters can also be regular method parameters, without **val** or **var**.
  * If a parameter without **val** or **var** is used inside at least one method, it becomes a field
    * Declares and initializes immutable fields are object-private.
  * Otherwise, the parameter is not saved as a field.
    * It's just a regular parameter that can be accessed in the code of the primary constructor.
    
## Nested Classes
