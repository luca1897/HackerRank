package algorithms

import java.util.*

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


fun implementationStdin()
{

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

    //kangaroo
    val inputs = readLine()!!.split(' ').map{it.toInt()}
    val kangarooRes = kangaroo(inputs[0],inputs[1],inputs[2],inputs[3])
    println(kangarooRes)

    //betweenTwoSets
    val scan = Scanner(System.`in`)
    val nm = scan.nextLine().split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()
    val a = scan.nextLine().split(" ").map{ it.trim().toLong() }.toLongArray()
    val b = scan.nextLine().split(" ").map{ it.trim().toLong() }.toLongArray()
    val betweenTwoSetsRes = betweenTwoSets(a, b)
    println(betweenTwoSetsRes)

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
}