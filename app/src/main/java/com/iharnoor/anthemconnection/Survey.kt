package com.iharnoor.anthemconnection

import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_survey.*
import org.json.JSONObject

class Survey : AppCompatActivity() {
    var isGray = arrayListOf<Boolean>(false, false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        selectedFace.visibility = View.INVISIBLE
        questionText.text = questionsList[count++]

        skipOrNextBtn.setBackgroundColor(Color.GRAY)

        skipOrNextBtn.setOnClickListener {
            //            if (feedbackText.text.toString() != "") {
            if (agree.isClickable || stronglyAgree.isClickable || neutralFace.isClickable || disagree.isClickable || stronglyDisagree.isClickable) {
//                val hash = HashMap<String, String>()
//        val question = HashMap<String, String>()
//                val jsonObject = JSONObject()
//                jsonObject.put("question", questionText.text.toString())
//                jsonObject.put("username", "iharnoor")
//                jsonObject.put("answer", "$selectedEmoji. ${feedbackText.text.toString()}")
//                jsonArray.put(jsonObject)
//                pushFirebase(count.toString(),jsonObject)
//                hashmap.put()

                pushFirebase(questionText.text.toString(), "iharnoor", "$selectedEmoji. ${feedbackText.text}", count.toString())
                Toast.makeText(this, "${jsonArray.toString()} Harnoor", Toast.LENGTH_LONG).show()
//                pushFirebase(jsonObject)
//                println()
//            jsonArray.add()
            }

//            answerlist.add(feedbackText.text.toString())
            reset()
            if (count < 10)
                questionText.text = questionsList[count++]
            else {
                Toast.makeText(this, "10 Questions completed", Toast.LENGTH_LONG).show()
                streaks++
                finish()
            }
//            if (count == 9)
//                pushFirebase(jsonArray)

            selectedEmoji = ""

        }
        closeBtn.setOnClickListener {
            finish()
        }
        agree.setOnClickListener {
            selectedFace.visibility = View.VISIBLE
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            selectedFace.setImageResource(R.drawable.slightly_smiling_face_emoji)
            skipOrNextBtn.setText("NEXT")
            agree.colorFilter = turnGray()
            selectedEmoji = "Agree"

            disagree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        stronglyDisagree.setOnClickListener {
            selectedFace.visibility = View.VISIBLE
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.setImageResource(R.drawable.very_sad_emoji_icon_png)
            stronglyDisagree.colorFilter = turnGray()
            selectedEmoji = "Strongly Disagree"

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        stronglyAgree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.smiling_emoji_with_eyes_opened)
            stronglyAgree.colorFilter = turnGray()
            selectedEmoji = "Strongly Agree"

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        neutralFace.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.neutral_face_emoji)
            neutralFace.colorFilter = turnGray()
            selectedEmoji = "Neutral."

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
        }
        disagree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.confused_face_emoji)
            disagree.colorFilter = turnGray()
            selectedEmoji = "Disagree"

            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        selectedFace.setOnClickListener {
            resetAllGray()
            selectedFace.visibility = View.INVISIBLE
            skipOrNextBtn.setBackgroundColor(Color.GRAY)
            skipOrNextBtn.setText("SKIP")
//            selectedFace.colorFilter = turnGray()
        }
    }

    fun resetGray(): ColorMatrixColorFilter {
        val matrix = ColorMatrix()
        matrix.setSaturation(1f)
        val filter = ColorMatrixColorFilter(matrix)
        return filter
    }

    fun turnGray(): ColorMatrixColorFilter {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(matrix)
        return filter
    }


    fun reset() {
        disagree.colorFilter = resetGray()
        agree.colorFilter = resetGray()
        stronglyDisagree.colorFilter = resetGray()
        stronglyAgree.colorFilter = resetGray()
        neutralFace.colorFilter = resetGray()
        selectedFace.visibility = View.INVISIBLE
        skipOrNextBtn.setBackgroundColor(Color.GRAY)
        skipOrNextBtn.setText("SKIP")
        feedbackText.setText("")
    }

    fun resetAllGray() {

        disagree.colorFilter = resetGray()
        agree.colorFilter = resetGray()
        stronglyDisagree.colorFilter = resetGray()
        stronglyAgree.colorFilter = resetGray()
        neutralFace.colorFilter = resetGray()
    }

}
