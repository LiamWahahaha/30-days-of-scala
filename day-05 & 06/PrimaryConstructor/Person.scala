class Person(val name: String, val age:Int) {
    println("Just constructed another person")
    def description = s"$name is $age years old"
    // Parameters of primary constructor in (...)
}
