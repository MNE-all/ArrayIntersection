import java.util.*

fun main(args: Array<String>) {
    println("Программа для нахождения схожих элементов в массиве (пересечение массивов)")
    val numbs1 = intValidate("Введите первый массив(набор) целых чисел через пробел: ")
    val numbs2 = intValidate("Введите второй массив(набор) целых чисел через пробел: ")

    var result: MutableList<Int> = arrayListOf()
    val intersectionDictionary = numbs1.intersect(numbs2.toSet())

    for (element in intersectionDictionary.toList()) {
        if (Collections.frequency(numbs1.toList(), element) < Collections.frequency(numbs2.toList(), element)) {
            for (i: Int in 1..Collections.frequency(numbs1.toList(), element)) result.add(element)
        }
        else {
            for (i: Int in 1..Collections.frequency(numbs2.toList(), element)) result.add(element)
        }
    }
    result.sort()
    print("Результат пересечения массивов: ")
    for (element in result) {
        print("$element ")
    }
}

fun intValidate(message: String): Array<Int> {
    print(message)
    val result: Array<Int>
    try {
        val userInput = readln().split(" ")

        result = Array(userInput.count()){i -> userInput[i].toInt()}
    }
    catch (e: Exception){
        println("Ошибка ввода!")
        return intValidate(message)
    }
    return result
}