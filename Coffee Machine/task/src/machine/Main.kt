package machine

import java.util.*
import kotlin.system.exitProcess


enum class BrewType(val water: Int, val milk: Int, val coffee_beans: Int, val cost: Int) {
    Espresso(250, 0, 16, 4),
    Latte(350, 75, 20, 7),
    Cappuccino(200, 100, 12, 6);

    override fun toString() = "${ordinal + 1} - $name"
    fun brewOn(machine: CoffeeMachine) {
        machine.water -= water
        machine.milk -= milk
        machine.coffee_beans -= coffee_beans
        machine.disposable_cups--
        machine.money += cost
    }


}

class CoffeeMachine(
        var water: Int = 400,
        var milk: Int = 540,
        var coffee_beans: Int = 120,
        var disposable_cups: Int = 9,
        var money: Int = 550
) {
    enum class Action { buy, fill, take, remaining, exit }

    private val actions = Action.values().associateBy(Action::name)

    fun order() {

        while (actions != Action.exit) {
            print(
                    "Write action (" +
                            Action.values()
                                    .map(Action::name)
                                    .joinToString(", ") + "): "
            )

            this act (actions[readLine()!!] ?: return println("Invalid action"))
        }
    }

    infix fun act(action: Action) {

        when (action) {

            Action.buy -> {
                var mapOfMachine = mutableMapOf<String, Boolean>()

                print(
                        "What do you want to buy? " +
                                BrewType.values().joinToString(", ") + ", back - to main menu" + ": "
                )
                val input = readLine()

                if (input == "back") {
                    order()
                }

                if (input?.toIntOrNull() != null && input.toInt().minus(1) in 0..2) {
                    val idx = input.toIntOrNull()?.minus(1) ?: return println("Not a number")
                    val type = BrewType.values().getOrNull(idx) ?: return println("Invalid brew type")

                    val inMachine = also {
                        if (it.milk < type.milk) mapOfMachine["milk"] = false
                        if (it.water < type.water) mapOfMachine["water"] = false
                        if (it.coffee_beans < type.coffee_beans) mapOfMachine["coffee beans"] = false
                        if (it.disposable_cups == 0) mapOfMachine["disposable cups"] = false
                    }
                    if (mapOfMachine.isEmpty()) {
                        println("I have enough resources, making you a coffee!")
                        type.brewOn(this)
                    } else {
                        print("Sorry, not enough ")
                        for (key in mapOfMachine.keys) {
                            print("$key!")
                        }
                        println()
//                        println( "${mapOfMachine.forEach { print(it.key)}}!"  )
                        return
                    }


                } else {
                    return println("Invalid input")
                }
            }

            Action.fill -> {
                print("Write how many ml of water do you want to add: ")
                water += readLine()!!.toInt()
                print("Write how many ml of milk do you want to add: ")
                milk += readLine()!!.toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                coffee_beans += readLine()!!.toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                disposable_cups += readLine()!!.toInt()
            }
            Action.take -> {
                println("I gave you $$money")
                money = 0
            }
            Action.remaining -> {
                println("The coffee machine has:\n" +
                        "$water of water\n" +
                        "$milk of milk\n" +
                        "$coffee_beans of coffee beans\n" +
                        "$disposable_cups of dispostable cups\n" +
                        "$money of money")
            }
            Action.exit -> {
               // println("Appication is closed")

                exitProcess(-1)
            }
        }
    }

    override fun toString(): String {
        return "The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$coffee_beans of coffee beans\n" +
                "$disposable_cups of dispostable cups\n" +
                "$money of money"
    }
}


fun main() {
    val coffeeMachine = CoffeeMachine()
    //println(coffeeMachine)
    coffeeMachine.order()
    println(coffeeMachine)


}


