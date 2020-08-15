class City(val name: String) {
    var population: Int = 0
        set(value) {

        field=if (value>50_000_000) 50_000_000 else if (value<0) 0 else value
    }
}

//fun main() {
//    val city= City ("Praha")
//    city.population =60000000
//
//    println(city.population)
//}