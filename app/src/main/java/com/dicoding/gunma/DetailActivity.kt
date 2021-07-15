package com.dicoding.gunma

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.submissionproyekaplikasisederhana.R
import java.text.NumberFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    private var list: ArrayList<Phone> = arrayListOf()

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNameReceived: TextView = findViewById(R.id.detailName)
        val tvDetailReceived: TextView = findViewById(R.id.detailDetail)
        val tvPriceReceived: TextView = findViewById(R.id.detailPrice)
        val tvPhotoReceived: ImageView = findViewById(R.id.detailImage)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val name = PhonesData.listData[id].name
        val detail = PhonesData.listData[id].detail
        val price = PhonesData.listData[id].price
        val photo = PhonesData.listData[id].photo

        tvNameReceived.text = name
        tvDetailReceived.text = detail

        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.setMaximumFractionDigits(0)
        format.setCurrency(Currency.getInstance("IDR"))

        tvPriceReceived.text = format.format(price).toString()
        tvPhotoReceived.setImageResource(photo)
    }
}