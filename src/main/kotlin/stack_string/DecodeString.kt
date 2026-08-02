package stack_string

import java.util.Stack

fun main() {
    val s = "3[a2[c]]"
    println(decodeString(s))
}

fun decodeString(s:String) : String {
    val numberStack = Stack<Int>()
    val stringStack = Stack<String>()

    var currentNumber = 0
    var currentString = StringBuilder()

    for (ch in s) {
        when {
            ch.isDigit() -> {
                currentNumber = currentNumber * 10 + (ch - '0')
            }

            ch == '[' -> {
                numberStack.push(currentNumber)
                stringStack.push(currentString.toString())
                currentNumber = 0
                currentString = StringBuilder()

            }

            ch == ']' -> {
                val repeat = numberStack.pop()
                val previous = stringStack.pop()
                val temp = StringBuilder(previous)
                repeat(repeat) {
                    temp.append(currentString)
                }
                currentString = temp
            }
            else ->  {
                currentString.append(ch)
            }

        }
    }
  return currentString.toString()
}