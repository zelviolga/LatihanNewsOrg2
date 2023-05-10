package com.codingwithze.latihannewsorg

import com.codingwithze.latihannewsorg.model.Source
import com.codingwithze.latihannewsorg.network.ApiService
import okhttp3.Request
import okio.Timeout
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiServiceTest {
    @Mock
    lateinit var apiService: ApiService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test getAllSources`() {
        // Given
        val category = "some_category"
        val expectedSources = listOf(
            Source("category1", "country1", "description1", "id1", "language1", "name1", "url1"),
            Source("category2", "country2", "description2", "id2", "language2", "name2", "url2")
        )

        val call: Call<List<Source>> = object : Call<List<Source>> {
            override fun enqueue(callback: Callback<List<Source>>) {}
            override fun isExecuted(): Boolean = false
            override fun clone(): Call<List<Source>> = this
            override fun isCanceled(): Boolean = false
            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

            override fun cancel() {}
            override fun execute(): Response<List<Source>> =
                Response.success(expectedSources)
        }

        `when`(apiService.getAllSources(category)).thenReturn(call)

        // When
        val response = apiService.getAllSources(category).execute()

        // Then
        assertEquals(expectedSources, response.body())
    }
}