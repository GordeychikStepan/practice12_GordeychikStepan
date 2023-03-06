import kotlinx.coroutines.delay

class Repository(val login: String, val pass: String, var numOfRepos: Int?, val isOpen: Boolean) {

    suspend fun sortRepositories(repositories: List<Repository>): List<Repository> {
        delay(2000L)
        return repositories.filter { it.isOpen }.sortedWith(compareBy { it.numOfRepos } )
    }
    suspend fun getInfo(): String {
        delay(1000L)
        return "Логин: $login, Пароль: $pass, Количество репозиториев: $numOfRepos"
    }
}
