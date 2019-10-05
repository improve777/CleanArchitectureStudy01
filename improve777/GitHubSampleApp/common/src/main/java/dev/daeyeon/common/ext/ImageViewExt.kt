package dev.daeyeon.common.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import dev.daeyeon.common.module.GlideApp

@BindingAdapter(value = ["imgUri"])
fun ImageView.setImgUri(imgUri: String) {
    GlideApp.with(this.context)
        .load(imgUri)
        .fitCenter()
        .into(this)
}