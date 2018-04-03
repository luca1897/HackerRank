package algorithms

import java.util.*
import kotlin.collections.ArrayList

fun gradingStudents(grades : IntArray) : IntArray
{
    val newGrades = IntArray(grades.size)
    for (i in grades.indices)
    {
        val mod = grades[i] % 5
        val newGrade = grades[i] + 5 - mod
        newGrades[i] = grades[i]
        if(newGrade >= 40 && 5 - mod < 3)
            newGrades[i] = newGrade
    }
    return newGrades
}

fun appleAndOrange(houseX0 : Int, houseX1 : Int, appleTreeX : Int, orangeTreeX : Int,
                   appleFallDistance : List<Int>, orangeFallDistance : List<Int>) : IntArray
{
    val res = IntArray(2)
    (0 until appleFallDistance.size)
            .map { appleTreeX + appleFallDistance[it] }
            .forEach {
                if(it in houseX0..houseX1)
                    res[0]++
            }
    (0 until orangeFallDistance.size)
            .map { orangeTreeX + orangeFallDistance[it] }
            .forEach {
                if(it in houseX0..houseX1)
                    res[1]++
            }
    return res
}

fun kangaroo(k1x : Int, k1j : Int, k2x : Int, k2j : Int) : String
{
    var kangaroo1 = k1x
    var kangaroo2 = k2x

    while(kangaroo1 < kangaroo2)
    {
        kangaroo1+=k1j
        kangaroo2+=k2j
        if(kangaroo1==kangaroo2)
            return "YES"
    }
    return "NO"
}

fun betweenTwoSets(a : LongArray, b : LongArray) : Int {
    var mcma = fmcm(a)
    var mcdb = fMCD(b)
    var count = 0
    var i = mcma
    var j = 2
    while (i <= mcdb) {
        if (mcdb % i == 0L) {
            count++
        }
        i = mcma * j
        j++
    }
    return count
}

fun fmcm(a : LongArray) : Long {
    var x = a[0]
    for(i in 1 until a.size)
    {
        x = mcm(x,a[i])
    }
    return x
}

fun fMCD(a : LongArray) : Long {
    var x = a[0]
    for(i in 1 until a.size)
    {
        x = MCD(x,a[i])
    }
    return x
}

fun mcm(a: Long, b: Long) : Long
{
    if(MCD(a,b)>0)
        return (a*b)/MCD(a,b)
    else
        return 0
}

fun MCD(a: Long, b: Long)
        : Long {
    var a = a
    var b = b
    var r: Long
    while (b != 0L)
    {
        r = a % b
        a = b
        b = r
    }
    return a
}

fun breakingTheRecords(g : IntArray) : IntArray
{
    var res = IntArray(2)
    var min = g[0]
    var max = g[0]
    for(i in 1 until g.size)
    {
        if(g[i] < min) {
            min = g[i]
            res[1]++
        }
        else if(g[i] > max) {
            max = g[i]
            res[0]++
        }
    }

    return res
}

fun birthdayChocolate(c : IntArray, numSquares : Int, integerSum : Int) : Int
{
    var res = 0
    if(numSquares == c.size && c[0] == integerSum)
        return 1
    for (i in 0..c.size - numSquares)
    {
        val sum = c.slice(i until i+numSquares).sum()
        if(sum == integerSum)
            res++
    }

    return res
}

fun divisibleSumPairs(ar: IntArray, k: Int): Int {
    var res = 0
    for(i in 0 until ar.size)
    {
        for(j in i until ar.size)
        {
            if(i == j)
                continue
            if(i > j)
                continue
            if((ar[i] + ar[j]) % k == 0)
                res++
        }
    }
    return res
}

fun migratoryBirds(li : ArrayList<Int>) : Int
{
    var t = 0
    var cnt = 0

    for(i in 1..5)
    {
        var c = li.filter { it == i }.size
        if(c > cnt)
        {
            cnt = c
            t = i
        }
    }

    return t
}

fun dayOfTheProgrammer(y : Int) : String
{
    var day = "26"
    if(y > 1918)
        day = if(isLeapGreg(y)) "12" else "13"
    else if (y <= 1917)
        day = if(isLeapGiul(y)) "12" else "13"
    return "$day.09.$y"
}

fun isLeapGreg(y : Int) : Boolean
{
    return (y % 400 == 0 || (y % 100 != 0 && y % 4 == 0))
}

fun isLeapGiul(y : Int) : Boolean
{
    return y % 4 == 0
}

fun bonAppetit(n: Int, k: Int, costs: IntArray, ch: Int): String {
    if(k==0)
        return "Bon Appetit"
    var totalCostShared = 0
    for (i in 0 until costs.size)
    {
        if(i!=k)
            totalCostShared+=costs[i]
    }
    if(totalCostShared/2 == ch)
        return "Bon Appetit"
    else
        return (ch - (totalCostShared/2)).toString()
}



fun implementationStdin()
{
    val scan = Scanner(System.`in`)

    // grading students
    val numGrades = readLine()!!.toInt()
    val grades = IntArray(numGrades)
    for (i in 0 until numGrades)
        grades[i] = readLine()!!.toInt()
    val newGrades = gradingStudents(grades)
    println(newGrades.joinToString("\n"))

    // apple and orange
    val (houseX0,houseX1) = readLine()!!.split(' ').map{it.toInt()}
    val (appleTreeX,orangeTreeX) = readLine()!!.split(' ').map{it.toInt()}
    readLine()
    val appleFallDistance = readLine()!!.split(' ').map{it.toInt()}
    val orangeFallDistance = readLine()!!.split(' ').map{it.toInt()}
    val appleAndOrangeRes = appleAndOrange(houseX0,houseX1,appleTreeX,orangeTreeX,appleFallDistance,orangeFallDistance)
    println(appleAndOrangeRes.joinToString("\n"))

    // kangaroo
    val inputs = readLine()!!.split(' ').map{it.toInt()}
    val kangarooRes = kangaroo(inputs[0],inputs[1],inputs[2],inputs[3])
    println(kangarooRes)

    // betweenTwoSets
    val nm = scan.nextLine().split(" ")
    var n = nm[0].trim().toInt()
    var m = nm[1].trim().toInt()
    val a = scan.nextLine().split(" ").map{ it.trim().toLong() }.toLongArray()
    val b = scan.nextLine().split(" ").map{ it.trim().toLong() }.toLongArray()
    val betweenTwoSetsRes = betweenTwoSets(a, b)
    println(betweenTwoSetsRes)

    // breaking the records
    n = scan.nextLine().trim().toInt()
    val score = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    var result = breakingTheRecords(score)
    println(result.joinToString(" "))

    // birthday chocolate
    n = scan.nextLine().trim().toInt()
    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    val d = scan.nextInt()
    m = scan.nextInt()
    val birthdayChocolateRes = birthdayChocolate(c,m,d)
    println(birthdayChocolateRes)

    // divisible sum pairs
    n = scan.nextInt()
    val k = scan.nextInt()
    scan.nextLine()
    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    val divisibleSumPairsRes = divisibleSumPairs(ar,k)
    println(divisibleSumPairsRes)
}



fun implementation()
{
    // grading students
    val newGrades = gradingStudents(intArrayOf(73,67,38,33))
    println(newGrades.joinToString("\n"))
    // apple and orange
    val orangeRes = appleAndOrange(7,11,5,15, arrayListOf(-2,2,1), arrayListOf(5,-6))
    println(orangeRes.joinToString("\n"))
    // kangaroo
    val kangarooRes = kangaroo(0,3,4,2)
    println(kangarooRes)
    // between Two Sets
    val betweenTwoSetsRes = betweenTwoSets(longArrayOf(2,4), longArrayOf(16,32,96))
    println(betweenTwoSetsRes)
    // breaking the records
    val breakingTheRecordsRes = breakingTheRecords(intArrayOf(10,5,20,20,4,5,2,25,1))
    println(breakingTheRecordsRes.joinToString(" - "))
    // birthday chocolate
    val birthdayChocolateRes = birthdayChocolate(intArrayOf(4,1,2,3,4,4,2,2,3,4),2,4)
    println(birthdayChocolateRes)
    // divisible sum pairs
    val divisibleSumPairsRes = divisibleSumPairs(intArrayOf(1,3,2,6,1,2),3)
    println(divisibleSumPairsRes)
    // migratory birds
    val migratoryBirdsRes = migratoryBirds(arrayListOf(1,4,4,4,5,3))
    println(migratoryBirdsRes)
    // day of the programmer
    val dayOfTheProgrammerRes = dayOfTheProgrammer(1800)
    println(dayOfTheProgrammerRes)
    val bonAppetitRes = bonAppetit(4,1, intArrayOf(3,10,2,9),12)
    println(bonAppetitRes)
}


