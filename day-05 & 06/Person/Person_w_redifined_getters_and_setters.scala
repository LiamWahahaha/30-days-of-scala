class Person {
    private var privateAge = 0

    def age = privateAge
    def age_=(newValue: Int): Unit = {
        // Can't get younger
        if (newValue > privateAge) privateAge = newValue;
    }
}
