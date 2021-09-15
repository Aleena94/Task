package com.example.university.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.university.databinding.ActivityUniversityWebBinding

class UniversityWebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUniversityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webUni.settings.javaScriptEnabled
        val webUrl = intent.getStringExtra("web_url").toString()
        binding.webUni.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        binding.webUni.loadUrl(webUrl)
    }
}