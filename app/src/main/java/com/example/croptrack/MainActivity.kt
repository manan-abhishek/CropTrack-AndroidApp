package com.example.croptrack

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.croptrack.Climate
import com.example.croptrack.R
import com.example.croptrack.Reel
import com.example.croptrack.Rent

class MainActivity : AppCompatActivity() {
    private var openImg: ImageView? = null
    private var openTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logo: ImageView = findViewById(R.id.logo)
        val homeBtn: LinearLayout = findViewById(R.id.btnHome)
        val climateBtn: LinearLayout = findViewById(R.id.btnClimate)
        val reelBtn: LinearLayout = findViewById(R.id.btnReel)
        val rentBtn: LinearLayout = findViewById(R.id.btnRent)

        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        val climateIcon: ImageView = findViewById(R.id.climateIcon)
        val reelIcon: ImageView = findViewById(R.id.reelIcon)
        val rentIcon: ImageView = findViewById(R.id.rentIcon)

        val home: TextView = findViewById(R.id.home)
        val climate: TextView = findViewById(R.id.climate)
        val reel: TextView = findViewById(R.id.reel)
        val rent: TextView = findViewById(R.id.rent)

        val langChanger: ImageView = findViewById(R.id.langChanger)
        val notification: ImageView = findViewById(R.id.notification)
        val notificationCount: TextView = findViewById(R.id.notificationCount)

        logo.setOnClickListener {
            val Home = Home()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, Home)
                .commit()
        }

        langChanger.setOnClickListener {
            Toast.makeText(this, "Language changer is not implemented yet...", Toast.LENGTH_SHORT).show()
        }

        notificationCount.text = "1";
        notification.setOnClickListener{
            val n = notificationCount.text.toString().toInt()
            if (n < 5 && notificationCount.visibility == TextView.VISIBLE) {
                notificationCount.text = (n+1).toString()
            } else {
                notificationCount.visibility = TextView.VISIBLE
            }
        }

        openImg = homeIcon
        openTxt = home
        openFragment(Home())
        open(homeIcon, home)

        homeBtn.setOnClickListener {
            if (openImg != homeIcon) {
                open(homeIcon, home)
                openFragment(Home())
            }
        }
        climateBtn.setOnClickListener {
            if (openImg != climateIcon) {
                open(climateIcon, climate)
                openFragment(Climate())
            }
        }
        reelBtn.setOnClickListener {
            if (openImg != reelIcon) {
                open(reelIcon, reel)
                openFragment(Reel())
            }
        }
        rentBtn.setOnClickListener {
            if (openImg != rentIcon) {
                open(rentIcon, rent)
                openFragment(Rent())
            }
        }
    }

    private fun open(newImg: ImageView, newTxt: TextView) {
        openImg?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        openTxt?.setTextColor(Color.WHITE)

        newImg.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)
        newTxt.setTextColor(ContextCompat.getColor(this, R.color.black))

        openImg = newImg
        openTxt = newTxt
    }

    private fun openFragment(fragment: Fragment) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment)
        if (currentFragment != null && currentFragment::class == fragment::class) {
            return
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()
    }
}
