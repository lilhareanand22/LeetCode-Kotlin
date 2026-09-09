package excercise

import java.util.Stack


fun main() {
    val s = "([{}])"
    println(" is $s valid parentheses: ${isValid(s)}")

}

private fun isValid(s:String) : Boolean {
    val stack = Stack<Char>()
    for(ch in s){
        when(ch) {
            '(','[','{' -> stack.push(ch)
            ')',']','}' -> {
                val  top = stack.pop()
                if(ch == ')' && top !='(') return false
                if(ch == ']' && top !='[') return false
                if(ch == '}' && top !='{') return false
            }
        }
    }

    return stack.isEmpty()
}