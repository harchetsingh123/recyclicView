
package com.harchet.recyclingviewapp


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val newRecyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)
        val list = getUserData()
        newRecyclerview.adapter= Adapter(list)




    }

    private fun getUserData(): ArrayList<insects>{
       val imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d

        )

        val heading= arrayOf(
            "This is a snail",
            "This is a bee",
            "This is a spider",
            "This is a ladybug"
        )


        val newArrayList = arrayListOf<insects>()
         for(i in imageId.indices){
             val new = insects(imageId[i],heading[i])
             newArrayList.add(new)
         }


        return newArrayList

    }



}