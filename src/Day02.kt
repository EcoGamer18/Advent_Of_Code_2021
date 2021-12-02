fun main() {
    fun part1(input: List<String>): Int {
        var horizontal_position = 0
        var depth_position = 0
        input.forEach { it ->
            val it_split = it.split(' ')
            var number : Int  = it_split[1].toInt()
            when (it_split[0]) {
                "forward" -> horizontal_position += number
                "up" -> depth_position -= number
                "down" -> depth_position += number
            }
        }
        return horizontal_position * depth_position
    }

    fun part2(input: List<String>): Int {
        var horizontal_position : Int = 0
        var depth_position : Int = 0
        var aim : Int = 0
        input.forEach { it ->
            val it_split = it.split(' ')
            val number : Int  = it_split[1].toInt()
            when (it_split[0]) {
                "forward" -> {
                    horizontal_position += number
                    depth_position += number*aim
                }
                "up" -> {
                    //depth_position -= number
                    aim -= number
                }
                "down" -> {
                    //depth_position += number
                    aim += number
                }
            }
        }
        return horizontal_position * depth_position
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}