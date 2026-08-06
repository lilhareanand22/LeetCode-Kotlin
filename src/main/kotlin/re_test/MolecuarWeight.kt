package re_test

import stack_string.molecularWeight
import java.util.HashMap
import java.util.Stack

fun main() {
    val formula = "Mg(OH)2"
    val totalWeight = molecularWeight(formula)

    println("Molecular weight of $formula: $totalWeight")
}

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
    while(i < formula.length) {
        when {
            formula[i].isUpperCase() -> {
                val atom = StringBuilder()
                atom.append(formula[i])
                i++
                if(i < formula.length && formula[i].isLowerCase()) {
                    atom.append(formula[i])
                    i++
                }
                var count = 0
                if(i<formula.length && formula[i].isDigit()) {
                    count = count * 10 + (formula[i] - '0')
                    i++
                }
                if(count == 0) {
                    count = 1
                }
                currentMap[atom.toString()] = currentMap.getOrDefault(atom.toString(), 0) + count
            }
          formula[i] == '(' -> {
              stack.push(currentMap)
              currentMap = HashMap()
              i++

          }
         formula[i] == ')' -> {
             i++
             var multiplier = 0
             if(i < formula.length && formula[i].isDigit()) {
                 multiplier = multiplier * 10 + (formula[i] - '0')
             }
             if(multiplier == 0) {
                 multiplier = 1
             }
            for((atom, count) in currentMap)  {
               currentMap[atom] = count * multiplier
            }
            val previousMap = stack.pop()
             for((atom, count) in currentMap)  {
                 previousMap[atom] = previousMap.getOrDefault(atom, 0) + count
             }
             currentMap = previousMap
         }
        }
    }
    var totalWeight = 0

    for ((atom, count) in currentMap) {
        totalWeight += weight[atom]!! * count
    }

    return totalWeight

}