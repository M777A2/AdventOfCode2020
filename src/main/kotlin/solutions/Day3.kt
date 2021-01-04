package solutions

class Day3(input: String): Solution() {
    data class Row(val open: List<Int>, val tree:List<Int>)
    var width = 0
    val entries = input.trim().split("\n").map{
        width = it.length
        val open = mutableListOf<Int>()
        val tree = mutableListOf<Int>()
        it.forEachIndexed { index, c ->
            if (c == '.'){
                open.add(index)
            }
            else {
                tree.add(index)
            }
        }
        Row(open.toList(), tree.toList())
    }

    private fun treeCheck(right: Int, down: Int): Int {
        var treesHit = 0
        entries.forEachIndexed { index, row ->
            if (row.tree.contains((index * right) % width) and (index % down == 0)){
                treesHit++
            }
        }
        return treesHit
    }

    override fun calculateLevel1(): String {
        return treeCheck(3, 1).toString()
    }

    override fun calculateLevel2(): String {
        val rights = listOf(1,3,5,7,1)
        val downs = listOf(1,1,1,1,2)
        var product:Long = 1
        for (i in 0..4){
            product *= treeCheck(rights[i], downs[i])
        }
        return product.toString()
    }
}