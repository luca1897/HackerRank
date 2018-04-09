package algorithms

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.sqrt
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close





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

fun sockMerchant(socks: IntArray): Int {
    var pairs = 0
    val mutable: MutableMap<Int, MutableList<Int>> = socks.groupByTo(mutableMapOf()) { it }
    for (m in mutable.keys)
    {
        if(mutable[m]!!.size >= 2)
            pairs += mutable[m]!!.size / 2
    }
    return pairs
}

fun drawingBook(n: Int, p: Int): Int {
    val fromS = p/2
    val fromE = (n/2) - (p/2)
    return Math.min(fromS,fromE)
}

fun countingValleys(steps : String) : Int
{
    var v = 0
    var l = 0
    for (step in steps)
    {
        l += if(step == 'U') +1 else -1
        if(l==0 && step == 'U')
            v++
    }
    return v
}

fun electronicShop(s: Int, kb: IntArray, db: IntArray): Int {
    var res = -1
    for (k in kb)
    {
        for(d in db)
        {
            if(k+d in (res + 1)..s)
                res = k+d
        }
    }
    return res
}

fun catAndMouse(x: Int, y: Int, z: Int): String {
    return if (Math.abs(z - x) < Math.abs(z - y))
        "Cat A"
    else if (Math.abs(z - x) > Math.abs(z - y))
        "Cat B"
    else
        "Mouse C"
}

fun magicSquareForming(magicSquareToSolve: Array<IntArray>): Int {
    var mindiff = Integer.MAX_VALUE

    val magicSquares = arrayOf(
            arrayOf(
                    intArrayOf(8, 1, 6),
                    intArrayOf(3, 5, 7),
                    intArrayOf(4, 9, 2)
            ),
            arrayOf(
                    intArrayOf(6, 1, 8),
                    intArrayOf(7, 5, 3),
                    intArrayOf(2, 9, 4)
            ),
            arrayOf(
                    intArrayOf(4, 9, 2),
                    intArrayOf(3, 5, 7),
                    intArrayOf(8, 1, 6)
            ),
            arrayOf(
                    intArrayOf(2, 9, 4),
                    intArrayOf(7, 5, 3),
                    intArrayOf(6, 1, 8)
            ),
            arrayOf(
                    intArrayOf(8, 3, 4),
                    intArrayOf(1, 5, 9),
                    intArrayOf(6, 7, 2)
            ),
            arrayOf(
                    intArrayOf(4, 3, 8),
                    intArrayOf(9, 5, 1),
                    intArrayOf(2, 7, 6)
            ),
            arrayOf(
                    intArrayOf(6, 7, 2),
                    intArrayOf(1, 5, 9),
                    intArrayOf(8, 3, 4)
            ),
            arrayOf(
                    intArrayOf(2, 7, 6),
                    intArrayOf(9, 5, 1),
                    intArrayOf(4, 3, 8)
            )
    )

    for (magicSquare in magicSquares)
    {
        var tmpdiff = 0
        for(row in 0 until magicSquare.size)
        {
            for(col in 0 until magicSquare.size)
            {
                tmpdiff += Math.abs(magicSquareToSolve[row][col] - magicSquare[row][col])
            }
        }
        if(mindiff > tmpdiff)
            mindiff = tmpdiff
    }

    return mindiff
}

fun pickingNumbers(ar: IntArray): Int {
    var hmap = HashMap<Int,Int>()
    for(i in 0 until ar.size)
    {
        if(hmap.containsKey(ar[i]))
            continue
        var cnt = 0
        for(j in 0 until ar.size)
        {
            if(ar[i] == ar[j]) {
                cnt = Math.max(cnt, ar.filter { it == ar[i] }.size)
            }
            else if(Math.abs(ar[i] - ar[j]) <= 1)
            {
                cnt = Math.max(cnt,ar.filter { it == ar[i] }.size + ar.filter { it == ar[j] }.size)
            }
        }
        hmap.put(ar[i],cnt)
    }
    var max = hmap.values.max()!!
    return max
}

fun climbingTheLeaderboard(leaderboard: IntArray, levelPoints: IntArray): IntArray {
    var aliceRanking = IntArray(levelPoints.size)
    var ll = leaderboard.distinct().toIntArray()
    ll.sort()
    var lastIndex = 0
    for(lp in 0 until levelPoints.size)
    {
        var f = false
        for(i in lastIndex until ll.size)
        {
            if(ll[i] > levelPoints[lp]) {
                aliceRanking[lp] = ll.size - i + 1
                f = true
                lastIndex = i
                break
            }

        }
        if(!f)
            aliceRanking[lp] = 1
    }
    return aliceRanking
}

fun hurdleRace(h : IntArray, k : Int) : Int
{
    var hf = h.max()!! - k
    return Math.max(0,hf)
}

fun designerPdfViewer(h : IntArray, words : String) : Int
{
    return words.map { h[it.toInt() - 97]}.max()!! * words.count()
}

fun utopianTree(cycles : IntArray) : IntArray
{
    val h = IntArray(cycles.size)
    for(i in 0 until cycles.size)
    {
        val cycle = cycles[i]
        h[i] = 1
        if(cycle == 0) {
            continue
        }

        for (j in 1 .. cycle)
        {
            if(j % 2 == 0)
                h[i] += 1
            else
                h[i] *= 2
        }
    }
    return h
}

fun angryProfessor(arrivalTimes: IntArray, threshold : Int) : String {
    return if (arrivalTimes.filter { it <= 0 }.count() > threshold)
        "NO"
    else
        "YES"
}

fun beautifulDays(i : Int,j : Int, k : Int) : Int
{
    var res = 0

    for(d in i .. j)
    {
        val reversed = d.toString().reversed().toInt()
        if(Math.abs(d-reversed)%k == 0)
            res++
    }

    return res
}

fun viralAdvertising(n : Int) : Int
{
    var c = 2
    var r = 6
    for(i in 1 until n)
    {
        c += Math.floor(r / 2.0).toInt()
        r = Math.floor(r / 2.0).toInt() * 3
    }
    return c
}

fun saveThePrisoner(numPrisoners : Int, numSweets : Int, startChair : Int) : Int {
    return ((startChair + numSweets - 2) % numPrisoners) + 1
}

fun circularArrayRotation(k: Int, q: IntArray, ar: IntArray): IntArray {
    val res = IntArray(q.size)
    for(i in 0 until q.size)
    {
        res[i] = ar[Math.floorMod((q[i]-k),ar.size)]
    }
    return res
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
    // bon appetit
    val bonAppetitRes = bonAppetit(4,1, intArrayOf(3,10,2,9),12)
    println(bonAppetitRes)
    // sock merchant
    val sockMerchantRes = sockMerchant(intArrayOf(10,20,20,10,10,30,50,10,20))
    println(sockMerchantRes)
    // drawing book
    val drawingBookRes = drawingBook(12, 5)
    println(drawingBookRes)
    // counting valleys
    val countingValleysRes = countingValleys("UDDDUDUU")
    println(countingValleysRes)
    // electronic shop
    val electronicShopRes = electronicShop(10, intArrayOf(3,1), intArrayOf(5,2,8))
    println(electronicShopRes)
    // cat and mouse
    val catAndMouseRes = catAndMouse(0,1,2)
    println(catAndMouseRes)
    // magic square
    val magicSquareToSolve = arrayOf(intArrayOf(4,8,2), intArrayOf(4,5,7), intArrayOf(6,1,6))
    val magicSquareRes = magicSquareForming(magicSquareToSolve)
    println(magicSquareRes)
    // picking Numbers
    val pickingNumbersRes = pickingNumbers(intArrayOf(4,97,5,97,97,4,97,4,97,97,97,97,4,4,5,5,97,5,97,99,4,97,5,97,97,97,5,5,97,4,5,97,97,5,97,4,97,5,4,4,97,5,5,5,4,97,97,4,97,5,4,4,97,97,97,5,5,97,4,97,97,5,4,97,97,4,97,97,97,5,4,4,97,4,4,97,5,97,97,97,97,4,97,5,97,5,4,97,4,5,97,97,5,97,5,97,5,97,97,97))
    println(pickingNumbersRes)
    // climbing the leaderboard
    val climbingTheLeaderboard = climbingTheLeaderboard(stringToIntArray("100 100 50 40 40 20 10"), stringToIntArray("5 25 50 120"))
    println(climbingTheLeaderboard.joinToString("\n"))
    // Hurdle Race
    val hurdleRaceRes = hurdleRace(stringToIntArray("1 6 3 5 2"),4)
    println(hurdleRaceRes)
    // Designer Pdf Viewer
    val pdfViewerRes = designerPdfViewer(stringToIntArray("1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5"),"abc")
    println(pdfViewerRes)
    // Utopian Tree
    val utopianTreeRes = utopianTree(intArrayOf(0,1,4))
    println(utopianTreeRes.joinToString("\n"))
    // angry professor
    val angryProfessorRes = angryProfessor(stringToIntArray("-1 -3 4 2"),3)
    println(angryProfessorRes)
    // beautiful days
    val beautifuldaysRes = beautifulDays(20,23,6)
    println(beautifuldaysRes)
    // viral advertising
    val viralAdvertisingRes = viralAdvertising(5)
    println(viralAdvertisingRes)
    // save the prisoners
    val saveThePrisonersRes = saveThePrisoner(4,6,2)
    println(saveThePrisonersRes)
    // Circular Array Rotation
    val circularArrayRotationRes = circularArrayRotation(2, intArrayOf(0,1,2), intArrayOf(1,2,3))
    println(circularArrayRotationRes.joinToString("\n"))
}



fun stringToIntArray(s : String) : IntArray
{
    return s.split(" ").map{ it.trim().toInt() }.toIntArray()
}

fun stringToLongArray(s : String) : LongArray
{
    return s.split(" ").map{ it.trim().toLong() }.toLongArray()
}



