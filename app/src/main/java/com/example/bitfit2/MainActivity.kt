package com.example.bitfit2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val entries = mutableListOf<UserEntry>()
    private lateinit var adapter: UserEntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val tvSummary = findViewById<TextView>(R.id.tvSummary)

        adapter = UserEntryAdapter(entries)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val height = etHeight.text.toString().toDoubleOrNull()
            val weight = etWeight.text.toString().toDoubleOrNull()

            if (height != null && weight != null) {
                entries.add(UserEntry(height, weight))
                adapter.notifyItemInserted(entries.size - 1)
                updateSummary(tvSummary)
            }
        }
    }

    private fun updateSummary(tvSummary: TextView) {
        val summary = entries.joinToString("\n") { "Height: ${it.height}, Weight: ${it.weight}" }
        tvSummary.text = summary
    }
}
