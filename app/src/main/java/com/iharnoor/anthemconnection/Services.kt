package com.iharnoor.anthemconnection

import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


val questionsList = listOf<String>("I feel like a valuable team member at Anthem:",
        "My work environment allows me to make progress at my job:",
        "I am comfortable asking coworkers and supervisors for help:",
        "If I get upset at work, I know who to talk to:",
        "I feel safe around my coworkers:",
        "When my coworkers are unhappy, I know how to help them:",
        "I rarely have issues working with groups:",
        "I feel like work is distributed evenly and fairly in my group projects:",
        "Goals are made faster when working in a group:",
        "I tend to be the leader of my group projects:")

var count = 1
var streaks = 0

//val answerlist= arrayListOf<>()
val jsonArray = JSONArray()
var selectedEmoji = "happy"
//var btnName ="/"
val hashmap = HashMap<String, String>()

fun pushFirebase(question: String, username: String, answer: String, uniqueKey: String) {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference()

    hashmap.put("${uniqueKey}username", username)
    hashmap.put("${uniqueKey}answer", answer)

    myRef.child("${question}").child("username").setValue("$username")
    myRef.child("${question}").child("answer").setValue("$answer")

}
