import kotlinx.coroutines.*

class MyClass {
    suspend fun getDataOne(n: Int): Int {
        delay(1000L)
        return n * n
    }
    suspend fun getDataTwo(i: Int): Int {
        delay(2000L)
        println("Вызвана 2 функция (${i + 1} раз)")
        print("Введите А:")
        val a = readLine()?.toInt() ?: 0
        print("Введите B:")
        val b = readLine()?.toInt() ?: 0
        return a * b
    }
}
