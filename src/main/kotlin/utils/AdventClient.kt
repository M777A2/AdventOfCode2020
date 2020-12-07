package utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*

class AdventClient(private val session: String) {
    private val client = HttpClient(CIO)

    suspend fun getInputForDay(day: Int): String {
        println("getting input for day $day")
        if (day < 1 || day > 25){
            throw Error("Day out of Range")
        }
        return client.get("https://adventofcode.com/2020/day/$day/input") {
            header("cookie", "session=$session")
        }
    }

    suspend fun postAnswerForDay(day: Int, level: Int, answer: String): String {
        return client.post("https://adventofcode.com/2020/day/$day/answer") {
            header("cookie", "session=$session")
            formData {
                append("answer", answer)
                append("level", level)
            }
        }
    }

}