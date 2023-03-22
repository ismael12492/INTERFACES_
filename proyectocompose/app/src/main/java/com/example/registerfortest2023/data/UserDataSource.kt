package com.example.login.data

 object UserDataSource {
    var usersList = mutableListOf<User>()


    fun addUser(user:User): User {
        usersList.add(user)
        return user
    }

    fun initUser() {
        addUser(User(
            name = "Ana79",
            email = "Ana_Andrade@gmail.com",
            pass = "11111111"
        )
        )
      addUser(
          User(
            name = "Bertito",
            email = "Berto_Borrego@hotmail.com",
            pass = "22222222"
        ))
        addUser(User(
            name = "KR-La",
            email = "Carla_Cabrera@yahoo.com",
            pass = "33333333"
        )
        )
        addUser( User(
            name = "DomD",
            email = "Domingo_Daimiel@ieszaidinvergeles.com",
            pass = "44444444"
        )
        )
        addUser(User(
            name = "Esther_TT",
            email = "Esther_Echanove@houtlook.com",
            pass = "55555555"
        )
        )
    }

    fun existUser(userNew: User): User? {
        for (user in usersList) {
            if (user.email == userNew.email && user.pass == userNew.pass)
                return user
        }
        return null
    }
    fun extisName (newName: String): Boolean {
        for (user in usersList){
            if (user.name == newName){
                return true
            }
        }
        return false
    }
    fun extisEmail (newEmail: String): Boolean {
        for (user in usersList){
            if (user.email == newEmail){
                return true
            }
        }
        return false
    }
}