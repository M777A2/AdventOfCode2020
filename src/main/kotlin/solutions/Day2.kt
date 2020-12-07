package solutions

class Day2(input: String): Solution() {
    private val entries = input.trim().split("\n").map {
        val foo = it.split(" ")
        return@map Triple(
            foo[0].split('-').map{ s -> s.toInt()},
            foo[1][0],
            foo[2].trim()
        )
    }

    override fun calculateLevel1(): String {
        var count = 0
        for (entry in entries) {
            val occurrences = entry.third.count { it == entry.second}
            if (occurrences >= entry.first[0] && occurrences <= entry.first[1]){
                count++
            }
        }
        return count.toString()
    }

    override fun calculateLevel2(): String {
        var count = 0
        for (entry in entries) {
            val n1 = entry.first[0] - 1
            val n2 = entry.first[1] - 1
            if ((entry.third[n1] == entry.second) xor (entry.third[n2] == entry.second)){
                count++
            }
        }
        return count.toString()
    }

}