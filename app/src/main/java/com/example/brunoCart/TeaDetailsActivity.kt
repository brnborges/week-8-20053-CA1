package com.example.brunoCart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.brunoCart.databinding.ActivityTeaDetailsBinding
import kotlinx.android.synthetic.main.activity_tea_details.*

class TeaDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityTeaDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tea_details)
        tea_name.text = getIntent().getStringExtra("PRODUCTNAME")
        tea_price.text = getIntent().getStringExtra("PRODUCTPRICE")
        tea_description.text = getIntent().getStringExtra("PRODUCTDESC")
        tealogo.setImageResource(getIntent().getStringExtra("PRODUCTLOGO").toInt())
    }
}
