class Person {
    private var name = ""
    private var age = 0

    // An auxiliary constructor
    def this(name: String) {
        this() // Calls primary constructor
        this.name = name
    }

    // Another auxiliary constructor
    def this(name: String, age: Int) {
        this(name) // Calls previous auxiliary constructor
        this.age = age
    }
}
