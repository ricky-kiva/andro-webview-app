package com.rickyslash.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// WebView used to display web page as part of Activity
// Additional adjustment on WebView such:
// - fullscreen with WebChromeClient
// --- WebChromeClient also called when WebView need to change UI, like closing/opening window, or send Javascript dialog
// - handle event that affect rendering process (error, navigation with WebViewClient)
// - activate Javascript by modifying WebSettings
// - use javascript to access Android Framework object