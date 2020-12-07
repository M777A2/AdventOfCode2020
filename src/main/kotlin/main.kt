import solutions.*
import utils.AdventClient

suspend fun main(args: Array<String>) {
    val day: Int = args[0].toInt()
    val level: Int = args[1].toInt()
    val session: String = args[2]

    val adventClient = AdventClient(session)
    // TODO: 12/7/20 Figure out how to dynamically assign the solver's class (switch statement? Reflection?)
    val solver = Day1(adventClient.getInputForDay(day))

    val result = adventClient.postAnswerForDay(day, level, solver.calculate(level))
    println(result)
}