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
 * Complete the 'equalStacks' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY h1
 *  2. INTEGER_ARRAY h2
 *  3. INTEGER_ARRAY h3
 */

fun equalStacks(h1: Array<Int>, h2: Array<Int>, h3: Array<Int>): Int {
    // Write your code here
    var stacksH1=ArrayDeque<Int>()
    var stacksH2=ArrayDeque<Int>()
    var stacksH3=ArrayDeque<Int>()
    
    for (i in h1){
        stacksH1.addFirst(i)
    }
    for (i in h2){
        stacksH2.addFirst(i)
    }
    for(i in h3){
        stacksH3.addFirst(i)
    }
    
    var totalSum1=stacksH1.map { it }.sum()
    var totalSum2=stacksH2.map { it }.sum()
    var totalSum3=stacksH3.map { it }.sum()
    
    while(!(totalSum1==totalSum2 && totalSum2==totalSum3)){
        when{
            totalSum1>=totalSum2 && totalSum1>=totalSum3 -> totalSum1-=stacksH1.removeLast()
            
            totalSum2>=totalSum1 && totalSum2>=totalSum3 -> totalSum2-=stacksH2.removeLast()
            
            totalSum3>=totalSum1 && totalSum3>=totalSum2 -> totalSum3-=stacksH3.removeLast()
        }
    }
    return totalSum1
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n1 = first_multiple_input[0].toInt()

    val n2 = first_multiple_input[1].toInt()

    val n3 = first_multiple_input[2].toInt()

    val h1 = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val h2 = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val h3 = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = equalStacks(h1, h2, h3)

    println(result)
}
