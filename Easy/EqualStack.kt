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
    var s1=ArrayDeque<Int>()
    var s2=ArrayDeque<Int>()
    var s3=ArrayDeque<Int>()
    
    for (i in h1){
        s1.addLast(i)
    }
    for (i in h2){
        s2.addLast(i)
    } 
    for (i in h3){
        s3.addLast(i)
    }
    
    var sum1=s1.map { it }.sum()
    var sum2=s2.map { it }.sum()
    var sum3=s3.map { it }.sum()
    
    while(!(sum1==sum2 && sum2==sum3)){
        when{
            sum1>=sum2 && sum1>=sum3 -> sum1-=s1.removeFirst()
            sum2>=sum1 && sum2>=sum3 -> sum2-=s2.removeFirst()
            sum3>=sum1 && sum3>=sum2 -> sum3-=s3.removeFirst()
        }
    } 
    return sum1
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
