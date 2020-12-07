import utils.AdventClient

suspend fun main(args: Array<String>) {
    val session = "53616c7465645f5f9fa6006e49d651cc82b483274477a08492aaba8c92ced0660662db274eb80192cd53499f8afad4f5"
    val inputs = AdventClient(session)
    println(solutions.Day1(inputs.getInputForDay(args[0])).calculate())
}