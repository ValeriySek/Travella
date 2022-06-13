package com.app.travella.android


data class LatLng(
    val lat: Double,
    val lang: Double
)

data class Test(
    val latLng: LatLng,
    val name: String
)