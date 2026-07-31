package arrays.hashing

fun main() {

}

fun isAnagram(s:String, t:String) : Boolean {
    val map = hashMapOf<Char, Int>()

    if(s.length != t.length) {
        return false
    }

    for (c in s) {
        map [c] = map.getOrDefault(c,0) + 1
    }

    for (ch in t) {
       if(!map.containsKey(ch)) {
           return false
       }
       map[ch] = map[ch]!! - 1
       if(map[ch]!! < 0) {
           return false
       }
    }
    return true
}