package solutions

class Day1(input: String): solution {
    private val entries = input.trim().split("\n").map { it.toInt() }

    override fun calculate(): Any {
        println("calculating")
        //sort entries
        val sorted = entries.sorted().toMutableList()
        //binary search for 2020 match
        while (sorted.isNotEmpty()){
            val index = sorted.binarySearch { it + sorted.first() - 2020 }
            if (index < 0) {
                //remove entry if no match found
                sorted.removeFirst()
            }
            else{
                //multiply
                return sorted[0] * sorted[index]
            }
        }
        throw Error("No Match Found!")
    }
}