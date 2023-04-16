package com.example.novelkomik

import NovelAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Novel>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var subheading : Array<String>
    lateinit var novels : Array<String>
    lateinit var Novel: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.novel1,
            R.drawable.novel2,
            R.drawable.novel3,
            R.drawable.novel4,
            R.drawable.novel5,
            R.drawable.novel6,
            R.drawable.novel7,
            R.drawable.novel8,
            R.drawable.novel9,
            R.drawable.novel10,
            R.drawable.novel11,
            R.drawable.novel12,
            R.drawable.novel13,
            R.drawable.novel14,
            R.drawable.novel15
        )
        heading = arrayOf(
            "GrandAncestorBloodline",
            "DimensionalDescent",
            "ReturnOfTheMountHuaSect",
            "ReaperOfTheDriftingMoon",
            "ReturnOfTheFrozenPlayer",
            "GeniusOfTheUniqueLeague",
            "TheDarkMageBackToEnlistment",
            "PathOfTheWudang",
            "SuperhumanBattlefield",
            "TheBeginningAfterTheEnd",
            "TrashOfTheCountFamily",
            "NanoMachine",
            "SupremacyGame",
            "SwordMasterOfTheYoungestSon",
            "MyDiscipleAreAllVillain"

        )
        subheading = arrayOf(
            getString(R.string.view1),
            getString(R.string.view2),
            getString(R.string.view3),
            getString(R.string.view4),
            getString(R.string.view5),
            getString(R.string.view6),
            getString(R.string.view7),
            getString(R.string.view8),
            getString(R.string.view9),
            getString(R.string.view10),
            getString(R.string.view11),
            getString(R.string.view12),
            getString(R.string.view13),
            getString(R.string.view14),
            getString(R.string.view15),

            )
        novels = arrayOf( //deksripsi
            getString(R.string.DesNo1),
            getString(R.string.DesNo2),
            getString(R.string.DesNo3),
            getString(R.string.DesNo4),
            getString(R.string.DesNo5),
            getString(R.string.DesNo6),
            getString(R.string.DesNo7),
            getString(R.string.DesNo8),
            getString(R.string.DesNo9),
            getString(R.string.DesNo10),
            getString(R.string.DesNo11),
            getString(R.string.DesNo12),
            getString(R.string.DesNo13),
            getString(R.string.DesNo14),
            getString(R.string.DesNo15),

        )

        Novel = arrayOf(
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
            "Sinopsis",
        )


        newRecyclerView = findViewById(R.id.rv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Novel>()
        getuserdata()

    }

    private fun getuserdata() {

        for (i in imageId.indices){

            val novel = Novel(imageId[i],heading[i],subheading[i],Novel[i])
            newArrayList.add(novel)

        }

        val adapter = NovelAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : NovelAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("imageId", newArrayList[position].titleImage)
                intent.putExtra("detail",novels[position])
                startActivity(intent)
            }
        })

    }

}