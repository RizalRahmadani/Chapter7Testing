package com.example.chapter7testing

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestingRegister {
    private lateinit var reg : Register

    @Before
    fun setUp(){
        reg = Register
    }

    @Test
    fun valid_reg(){
        val result = reg.validateRegistrationInput("joko","joko@gmail.com","joko123","joko123")
        Assert.assertEquals(true, result)
    }

    @Test
    fun empty_username(){
        val result = reg.validateRegistrationInput(
            username = "",
            email = "joko@gmail.com",
            password = "joko123",
            confirmedPassword = "joko123")
        Assert.assertEquals(false, result)
    }

    @Test
    fun empty_email(){
        val result = reg.validateRegistrationInput(
            username = "joko",
            email = "",
            password = "joko123",
            confirmedPassword = "joko123")
        Assert.assertEquals(false, result)
    }

    @Test
    fun empty_password(){
        val result = reg.validateRegistrationInput(
            username = "joko",
            email = "joko@gmail.com",
            password = "",
            confirmedPassword = "joko123")
        Assert.assertEquals(false, result)
    }

    @Test
    fun empty_confirmedPassword(){
        val result = reg.validateRegistrationInput(
            username = "joko",
            email = "joko@gmail.com",
            password = "joko123",
            confirmedPassword = "")
        Assert.assertEquals(false, result)
    }

    @Test
    fun exisiting_username(){
        val result = reg.validateRegistrationInput(
            username = "joka",
            email = "joka@gmail.com",
            password = "joka123",
            confirmedPassword = "joka123")
        Assert.assertEquals(false, result)
    }

    @Test
    fun exisiting_email() {
        val result = reg.validateRegistrationInput(
            username = "joka",
            email = "joka@gmail.com",
            password = "joka123",
            confirmedPassword = "joka123"
        )
        Assert.assertEquals(true, result)
    }

    @Test
    fun password_less_than_6_false(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "a",
            confirmedPassword = "a")
        Assert.assertEquals(false, result)
    }

    @Test
    fun long_password(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "sdjf234up9sfkl23rks",
            confirmedPassword = "sdjf234up9sfkl23rks")
        Assert.assertEquals(false, result)
    }

    @Test
    fun no_uppercase_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "aaaaaa",
            confirmedPassword = "aaaaaa")
        Assert.assertEquals(false, result)
    }

    @Test
    fun no_lowercase_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "BBBBBBBBBB",
            confirmedPassword = "BBBBBBBBBB")
        Assert.assertFalse(result)
    }

    @Test
    fun short_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "1",
            confirmedPassword = "1")
        Assert.assertFalse(result)
    }
}