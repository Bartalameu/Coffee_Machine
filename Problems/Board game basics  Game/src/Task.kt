object PlayingField {

    object Size {
        var width = 0
        var height = 0
        fun changeSize(_width: Int, _height: Int) {

            height = if (_height < 0) 0 else _height
            width = if (_width < 0) 0 else _width

        }

    }
}

//fun main() {
//    var field = PlayingField.Size
//
//    field.changeSize(19,1)
//    println("${field.height} ${field.width}")
//
//}