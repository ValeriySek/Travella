package com.app.travella.android

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.travella.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.app.travella.android.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import dagger.hilt.android.AndroidEntryPoint

fun greet(): String {
    return Greeting().greeting()
}
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        viewModel.getData().observe(this) {
            Log.i("TAGGG", "data $it")
        }

    }

    override fun onMapReady(map: GoogleMap) {


//        val list = listOf(
//            Pair(
//                LatLng(10.0, 20.0),
//                R.drawable.img
//            ),
//            Pair(
//                LatLng(20.0, 30.0),
//                R.drawable.img_1
//            ),
//            Pair(
//                LatLng(40.0, 60.0),
//                R.drawable.img_2
//            ),
//            Pair(
//                LatLng(60.0, 40.0),
//                R.drawable.img_3
//            ),
//            Pair(
//                LatLng(65.0, 15.0),
//                R.drawable.img_4
//            ),
//            Pair(
//                LatLng(45.0, 10.0),
//                R.drawable.img_5
//            )
//        )
//
//        Log.i("TAGG", "onMapReady")
//
//        list.forEach{
//
//            Picasso.get().load(it.second).into(object : Target {
//                override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom?) {
//                    Log.i("TAGG", "bitmap $bitmap")
//                    val bp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height)
//
//                    val b = Bitmap.createScaledBitmap(bp, 225,225, false)
//
//                    val img = createBitmap(b)
//
//                    map.addMarker(
//                        MarkerOptions().position(it.first).icon(BitmapDescriptorFactory.fromBitmap(img))
//                    )
//                }
//
//                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//                    Log.i("TAGG", e.toString())
//                }
//
//                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
//
//            })
//        }





//        val size = 225
//        val drawable =
//            ContextCompat.getDrawable(this, R.drawable.img) as Drawable
//        val img = drawable.toBitmap(size, size, Bitmap.Config.ARGB_8888)
//
//        val bitmap = createBitmap(img)
//
//        map.addMarker(
//            MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromBitmap(bitmap))
//        )



    }

    private fun createBitmap(drawable: Bitmap): Bitmap {
        val size = 250
        val height = size * 1.3f
        val bitmap = Bitmap.createBitmap(size, height.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val clipedBitmap = clipBitmap(drawable)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.FILL
        }

        canvas.drawRoundRect(0f, 0f, size.toFloat(), size.toFloat(), size / 5f, size / 5f, paint)
//        canvas.drawPath(path(), paint)
        paint.pathEffect = CornerPathEffect(size / 10f)
        canvas.drawPath(path(size.toFloat()), paint)
        canvas.drawCircle(size / 2f, size * 1.2f, size / 40f, paint)
        canvas.drawBitmap(clipedBitmap, size / 20f, size / 20f, paint)
        return bitmap
    }

    private fun clipBitmap(img: Bitmap): Bitmap {
        val size = 225
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)


        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val w = img.width.toFloat()
        canvas.drawRoundRect(0f, 0f, w, w, w / 5f, w / 5f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(img, 0f, 0f, paint)

        return bitmap
    }

    fun path(size: Float): Path {
        return Path().apply {
            reset()
            moveTo(size * 0.8f, size)
            lineTo(size * 0.6f, size)
            lineTo(size * 0.5f, size * 1.15f)
            lineTo(size * 0.4f, size)
            lineTo(size * 0.2f, size)
            close()
        }
    }
}


