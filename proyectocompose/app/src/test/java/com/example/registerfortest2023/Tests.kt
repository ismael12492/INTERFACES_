package com.example.registerfortest2023

import com.example.login.data.User
import com.example.login.data.UserDataSource
import com.example.registerfortest2023.register.RegisterViewModel
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class Tests {

    var o=RegisterViewModel();


    @Test
    fun camposVaciosTest() {
        assertTrue(o.camposVacios(""))
        assertFalse(o.camposVacios("Texto"))
    }

    @Test
    fun nombreRepetidoTest() {
        val user1 = User("User1", "email1@email.com", "password")
        val user2 = User("User2", "email2@email.com", "password")
        UserDataSource.usersList = listOf(user1, user2) as MutableList<User>
        assertTrue(o.nombreRepetido("User1"))
        assertFalse(o.nombreRepetido("User3"))
    }

    @Test
    fun correoExistenteTest() {
        val user1 = User("User1", "email1@email.com", "password")
        val user2 = User("User2", "email2@email.com", "password")
        UserDataSource.usersList = listOf(user1, user2) as MutableList<User>
        assertTrue(o.correoExistente("email1@email.com"))
        assertFalse(o.correoExistente("email3@email.com"))
    }

    @Test
    fun correoMalformadoTest() {
        val email = "ismael@gmail.com"
        val email2="ismaelgmail.com"
        val result: Boolean = o.correoMalformado(email)
        val result2: Boolean = o.correoMalformado(email2)

        assertTrue(result)
        assertFalse(result2)
    }

    @Test
    fun passLengthTest() {
        assertTrue(o.passLength("passwor"))
        assertFalse(o.passLength("password"))
    }

    @Test
    fun passwordMatchTest() {
        assertTrue(o.passworMatch("password", "passwor"))
        assertFalse(o.passworMatch("password", "password"))
    }
}