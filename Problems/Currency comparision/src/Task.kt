import java.io.IOException
import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    try{
        println(Country.valueOf(input.next()).courancy == Country.valueOf(input.next()).courancy)
    }catch (ex: IllegalArgumentException){
        println(false)
    }

}


/**
Mine solution
*/
//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//
//    val (a, b) = readLine()!!.split(" ").map { it.toString() }
//
//    val enum = enumValues<Country>()
//
//    // println("$a $b")
//
//    var rightCountry = mutableListOf<Country>()
//    var name: Country
//
//    enum.forEach {
//        if (it.name == a || it.name == b) {
//
//            name = Country.valueOf(it.name)
//            rightCountry.add(name)
//        }
//    }
//    if (rightCountry.size == 2 ) {
//
//        println(rightCountry[0].courancy == rightCountry[1].courancy)
//    } else println(false)
//
//}


enum class Country(val courancy: String?) {

    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern caribbean dollar"),
    Kiribati("Australian dollar"),

}

