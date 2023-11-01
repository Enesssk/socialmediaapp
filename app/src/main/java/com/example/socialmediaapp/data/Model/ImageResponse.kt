package com.example.socialmediaapp.data.Model

data class ImageResponse (

    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int

        ) {
}