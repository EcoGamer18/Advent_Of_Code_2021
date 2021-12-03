import java.text.CharacterIterator

fun main() {
    fun part1(input: List<String>): Int {
        val result = mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0)
        val size_bytes = input[0].length - 1
        for(element in input){
            for(i in 0..size_bytes)
                result[i] = result[i] + Character.getNumericValue(element[i])
        }
        var number_result= 0.0
        for(i in 0..size_bytes){
            if(result[i] > input.size/2) {
                result[i] = 1
                number_result += Math.pow(2.0,(size_bytes - i).toDouble())
            }
            else {
                result[i] = 0
            }
        }
        val aux = Math.pow(2.0,(size_bytes+1).toDouble()).toInt()

        return number_result.toInt() * (aux + (number_result.toInt()).inv())
    }

    fun part2(input: List<String>): Int {
        val size_bytes = input[0].length - 1

        //oxygen
        var oxygen =  input.toMutableList()
        for(i in 0..size_bytes)
        {
            if(oxygen.size == 1){
                break
            }

            var result_bit = 0
            for(element in oxygen){
                result_bit += Character.getNumericValue(element[i])
            }

            if(result_bit >= oxygen.size/2 + oxygen.size % 2) {
                result_bit = 1
            }
            else {
                result_bit = 0
            }


            oxygen = oxygen.filter{ it : String ->
                if(result_bit != Character.getNumericValue(it[i]))
                    return@filter false
                return@filter true
            }.toMutableList()
        }

        var oxygen_number = 0.0
        for(i in 0..size_bytes){
            if(Character.getNumericValue(oxygen[0][i]) == 1) {
                oxygen_number += Math.pow(2.0,(size_bytes - i).toDouble())
            }
        }

        //CO2
        var CO2 = input.toMutableList()
        for(i in 0..size_bytes)
        {
            if(CO2.size == 1){
                break
            }

            var result_bit = 0
            for(element in CO2){
                result_bit += Character.getNumericValue(element[i])
            }

            if(result_bit >= CO2.size/2 + CO2.size%2) {
                result_bit = 1
            }
            else {
                result_bit = 0
            }


            CO2 = CO2.filter{ it : String ->
                if(result_bit == Character.getNumericValue(it[i]))
                    return@filter false
                return@filter true
            }.toMutableList()
        }

        var CO2_number = 0.0
        for(i in 0..size_bytes) {
            if (Character.getNumericValue(CO2[0][i]) == 1) {
                CO2_number += Math.pow(2.0, (size_bytes - i).toDouble())
            }
        }

        return (oxygen_number * CO2_number).toInt()
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}