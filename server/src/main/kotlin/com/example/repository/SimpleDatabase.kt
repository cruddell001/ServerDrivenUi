package com.example.repository

import java.io.File

object SimpleDatabase {


    fun saveDb(table: String, data: String) {
        val file = File("that_$table.db")
        file.writeText(data)
    }

    fun getDb(table: String): String? {
        val file = File("that_$table.db")
        return if (!file.exists()) null
        else file.readText()
    }
}
