package com.example.jetpack_compose.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.jetpack_compose.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GlideImageWithPreview(
    imageModel: Any?,
    modifier: Modifier? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    if (imageModel == null){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = contentDescription,
            modifier = modifier ?: Modifier,
            alignment = Alignment.Center,
            contentScale = contentScale
        )
    }
    else{
        GlideImage(
            imageModel = imageModel,
            contentDescription = contentDescription,
            modifier = modifier ?: Modifier,
            contentScale = contentScale
        )
    }
}