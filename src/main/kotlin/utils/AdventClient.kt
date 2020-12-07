package utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*

class AdventClient(private val session: String) {
    private val client = HttpClient(CIO)

    suspend fun getInputForDay(day: String): String {
        println("getting input for day $day")
        val iday = day.toInt()
        if (iday < 1 || iday > 25){
            throw Error("Day out of Range")
        }
        return client.get("https://adventofcode.com/2020/day/$day/input") {
            header("cookie", "session=$session")
        }
    }
    
    suspend fun postAnswerForDay(day: String, answer: Any) {
        // TODO: 12/7/20 not impemented yet 
    }

}