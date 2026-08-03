package stack_string

import java.util.Stack

fun main() {
    val formula = "Mg(OH)2"
    val atomCounts = countOfAtoms(formula)

    println(atomCounts)
}

fun parseSimpleFormula(formula: String): HashMap<String, Int> {

    val map = HashMap<String, Int>()

    var i = 0

    while (i < formula.length) {

        // Parse atom
        val atom = StringBuilder()
        atom.append(formula[i])
        i++

        while (i < formula.length && formula[i].isLowerCase()) {
            atom.append(formula[i])
            i++
        }

        // Parse count
        var count = 0

        while (i < formula.length && formula[i].isDigit()) {
            count = count * 10 + (formula[i] - '0')
            i++
        }

        if (count == 0)
            count = 1

        map[atom.toString()] = map.getOrDefault(atom.toString(), 0) + count
    }

    return map
}

fun countOfAtoms(formula: String): String {

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

                // Read multiplier
                var multiplier = 0

                while (i < formula.length && formula[i].isDigit()) {
                    multiplier = multiplier * 10 + (formula[i] - '0')
                    i++
                }

                if (multiplier == 0)
                    multiplier = 1

                // Multiply current map
                for ((atom, count) in currentMap) {
                    currentMap[atom] = count * multiplier
                }

                // Merge with previous map
                val previousMap = stack.pop()

                for ((atom, count) in currentMap) {
                    previousMap[atom] =
                        previousMap.getOrDefault(atom, 0) + count
                }

                currentMap = previousMap
            }

            // Atom name
            formula[i].isUpperCase() -> {

                val atom = StringBuilder()

                atom.append(formula[i])
                i++

                // Read lowercase letters
                while (i < formula.length && formula[i].isLowerCase()) {
                    atom.append(formula[i])
                    i++
                }

                // Read count
                var count = 0

                while (i < formula.length && formula[i].isDigit()) {
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

    // Sort atom names
    val sortedAtoms = currentMap.keys.sorted()

    val answer = StringBuilder()

    for (atom in sortedAtoms) {

        answer.append(atom)

        val count = currentMap[atom]!!

        if (count > 1) {
            answer.append(count)
        }
    }

    return answer.toString()
}