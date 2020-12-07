import solutions.*
import utils.AdventClient

suspend fun main(args: Array<String>) {
    val day: Int = args[0].toInt()
    val level: Int = args[1].toInt()
    val session: String = System.getenv("session")

    val adventClient = AdventClient(session)
    // TODO: 12/7/20 Figure out how to dynamically assign the solver's class (switch statement? Reflection?)
    val input = adventClient.getInputForDay(day)
    val solver = when (day) {
        1 -> Day1(input)
        2 -> Day2(input)
        else -> {
            throw NotImplementedError()
        }
    }

    val result = adventClient.postAnswerForDay(day, level, solver.calculate(level))
    println(result)
}