package com.iharnoor.anthemconnection

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        beginBtn.setOnClickListener {
            count = 0
            val intent = Intent(this, Survey::class.java)

            startActivity(intent)
        }


//
//        val answer = JSONObject()
//        answer.put("username", "Mr. Singh")
//        answer.put("answer", "Strongly Agree. Great answer")
//        val jsonObj = JSONObject()
//        jsonObj.put(questionsList[0], answer)
//
        // Write a message to the databaseStrongly Agree. Great answer
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message")
//
//        val hash = HashMap<String, String>()
////        val question = HashMap<String, String>()
//        hash.put("question", questionsList[0])
//        hash.put("username", "Mr. Singh")
//        hash.put("answer", "Strongly Agree. Great answer")
//
//        myRef.setValue(hash)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    //    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.achievements -> {
                val intent = Intent(this, Achievements::class.java)
                startActivity(intent)
            }
            R.id.leaderboard -> {
                val intent = Intent(this, LeaderBoard::class.java)
                startActivity(intent)
            }
            R.id.options -> {
                val intent = Intent(this, Options::class.java)
                startActivity(intent)
            }
            R.id.feedback -> {
                val intent = Intent(this, Feedback::class.java)
                startActivity(intent)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
