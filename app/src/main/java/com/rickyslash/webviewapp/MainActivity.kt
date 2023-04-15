package com.rickyslash.webviewapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        // enable javascript on webView
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                // Preview alert by javascript alert
                view?.loadUrl("javascript:alert('Web is successfully loaded')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            // override if there is Javascript alert
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                // this ensure that user has confirmed the Javascript (like when they click 'ok' on JS alert)
                result?.confirm()
                return true
            }
        }

        // load Url on webView
        webView.loadUrl("https://www.dicoding.com")
    }
}

// WebView used to display web page as part of Activity
// Additional adjustment on WebView such:
// - fullscreen with WebChromeClient
// --- WebChromeClient also called when WebView need to change UI, like closing/opening window, or send Javascript dialog
// - handle event that affect rendering process (error, navigation with WebViewClient)
// - activate Javascript by modifying WebSettings
// - use javascript to access Android Framework object