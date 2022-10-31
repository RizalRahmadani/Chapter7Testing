package com.example.chapter7testing

object Login {
    fun validateLogin(username: String = "", email: String = "", password: String = "", age: Int = 0): String? {
        if (username.isEmpty()) return "Please enter username"
        if (username.length < 6) return "Very short username"
        if (username.length > 20) return "Very long username"

        if (email.isEmpty()) return "Please enter email"
        if(!email.contains("@")) return "Invalid email"

        if (password.isEmpty()) return "Please enter password"
        if (password.length < 6) return "Very short password"
        if (password.length > 20) return "Very long password"

        if (age <= 0) return "Invalid age"
        if (age < 18) return "You are too young"

        return "Success"
    }
}