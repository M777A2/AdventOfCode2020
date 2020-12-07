package solutions

abstract class Solution {
    abstract fun calculateLevel1(): String
    abstract fun calculateLevel2(): String
    fun calculate(level: Int): String {
        val answer = when (level) {
            1 -> this.calculateLevel1()
            2 -> this.calculateLevel2()
            else -> {
                throw Error("Invalid Level, must be 1 or 2.")
            }
        }
        println(answer)
        return answer
    }
}