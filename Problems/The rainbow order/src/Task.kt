import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val color_in =input.next()

for (color in Rainbow.values()) {
    if (color_in.toUpperCase()==color.name) {
        println(color.id)
        return
    }

}

}

enum class Rainbow(val color:String, val id: Int) {
    RED ("red",1),
    ORANGE ("orange",2),
    YELLOW ("yellow",3),
    GREEN ("green",4),
    BLUE ("blue",5),
    INDIGO ("indigo",6),
    VIOLET ("violet",7)


}