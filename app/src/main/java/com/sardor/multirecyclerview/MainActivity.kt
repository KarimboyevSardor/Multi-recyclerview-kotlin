package com.sardor.multirecyclerview

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sardor.multirecyclerview.adapters.ParentAdapter
import com.sardor.multirecyclerview.databinding.ActivityMainBinding
import com.sardor.multirecyclerview.models.ChildData
import com.sardor.multirecyclerview.models.ParentData

class MainActivity : AppCompatActivity() {
    lateinit var parentAdapter: ParentAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        parentAdapter = ParentAdapter(onItemClick = { it ->
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        val sampleData = mutableListOf(
            ParentData(
                id = 1,
                name = "Parent 1",
                childData = mutableListOf(
                    ChildData(1, "https://via.placeholder.com/150/FF0000")
                )
            ),
            ParentData(
                id = 2,
                name = "Parent 2",
                childData = mutableListOf(
                    ChildData(4, "https://via.placeholder.com/150/FFFF00"),
                    ChildData(5, "https://via.placeholder.com/150/FF00FF"),
                )
            ),
            ParentData(
                id = 3,
                name = "Parent 3",
                childData = mutableListOf(
                    ChildData(9, "https://via.placeholder.com/150/000080"),
                    ChildData(10, "https://via.placeholder.com/150/808000"),
                    ChildData(11, "https://via.placeholder.com/150/800080"),
                )
            ),
            ParentData(
                id = 4,
                name = "Parent 4",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                )
            ),
            ParentData(
                id = 5,
                name = "Parent 5",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                )
            ),
            ParentData(
                id = 6,
                name = "Parent 6",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                )
            ),
            ParentData(
                id = 7,
                name = "Parent 7",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                )
            ),
            ParentData(
                id = 8,
                name = "Parent 8",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                )
            ),
            ParentData(
                id = 9,
                name = "Parent 9",
                childData = mutableListOf(
                    ChildData(13, "https://via.placeholder.com/150/FF4500"),
                    ChildData(14, "https://via.placeholder.com/150/2E8B57"),
                    ChildData(15, "https://via.placeholder.com/150/1E90FF"),
                    ChildData(16, "https://via.placeholder.com/150/DA70D6"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),
                    ChildData(17, "https://via.placeholder.com/150/FFD700"),

                    )
            )
        )

        parentAdapter.onSubmit(sampleData)
        binding.parentRv.adapter = parentAdapter
    }
}