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
 * Complete the 'twoStacks' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER maxSum
 *  2. INTEGER_ARRAY a
 *  3. INTEGER_ARRAY b
 */

fun twoStacks(maxSum: Int, a: Array<Int>, b: Array<Int>): Int {
    // Write your code here
    var i=0
    var j=0
    var sum=0
    var maxValue=0 
    
    while(i<a.size && a[i]+sum<=maxSum){
        sum+=a[i]
        i++
    }
    
    maxValue=i
    
    while(j<b.size){
        sum+=b[j]
        j++
        
        while(sum>maxSum && i>0){
            i--
            sum-=a[i]
        }
        
        if (sum<=maxSum){
            maxValue=maxOf(maxValue,i+j)
        }
    }
    return maxValue
}

fun main(args: Array<String>) {
    val g = readLine()!!.trim().toInt()

    for (gItr in 1..g) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val maxSum = first_multiple_input[2].toInt()

        val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = twoStacks(maxSum, a, b)

        println(result)
    }
}
