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
    var stacks=ArrayDeque<Int>()
    var maxStacks=ArrayDeque<Int>()
    var results=mutableListOf<Int>()
    
    for(op in operations){
        var type=op.split(" ")
        
        when(type[0]){
            "1"->{
                var value=type[1].toInt()
                stacks.addFirst(value)
                if(maxStacks.isEmpty() || value>=maxStacks.first()){
                    maxStacks.addFirst(value)
                }
            }
            "2"->{
                var remove=stacks.removeFirst()
                if(maxStacks.isNotEmpty() && remove==maxStacks.first()){
                    maxStacks.removeFirst()
                }
            }
            "3"->{
                results.add(maxStacks.first())
            }
        }
    }
    return results.toTypedArray()
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
