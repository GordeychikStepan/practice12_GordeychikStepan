import kotlinx.coroutines.*
import kotlin.system.exitProcess

fun main() = runBlocking {

    val repositories = mutableListOf<Repository>()
    while (true){
        try{
            println("\nЗагрузка нового участника.")
            print("Логин (exit для вызода): ")
            val login = readLine().toString()
            if(login == "exit") break

            print("Пароль: ")
            val pass = readLine().toString()

            print("Количество репозиториев: ")
            val numOfRepos = readLine()?.toInt()

            print("Репозитории открыты? (1 - да, 2 - нет): ")
            val open = readLine()?.toInt()
            if (open != 1 && open != 2) throw Exception()
            val isOpen: Boolean = open == 1

            repositories.add(Repository(login, pass, numOfRepos, isOpen))
        }
        catch (e: Exception){
            println("Ошибка ввода")
            exitProcess(0)
        }
    }

    val sortedRep = repositories.first().sortRepositories(repositories)

    sortedRep.forEach {
        println(it.getInfo())
    }
}
