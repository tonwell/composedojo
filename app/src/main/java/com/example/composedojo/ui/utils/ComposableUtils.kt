package com.example.composedojo.ui.utils

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun HtmlText(
    text: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
                } else {
                    setText(Html.fromHtml(text))
                }
            }
        },
        modifier = modifier
    )
}