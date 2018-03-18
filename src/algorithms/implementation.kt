package algorithms

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
    val res = appleAndOrange(houseX0,houseX1,appleTreeX,orangeTreeX,appleFallDistance,orangeFallDistance)
    println(res.joinToString("\n"))
}

fun implementation()
{
    // grading students
    val newGrades = gradingStudents(intArrayOf(73,67,38,33))
    println(newGrades.joinToString("\n"))
    // apple and orange
    val orangeRes = appleAndOrange(7,11,5,15, arrayListOf(-2,2,1), arrayListOf(5,-6))
    println(orangeRes.joinToString("\n"))
}