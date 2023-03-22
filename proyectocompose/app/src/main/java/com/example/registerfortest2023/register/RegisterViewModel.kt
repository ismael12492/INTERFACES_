package com.example.registerfortest2023.register

import androidx.lifecycle.ViewModel
import com.example.login.data.User
import com.example.login.data.UserDataSource
import java.util.regex.Matcher
import java.util.regex.Pattern


class RegisterViewModel: ViewModel() {
    // campos vacíos
    // Nombre no esté repetido * "That name is in use"
    // correo existe *"That email is in use"
    // correo malformado *"malformed mail"
    // contraseña menor de 8 caracteres * contador de caracteres
    // o "password minimum eight characters"
    // contraseñas distintas "Passwords do not match"



    fun camposVacios(texto: String?):Boolean{
        var resul=false;
        if(texto=="" || texto==null){
            resul=true;
        }
        return resul;
    }
    fun nombreRepetido(texto:String):Boolean{
        var resul=false;
        for(user in UserDataSource.usersList){
            if(texto==user.name){
                resul=true;
            }
        }
        return resul;
    }
    fun correoExistente(texto: String):Boolean{
        var resul=false;
        for(user in UserDataSource.usersList){
            resul=UserDataSource.extisEmail(texto);
            }

        return resul;
        }
    fun correoMalformado(email: String?): Boolean {
        if (email == null) {
            return false
        }
        val regex =
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
        val pattern: Pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun passLength(texto: String):Boolean{
        var resul=false;
        if(texto.length<8){
            resul=true;
        }
        return resul;
    }
    fun passworMatch(texto: String,texto2: String):Boolean{
        var resul=false;
        if(texto!=texto2){
            resul=true;
        }
        return resul;
    }
    fun addUser(user: User): User {
        UserDataSource.usersList.add(user)
        return user
    }


}