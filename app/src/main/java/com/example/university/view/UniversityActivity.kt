package com.example.university.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.university.ItemClickListener
import com.example.university.adapter.UniversityAdapter
import com.example.university.databinding.ActivityUniversityBinding
import com.example.university.services.isOnline
import com.example.university.viewmodel.UniversityViewModel
import org.koin.android.ext.android.inject

class UniversityActivity : AppCompatActivity(),ItemClickListener{
    private lateinit var binding: ActivityUniversityBinding
    private lateinit var context: Context
    private lateinit var adapter: UniversityAdapter
    private val viewModel: UniversityViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this@UniversityActivity
        supportActionBar!!.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isOnline(context)) {
                viewModel.getUniList()!!
                    .observe(context as UniversityActivity, { uniList ->

                        if (uniList != null) {
                            binding.spaceRecycler.layoutManager =
                                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            adapter =
                                UniversityAdapter(
                                    context,
                                    uniList,
                                    context as UniversityActivity
                                )
                            binding.spaceRecycler.adapter = adapter
                            adapter.setUniList(uniList)
                            binding.progressBar.visibility = View.GONE
                        }

                    })

            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "Check your Network Connection", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(s: String) {
        val intent=Intent(this@UniversityActivity,UniversityWebActivity::class.java)
        intent.putExtra("web_url",s)
        startActivity(intent)
    }
}