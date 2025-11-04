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
 * Complete the 'getMax' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY operations as parameter.
 */

fun getMax(operations: Array<String>): Array<Int> {
    // Write your code here
    val stack=ArrayDeque<Int>()
    val maxStack=ArrayDeque<Int>()
    val result=mutableListOf<Int>()
    
    for (op in operations){
        val parts=op.split(" ")
        when(parts[0]){
            "1"->{
                val x=parts[1].toInt()
                stack.addLast(x)
                if(maxStack.isEmpty() || x>=maxStack.last()){
                    maxStack.addLast(x)
                }
            }
            "2"->{
                if(stack.isNotEmpty()){
                    val removed=stack.removeLast()
                    if(removed==maxStack.last()){
                        maxStack.removeLast()
                    }
                }
            }
            "3"->{
                result.add(maxStack.last())
            }
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ops = Array<String>(n, { "" })
    for (i in 0 until n) {
        val opsItem = readLine()!!
        ops[i] = opsItem
    }

    val res = getMax(ops)

    println(res.joinToString("\n"))
}
