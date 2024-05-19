package com.application.uts


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.uts.databinding.DetailBeritaBinding

class DetailBerita : AppCompatActivity() {
    private lateinit var binding: DetailBeritaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailBeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val imageId = intent.getIntExtra("imageId", R.drawable.shani)

        binding.txtjudul.text = title
        binding.txtDescription.text = desc
        binding.imgView.setImageResource(imageId)
    }
}