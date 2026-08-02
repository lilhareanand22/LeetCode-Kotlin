package stack_string

import java.util.Stack

fun main() {
    val s = "([{}])"
    println(" is $s valid parentheses: ${isValidWithArrayDeque(s)}")

}

fun isValid(s:String) : Boolean {
    val stack = Stack<Char>()
    for(c in s) {
        when(c) {
            '(','{','[' -> stack.push(c)

            '}',']',')' -> {
                if(stack.isEmpty())
                    return false

                val top = stack.pop()

                if(c == '}' && top != '{') return false
                if(c == ']' && top != '[') return false
                if(c == ')' && top != '(') return false
            }

        }
    }
    return stack.isEmpty()
}

fun isValidWithArrayDeque(s:String) : Boolean {
    val stack = ArrayDeque<Char>()

    for (ch in s) {

        when (ch) {

            '(', '[', '{' -> stack.addLast(ch)

            ')', ']', '}' -> {

                if (stack.isEmpty())
                    return false

                val top = stack.removeLast()

                if (ch == ')' && top != '(') return false
                if (ch == ']' && top != '[') return false
                if (ch == '}' && top != '{') return false
            }
        }
    }

    return stack.isEmpty()
}