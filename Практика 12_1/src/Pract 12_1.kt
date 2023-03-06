import kotlinx.coroutines.*
import kotlin.system.exitProcess

fun main() = runBlocking {
    val n: Int
    try {
        print("Введите количество функций: ")
        n = readLine()?.toInt() ?: 0
        if (n < 1) throw Exception()
    } catch (e: Exception) {
        println("Ошибка ввода")
        exitProcess(0)
    }

    val results1 = mutableListOf<Int>()
    val results2 = mutableListOf<Int>()

    val myClass = MyClass()

    val jobs = mutableListOf<Job>()
    for (i in 0 until n) {
        jobs.add(launch {
            results1.add(myClass.getDataOne(i))
        })

        jobs.add(launch {
            results2.add(myClass.getDataTwo(i))
        })
    }
    jobs.joinAll()
    Info(results1, results2)
}

fun Info(results1: MutableList<Int>, results2: MutableList<Int>) {
    println("\nРезультаты 1 функции: $results1")
    println("Результаты 2 функции: $results2")
}
// класс