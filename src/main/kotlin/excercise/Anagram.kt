package excercise



fun main() {
    val s = "anagram"
    val t = "nagaram"

    println(isAnagram(s, t))
}

private fun isAnagram(s:String, t:String) : Boolean {
    val map = mutableMapOf<Char, Int>()
    if(s.length != t.length) {
        return false
    }
   for(ch in s) {
       map[ch]= map.getOrDefault(ch, 0) + 1
   }
   for(ch  in t) {
       if(!map.containsKey(ch)) {
           return false
       }
       map[ch] = map[ch]!! -1
       if(map[ch]!! < 0) {
           return false
       }
   }
    return true

}