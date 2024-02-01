package org.example
import java.io.File
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required

class WcCli : CliktCommand(), IOperations {
    override fun countLines(file: File): Int {
        return Operations().countLines(file)
    }
    override fun countWords(file: File): Int {
        return Operations().countWords(file)
    }
    override fun countChars(file: File): Int {
        return Operations().countChars(file)
    }
    private val file: String by option("-f", "--file", help = "File to count").required()
    private val lines: Boolean by option("-l", "--lines", help = "Count lines").flag()
    private val words: Boolean by option("-w", "--words", help = "Count words").flag()
    private val chars: Boolean by option("-c", "--chars", help = "Count chars").flag()
    override fun run() {
        when {
            lines -> println("Lines: ${countLines(File(file))}")
            words -> println("Words: ${countWords(File(file))}")
            chars -> println("Chars: ${countChars(File(file))}")
            else -> all()
        }
    }
    private fun all() {
        println("Lines: ${countLines(File(file))}")
        println("Words: ${countWords(File(file))}")
        println("Chars: ${countChars(File(file))}")
    }
}
