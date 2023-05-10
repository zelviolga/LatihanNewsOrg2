package com.codingwithze.latihannewsorg.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codingwithze.latihannewsorg.model.Source
import com.codingwithze.latihannewsorg.network.ApiService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class SourceViewModelTestDua{

    lateinit var service: ApiService

    @Before
    fun setUp(){
        //fungsi mockk() untuk membuat objek palsu (mock) dari kelas yang ingin kita uji. -> APiService
        service = mockk()
    }

    @Test
    fun testRetriveData(): Unit = runBlocking {
        //membuat objek palsu (mock) responseRetrive dari kelas Call<List<Source>>
        //Objek palsu ini akan digunakan sebagai respons palsu dari pemanggilan service.getAllSources().
        val responseRetrive = mockk<Call<List<Source>>>()

        every {
            runBlocking {
                service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        } returns responseRetrive
        val result = service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")

        //verify, kita memastikan bahwa metode service.getAllSources() benar-benar dipanggil dengan argumen yang sesuai.

        verify {
            runBlocking {
                service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        }

        //assertEquals, kita membandingkan nilai result yang diperoleh dari pemanggilan service.getAllSources()
        // dengan objek palsu responseRetrive, untuk memastikan bahwa hasilnya sesuai dengan yang diharapkan.
        assertEquals(result,responseRetrive)

    }
}