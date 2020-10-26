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
