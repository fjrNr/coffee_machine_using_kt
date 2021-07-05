package machine

var water = 400
var milk = 540
var coffeeBean = 120
var cup = 9
var money = 550

data class Coffee(
    val water: Int,
    val milk: Int,
    var coffeeBean: Int,
    val money: Int
    )

val coffeList = arrayOf(
    Coffee(250, 0, 16, 4),
    Coffee(350, 75, 20, 7),
    Coffee(200, 100, 12, 6)
)

fun main() {
    var action = ""

    while (action != "exit") {
        print("Write action (buy, fill, take, remaining, exit): > ")
        action = readLine()!!

        when (action) {
            "buy" -> {
                buyCoffee()
            }
            "fill" -> {
                fillIngredients()
            }
            "take" -> {
                takeMoney()
            }
            "remaining" -> {
                showIngredients()
            }
        }
    }
}

fun buyCoffee(){
    var option = ""

    while (option != "back") {
        print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")
        option = readLine()!!

        when (option) {
            "1", "2", "3" -> {
                println(makeCoffee(option.toInt()))
                break
            }
        }
    }
    println()
}

fun makeCoffee(option: Int): String{
    return when {
        water < coffeList[option - 1].water -> "Sorry, not enough water!"
        milk < coffeList[option - 1].milk -> "Sorry, not enough milk!"
        coffeeBean < coffeList[option - 1].coffeeBean -> "Sorry, not enough coffee beans!"
        else -> {
            water-=coffeList[option - 1].water
            milk-=coffeList[option - 1].milk
            coffeeBean-=coffeList[option - 1].coffeeBean
            cup-=1
            money+=coffeList[option - 1].money
            "I have enough resources, making you a coffee!"
        }
    }
}

fun fillIngredients(){
    print("\nWrite how many ml of water do you want to add: > ")
    val addedWater = readLine()!!.toInt()
    print("Write how many ml of milk do you want to add: > ")
    val addedMilk = readLine()!!.toInt()
    print("Write how many grams of coffee beans do you want to add: > ")
    val addedCoffeeBean = readLine()!!.toInt()
    print("Write how many disposable cups of coffee do you want to add: > ")
    val addedCup = readLine()!!.toInt()

    water+=addedWater
    milk+=addedMilk
    coffeeBean+=addedCoffeeBean
    cup+=addedCup

    println()
}

fun takeMoney(){
    println("\nI gave you  $$money\n")
    money = 0
}

fun showIngredients(){
    println("\nThe coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$coffeeBean of coffee beans")
    println("$cup of disposable cups")
    println("$$money of money\n")
}