package com.example.daniwebandroidpartialroomentityupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creates db and get a Dao instance
        val studentDao = Room.inMemoryDatabaseBuilder(
            applicationContext,
            MyDatabase::class.java
        ).build()
            .studentDao()

        //Insert a User on start
        lifecycleScope.launch(Dispatchers.IO) {
            val user = User(
                name = "Anna",
                age = 50
            )

            studentDao.insert(user)
        }

        val updateButton = findViewById<Button>(R.id.button_update)
        updateButton.setOnClickListener {
            //Updates the entire row where id = 1
            lifecycleScope.launch(Dispatchers.IO){
                val user = User(
                    name = "Updated Anna",
                    age = 51
                )

                studentDao.update(user)
            }
        }

        val updatePartialButton = findViewById<Button>(R.id.button_partialUpdate)
        updatePartialButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                val userName = UserName(
                    name = "New Anna"
                )

                studentDao.updateName(userName)
            }
        }
    }
}