package com.example.recylerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recylerexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleAdapter = SimpleRecycleViewAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = simpleAdapter
        var itemDataList = listOf(
            SomeTextItem(
                id = 1,
                text = "1"
            ),
            SomeTextItem(
                id = 2,
                text = "2"
            ),
            SomeTextItem(
                id = 3,
                text = "3"
            ))

        simpleAdapter.submitList(itemDataList)
    }
}