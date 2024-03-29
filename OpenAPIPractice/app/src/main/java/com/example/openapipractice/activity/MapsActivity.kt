package com.example.openapipractice.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.openapipractice.*
import com.example.openapipractice.data.Library
import com.example.openapipractice.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    //6e6b5a706b627269313134576e4d5157
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var libraryViewModel: LibraryViewModel
//    private lateinit var libraryRepository: LibraryRepository
    private lateinit var libraryDAO: LibraryDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        libraryViewModel = ViewModelProvider(this).get(LibraryViewModel::class.java)


// Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        loadLibrary()
//        showLibrary(LibraryViewModel.result)

    }


    private fun loadLibrary() {
        val retrofit = Retrofit.Builder()
            .baseUrl(SeoulOpenApi.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SeoulOpenService::class.java)

        service.getLibraries(key=SeoulOpenApi.API_KEY, end = 100, page = 10)
            .enqueue(object : Callback<Library> {
                override fun onFailure(call: Call<Library>, t: Throwable) {
                    Toast.makeText(this@MapsActivity, "데이터를 가져올 수 없습니다.", Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<Library>, response: Response<Library>) {
                    val result = response.body()
//                    if (result != null) {
//                        val libraryData = result.SeoulPublicLibraryInfo.row
//                        libraryViewModel.insertLibraryData(libraryData)
//                    }
                    showLibrary(result)
                }
            })
    }

    fun showLibrary(result:Library?) {

        result.let{
            val latLngbounds = LatLngBounds.builder()
                for(library in it!!.SeoulPublicLibraryInfo.row) {
                    val position = LatLng(library.XCNTS.toDouble(), library.YDNTS.toDouble())
                    val marker = MarkerOptions().position(position).title(library.LBRRY_NAME)
                    mMap.addMarker(marker)

                    latLngbounds.include(position)
                }
            val bounds = latLngbounds.build()
            val padding = 0

            val camera = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            mMap.moveCamera(camera)
        }
    }
}