package com.dicoding.gunma

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissionproyekaplikasisederhana.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvPhones: RecyclerView
    private var list: ArrayList<Phone> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPhones = findViewById(R.id.rv_phones)
        rvPhones.setHasFixedSize(true)

        list.addAll(PhonesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPhones.layoutManager = LinearLayoutManager(this)
        val listPhoneAdapter = ListPhoneAdapter(list)
        rvPhones.adapter = listPhoneAdapter

        listPhoneAdapter.setOnItemClickCallback(object :
            ListPhoneAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Phone) {
                showSelectedPhone(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
            R.id.action_website -> {
                val url = "http://www.tokopedia.com/colorsstore"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }
    }

    private fun showSelectedPhone(phone: Phone) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_ID, phone.id)
        startActivity(detailIntent)
    }
}