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


## Properties with Getters and Setters

## Object-Private Fields

## Bean Properties
