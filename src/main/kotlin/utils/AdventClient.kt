package utils

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import java.lang.Exception

class AdventClient(private val session: String) {
    private val client = HttpClient() {
        install(HttpRedirect) {
            checkHttpMethod = false
        }
    }

    suspend fun getInputForDay(day: Int): String {
        println("getting input for day $day")
        if (day < 1 || day > 25){
            throw Error("Day out of Range")
        }
        return try {
            client.get("https://adventofcode.com/2020/day/$day/input") {
                header("cookie", "session=$session")
            }
        }
        catch (e: Exception) {
            println(e.message)
            ""
        }
    }

    suspend fun postAnswerForDay(day: Int, level: Int, answer: String): String {
        println("day $day, level $level answer is: $answer")
        return ""
//        return client.post("https://adventofcode.com/2020/day/$day/answer") {
//            header("cookie", "session=$session")
//            formData {
//                append("answer", answer)
//                append("level", level)
//            }
//        }
    }

}