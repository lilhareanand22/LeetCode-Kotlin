package re_test

import stack_string.molecularWeight

fun main() {
    val formula = "C2H4"
    val totalWeight = molecularWeightWithoutBracket1(formula)

    println("Molecular weight of $formula: $totalWeight")
}


fun molecularWeightWithoutBracket1(formula: String): Int {

    val weight = mapOf(
        "H" to 1,
        "C" to 12,
        "O" to 16,
        "N" to 14,
        "S" to 32,
        "Mg" to 24,
        "Na" to 23,
        "Cl" to 35,
        "K" to 39
    )
    var i = 0
    var totalWeith = 0

    while(i < formula.length) {
        val atom = StringBuilder()
        atom.append(formula[i])
        i++
        if(i<formula.length && formula[i].isLowerCase()){
            atom.append(formula[i])
            i++
        }
        var count = 0
        if(i<formula.length && formula[i].isDigit()) {
          count = count * 10 + (formula[i]-'0')
            i++
        }
        if(count == 0) {
            count = 1
        }
        totalWeith +=  count
    }

    return totalWeith

}