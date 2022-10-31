package com.example.chapter7testing

object Register {
    private val existingUsers = listOf("joka", "joki", "joku")
    private val existingEmail = listOf("joka@gmail.com","joki@gmail.com","jaku@gmail.com")

    fun validateRegistrationInput(
        username : String,
        email : String,
        password : String,
        confirmedPassword : String
    ) : Boolean{
        if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()){
            return false
        }
        when{
            username in existingUsers -> return false
            email in existingEmail -> return false
            password != confirmedPassword -> return false
            password.length < 6 -> return false
            password.length > 50 -> return false
            password.filter { it.isUpperCase()}.isEmpty() -> return false
            password.filter { it.isLowerCase()}.isEmpty() -> return false
            password.count { it.isDigit() } < 2 -> return false
        }
        return true
    }
}