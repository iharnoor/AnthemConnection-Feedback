package com.iharnoor.anthemconnection

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iharnoor.anthemconnection.R.drawable.redeeming
import kotlinx.android.synthetic.main.activity_achievements.*


class Achievements : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(matrix)

        val matrix2 = ColorMatrix()
        matrix2.setSaturation(1f)
        val unfilter = ColorMatrixColorFilter(matrix2)

        survey1.colorFilter = filter
        survey5.colorFilter = filter
        survey10.colorFilter = filter
        streak3.colorFilter = filter
        streak5.colorFilter = filter
        streak10.colorFilter = filter
        streak20.colorFilter = filter
        allemojis.colorFilter = filter
        friendship.colorFilter = filter
        redeeming.colorFilter = filter
        leaderboardvisit.colorFilter = filter
        leaderboardon.colorFilter = filter

        
    }
}
