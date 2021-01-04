import solutions.*
import utils.AdventClient

suspend fun main(args: Array<String>) {
    val day: Int = args[0].toInt()
    val level: Int = args.getOrElse(1) { "0" }.toInt()
    val session: String = System.getenv("session")

    val adventClient = AdventClient(session)
    // TODO: 12/7/20 Figure out how to dynamically assign the solver's class (switch statement? Reflection?)
    val input = adventClient.getInputForDay(day)
    val solver = when (day) {
        1 -> Day1(input)
        2 -> Day2(input)
        3 -> Day3(input)
        else -> {
            throw NotImplementedError()
        }
    }

    if (level == 0){
        val result = adventClient.postAnswerForDay(day, 1, solver.calculate(1))
        println(result)
        val result2 = adventClient.postAnswerForDay(day, 2, solver.calculate(2))
        println(result2)
    }
    else {
        val result = adventClient.postAnswerForDay(day, level, solver.calculate(level))
        println(result)
    }
}