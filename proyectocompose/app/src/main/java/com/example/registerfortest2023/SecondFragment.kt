package com.example.registerfortest2023
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import com.example.registerfortest2023.model.Person
import com.example.registerfortest2023.model.PersonListItem
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.compose.rememberNavController
import com.example.registerfortest2023.model.people


class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            MaterialTheme {
                PeopleList(people = people)
            }
        }
    }
    @Composable
    fun PeopleList(people: List<Person>) {
        val selectedPerson = remember { mutableStateOf<Person?>(null) }
        LazyColumn {
            items(people) { person ->
                PersonListItem(person = person, onClick = { selectedPerson.value = it })
                Divider(modifier = Modifier.padding(horizontal = 700.dp))
            }
        }
        selectedPerson.value?.let { person ->
            PersonDetailsScreen(
                person = person,
                onClose = { selectedPerson.value = null }
            )
        }
    }

    @Composable
    fun PersonDetailsScreen(person: Person, onClose: () -> Unit) {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = person.name) },
                    navigationIcon = {
                        IconButton(onClick = { onClose() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = person.photo),
                    contentDescription = person.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(text = "Name: ${person.name}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Age: ${person.age}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Description: ${person.description}", fontSize = 16.sp)
                }
            }
        }
        // Navegación hacia atrás al hacer clic en el botón "Cerrar"
        DisposableEffect(Unit) {
            onDispose {
                navController.popBackStack()
            }
        }
    }






    override fun onDestroyView() {
        super.onDestroyView()

    }
}

