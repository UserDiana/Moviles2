package com.example.x

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MessageFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        drawerLayout = view.findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = view.findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val profileIv: ImageView = view.findViewById(R.id.baseline_profile)
        profileIv.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return view
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_two -> {
                val intentProfile = Intent(activity, ProfileFragment::class.java)
                startActivity(intentProfile)
                return true
            }
            R.id.nav_item_four -> {
                val intentSearch = Intent(activity, GrokFragment::class.java)
                startActivity(intentSearch)
                return true
            }
            else -> {
                Toast.makeText(activity, "Item desconocido seleccionado", Toast.LENGTH_SHORT).show()
                return false
            }
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
