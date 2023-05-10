package com.codingwithze.latihannewsorg.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithze.latihannewsorg.R
import com.codingwithze.latihannewsorg.databinding.ActivitySourceBinding
import com.codingwithze.latihannewsorg.view.adapter.SourceAdapter
import com.codingwithze.latihannewsorg.viewmodel.SourceViewModel

class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter : SourceAdapter
    lateinit var sourceVm : SourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)
        sourceAdapter = SourceAdapter(ArrayList())
        sourceVm.getDataSource().observe(this, Observer {
            sourceAdapter = SourceAdapter(it!!)
            val layoutMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvSource.layoutManager = layoutMan
            binding.rvSource.adapter = sourceAdapter
        })

        val datacat = intent.extras!!.getString("name")
        sourceVm.callApiSource(datacat.toString())
    }



}