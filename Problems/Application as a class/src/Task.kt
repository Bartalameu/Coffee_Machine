import java.util.*

class Application(val name: String) {

    fun run ( a:String,  b:String, c:String) {

    val field = arrayListOf<String>()
        field.add(name)
        field.add(a)
        field.add(b)
        field.add(c)

        for (element in field) {
           println(element)
        }


    }
}

