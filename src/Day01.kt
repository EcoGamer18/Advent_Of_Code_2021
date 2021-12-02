fun main() {
    fun part1(input: List<String>): Int {
        var number = 0
        var last = input[0]
        for(element in input){
            if(element.toInt() > last.toInt())
                number++
            last = element
        }
        return number
    }

    fun part2(input: List<String>): Int {
        var number = 0
        val result = input.map(String::toInt)
        var sum_last = result .component1() + result .component2() + result .component3()
        for(i in 1..(result .size - 3)){
            var sum_current = result [i] + result [i+1] + result [i+2]
            if(sum_current > sum_last)
                number++
            sum_last = sum_current
        }
        return number
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
