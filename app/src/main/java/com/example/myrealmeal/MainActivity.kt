package com.example.myrealmeal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myrealmeal.data.database.MealsDB
import com.example.myrealmeal.data.repository.Repository
import com.example.myrealmeal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val navController: NavController = navHost.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        val repository = Repository(
            database = MealsDB.getDatabase(this)
        )
    }
}