import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isBalanced(s: String): String {
    // Write your code here
    var stack=ArrayDeque<Char>()
    var pairs=mapOf(')' to '(',']' to '[','}' to '{')
    
    for (c in s){
        if(c=='(' || c=='{' || c=='['){
            stack.add(c)
        }
        else{
            if(stack.isEmpty()) return "NO"
            val removedLast=stack.removeLast()
            if(pairs[c]!=removedLast){
                return "NO"
            }
        }
    }
    return if(stack.isEmpty()) "YES" else "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
