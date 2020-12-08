package material.classExamples

class PrettyWoman(private var weigth: Float, private var height: Float, private var age: Int) {
    val isPretty: Boolean
        get() {
            return weigth < 70 && height > 1.6 && age < 35
        }
}