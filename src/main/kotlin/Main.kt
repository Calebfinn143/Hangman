import java.util.*

fun main() {
    // Start the Game
    var category = startGame()

    // Select a random word
    var word = randomWord(category)

    //Initialize variables
    var errors = 0
    var finalGuess = ""
    var continuePlaying = true
    var copyWord = word // Copy of word

    // Set space markers for chosen word
    for (x in word.indices) {
        finalGuess += "_"
    }

    // Loop while continuePlaying is true
    while (continuePlaying) {
        hangman(errors)
        println(finalGuess)
        println("Please guess a letter:")
        var guess: String = readLine()!!.lowercase()

        if(word.contains(guess)) {
            println("Correct!")

            // Get index of guess in word
            var index = word.indexOf(guess)

            // Replace index of finalGuess with guess
            finalGuess = finalGuess.substring(0, index) + guess + finalGuess.substring(index + 1)
            // Replace index of word with "*" to ensure it can be guessed again.
            word = word.substring(0, index) + "*" + word.substring(index + 1)

            if (copyWord == finalGuess)
            {
                println("Congrats you won!! Care to try your luck again?")
                continuePlaying = false
            }
        } else {
            println("Wrong!")
            errors += 1

            if (errors >= 6) {
                hangman(6)
                println("Sorry you have lost the game. If you're done hanging around, try again!")
                print("The correct word was: ")
                print(copyWord)
                continuePlaying = false
            }
        }
    }
}

fun startGame(): Int {
    println("Welcome to Hangman")
    println("Please select a category, 1 for animals or 2 for colors:")
    val myObj = Scanner(System.`in`)
    return myObj.nextInt()
}

fun randomWord(difficulty: Int): String {
    val wordList1 = arrayOf("dog", "duck", "rabbit", "cat", "cow", "horse", "penguin", "fish", "turtle",
        "porpoise", "narwhal")
    val wordList2 = arrayOf("red", "blue", "green", "orange", "yellow", "pink", "white", "black", "gray",
        "purple", "brown")
    return if (difficulty == 1)
        wordList1[(0..9).random()]
    else
        wordList2[(0..9).random()]
}

fun hangman(errors: Int) {
    when (errors) {
        0 -> {
            println(" +---+")
            println("     |")
            println("     |")
            println("     |")
            println("     |")
            println("     |")
            println("=========")
        }
        1 -> {
            println(" +---+")
            println(" O   |")
            println("     |")
            println("     |")
            println("     |")
            println("     |")
            println("=========")
        }
        2 -> {
            println(" +---+")
            println(" O   |")
            println(" |   |")
            println("     |")
            println("     |")
            println("     |")
            println("=========")
        }
        3 -> {
            println(" +---+")
            println(" O   |")
            println("/|   |")
            println("     |")
            println("     |")
            println("     |")
            println("=========")
        }
        4 -> {
            println(" +---+")
            println(" O   |")
            println("/|\\  |")
            println("     |")
            println("     |")
            println("     |")
            println("=========")
        }
        5 -> {
            println(" +---+")
            println(" O   |")
            println("/|\\  |")
            println("/    |")
            println("     |")
            println("     |")
            println("=========")
        }
        6 -> {
            println(" +---+")
            println(" O   |")
            println("/|\\  |")
            println("/ \\  |")
            println("     |")
            println("     |")
            println("=========")
        }
    }
}