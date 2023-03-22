package com.example.registerfortest2023.model


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registerfortest2023.R

data class Person(
    val name: String,
    val age: Int,
    val photo: Int,
    val description: String
)

val people = listOf(
    Person("Juan",20, (R.drawable.descarga), "Información sobre Juan"),
    Person("María",22, (R.drawable.descarga1), "Información sobre María"),
    Person("Pedro",22,(R.drawable.images), "Información sobre Pedro"),
    Person("Pepe",20, (R.drawable.descarga), "Información sobre Juan"),
    Person("Raquel",22, (R.drawable.muchacha), "Información sobre María"),
    Person("Jose",22,(R.drawable.muchacho), "Información sobre Pedro"),
    Person("Manolo",20, (R.drawable.descarga), "Información sobre Juan"),
    Person("Lucia",22, (R.drawable.descarga1), "Información sobre María"),
    Person("Moises",22,(R.drawable.muchacho), "Información sobre Pedro"),
)
@Composable
fun PersonListItem(person: Person, onClick: (Person) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onClick(person) })) {
        Image(
            bitmap = ImageBitmap.imageResource(person.photo),
            contentDescription = person.name,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(40.dp))
        Text(text = person.name, fontSize = 40.sp)
    }
}
