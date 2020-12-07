package solutions

class Day1(input: String): Solution() {
    private val entries = input.trim().split("\n").map { it.toInt() }

    override fun calculateLevel1(): String {
        println("calculating level 1")
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
                return (sorted[0] * sorted[index]).toString()
            }
        }
        throw Error("No Match Found!")
    }

    override fun calculateLevel2(): String {
        println("calculating level 2")
        //sort entries
        val sorted = entries.sorted().toMutableList()
        //binary search for 2020 match
        while (sorted.isNotEmpty()){
            //grab first value
            val first = sorted.removeFirst()
            //create new list from remaining
            val nested = sorted.toMutableList()
            //find two two numbers that fit the remainder with bsearch
            val target = 2020-first
            while (nested.isNotEmpty()){
                val index = nested.binarySearch { it + nested.first() - target }
                if (index < 0) {
                    //remove entry if no match found
                    nested.removeFirst()
                    //since it will be at least as large as this, no reason to keep checking
                    if (nested.first()*2 > target){
                        break
                    }
                }
                else {
                    //multiply
                    return (first * nested[0] * nested[index]).toString()
                }
            }
        }
        throw Error("No Match Found!")
    }
}