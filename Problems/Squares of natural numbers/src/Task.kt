import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
val input =scanner.nextInt()

//    var x=0
//    do {
//        for ( item in 0..input) {
//
//               x =item*item
//            println(x)
//}
//    } while (x==input)



for ( item in 1 .. input) {
    if (item*item<=input) {
        var x = item * item
        println(x)
    }
    else {
        return
    }
}

}
