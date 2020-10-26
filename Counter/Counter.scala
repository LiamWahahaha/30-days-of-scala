class Counter {
    private var value = 0
    def increment(): Unit = { value += 1 }
    def current = value // enforce current to be called as an accessor method
}
