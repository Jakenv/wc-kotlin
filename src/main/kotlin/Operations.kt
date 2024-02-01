package org.example
import java.io.File

interface IOperations {
    fun countLines(file: File): Int
    fun countWords(file: File): Int
    fun countChars(file: File): Int
}

class Operations : IOperations {
    override fun countLines(file: File): Int {
        return file.readLines().size
    }
    override fun countWords(file: File): Int {
        return file.readText().split("\\s+".toRegex()).size
    }
    override fun countChars(file: File): Int {
        return file.readText().length
    }
}
