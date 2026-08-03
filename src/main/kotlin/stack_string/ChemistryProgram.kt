package stack_string

//Chemistry
//Problem Statement
//
//A molecule is represented by a string called formula.
//
//Only the following atoms exist:
//
//Rules:
//
//A digit immediately after an atom multiplies that atom.
//
//Example:
//
//A digit immediately after a closing parenthesis ) multiplies the entire bracketed group.
//
//Example:
//
//means the total weight of CH4 is multiplied by 2.
//
//Parentheses may be nested.
//All multipliers are single-digit integers.
//The formula is guaranteed to be valid.
//
//Return the total molecular weight.


import java.util.Stack
import java.util.HashMap

fun molecularWeight(formula: String): Int {

    // Atomic weights
    val weight = hashMapOf(
        "H" to 1,
        "C" to 12,
        "O" to 16,
        "N" to 14,
        "S" to 32,
        "Mg" to 24,
        "K" to 39
    )

    val stack = Stack<HashMap<String, Int>>()
    var currentMap = HashMap<String, Int>()

    var i = 0

    while (i < formula.length) {

        when {

            // Opening bracket
            formula[i] == '(' -> {

                stack.push(currentMap)
                currentMap = HashMap()
                i++
            }

            // Closing bracket
            formula[i] == ')' -> {

                i++

                var multiplier = 0

                while (i < formula.length && formula[i].isDigit()) {
                    multiplier = multiplier * 10 + (formula[i] - '0')
                    i++
                }

                if (multiplier == 0)
                    multiplier = 1

                // Multiply current group
                for ((atom, count) in currentMap) {
                    currentMap[atom] = count * multiplier
                }

                // Merge into previous group
                val previous = stack.pop()

                for ((atom, count) in currentMap) {
                    previous[atom] =
                        previous.getOrDefault(atom, 0) + count
                }

                currentMap = previous
            }

            // Read atom
            formula[i].isUpperCase() -> {

                val atom = StringBuilder()

                atom.append(formula[i])
                i++

                while (i < formula.length &&
                    formula[i].isLowerCase()) {

                    atom.append(formula[i])
                    i++
                }

                // Read count
                var count = 0

                while (i < formula.length &&
                    formula[i].isDigit()) {

                    count = count * 10 + (formula[i] - '0')
                    i++
                }

                if (count == 0)
                    count = 1

                val atomName = atom.toString()

                currentMap[atomName] =
                    currentMap.getOrDefault(atomName, 0) + count
            }
        }
    }

    // Calculate molecular weight
    var totalWeight = 0

    for ((atom, count) in currentMap) {
        totalWeight += weight[atom]!! * count
    }

    return totalWeight
}


fun molecularWeightWithoutBracket(formula: String): Int {

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
    var totalWeight = 0

    while (i < formula.length) {

        // ------------------------
        // Read atom name
        // ------------------------
        val atom = StringBuilder()

        atom.append(formula[i])
        i++

        while (i < formula.length && formula[i].isLowerCase()) {
            atom.append(formula[i])
            i++
        }

        // ------------------------
        // Read count
        // ------------------------
        var count = 0

        while (i < formula.length && formula[i].isDigit()) {
            count = count * 10 + (formula[i] - '0')
            i++
        }

        if (count == 0)
            count = 1

        // ------------------------
        // Calculate weight
        // ------------------------
        totalWeight += weight[atom.toString()]!! * count
    }

    return totalWeight
}
fun main() {
    val formula = "CH4"
    val atomCounts = molecularWeightWithoutBracket(formula)

    println(atomCounts)
}

