package com.example.chapter7testing

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestingLogin {
    private lateinit var login : Login

    @Before
    fun setUp(){
        login = Login
    }

    @Test
    fun emptyUsername() {
        val username = ""
        val result = login.validateLogin(username)
        Assert.assertEquals("Please enter username", result)
    }

    @Test
    fun shortUsername() {
        val username = "A"
        val result = login.validateLogin(username)
        Assert.assertEquals("Username is too short", result)
    }

    @Test
    fun longUsername() {
        val username = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        val result = login.validateLogin(username)
        Assert.assertEquals("Username is too long", result)
    }

    @Test
    fun ValidUsername() {
        val username = "admin"
        val result = login.validateLogin(username = username)
        Assert.assertEquals("Login Success", result)
    }

    @Test
    fun emptyEmail() {
        val email = ""
        val result = login.validateLogin(email = email)
        Assert.assertEquals("Email cant be empty !", result)
    }
}