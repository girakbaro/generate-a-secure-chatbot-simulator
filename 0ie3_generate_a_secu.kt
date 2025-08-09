import java.security.SecureRandom
import java.util.*

class SecureChatbotSimulator {
    private val secureRandom = SecureRandom()
    private val conversationHistory = mutableListOf<String>()

    fun simulateConversation(input: String): String {
        val response = when (input.lowercase()) {
            "hello" -> "Hello! How can I assist you today?"
            "what's your name" -> "My name is SecureBot. Nice to meet you!"
            "exit" -> "Goodbye! It was nice chatting with you."
            else -> generateRandomResponse()
        }
        conversationHistory.add("You: $input")
        conversationHistory.add("SecureBot: $response")
        return response
    }

    private fun generateRandomResponse(): String {
        val responses = listOf("I'm not sure I understand.", "That's a great question!", "I'll get back to you on that.")
        return responses[randomInt(responses.size)]
    }

    private fun randomInt(upperBound: Int): Int {
        return secureRandom.nextInt(upperBound)
    }

    fun printConversationHistory() {
        conversationHistory.forEachIndexed { index, message ->
            println("[$index] $message")
        }
    }
}

fun main() {
    val simulator = SecureChatbotSimulator()
    var input = ""
    while (input != "exit") {
        print("You: ")
        input = readLine()!!
        val response = simulator.simulateConversation(input)
        println("SecureBot: $response")
    }
    simulator.printConversationHistory()
}