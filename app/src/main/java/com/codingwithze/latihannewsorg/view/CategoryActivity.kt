package com.codingwithze.latihannewsorg.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithze.latihannewsorg.R
import com.codingwithze.latihannewsorg.databinding.ActivityCategoryBinding
import com.codingwithze.latihannewsorg.model.CategoryData
import com.codingwithze.latihannewsorg.view.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoryBinding
    private lateinit var categoryAdapter  : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCategory = arrayListOf(
            CategoryData("BUSINESS", R.drawable.business),
            CategoryData("ENTERTAINMENT",R.drawable.entertainment),
            CategoryData("GENERAL",R.drawable.general),
            CategoryData("HEALTH",R.drawable.health),
            CategoryData("SCIENCE",R.drawable.science),
            CategoryData("SPORTS",R.drawable.sports),
            CategoryData("TECHNOLOGY",R.drawable.technology)
        )

        categoryAdapter = CategoryAdapter(listCategory)
        binding.rvCategory.apply{
            layoutManager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick={
                val categ = it.name
                val inten = Intent(context, SourceActivity::class.java)
                inten.putExtra("name",categ)
                startActivity(inten)
            }
        }


    }


}