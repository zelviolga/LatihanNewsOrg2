package com.codingwithze.latihannewsorg.viewmodel

import com.codingwithze.latihannewsorg.model.Source
import com.codingwithze.latihannewsorg.network.ApiService
import okhttp3.Request
import okio.Timeout
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModelTest {

    @Mock
    lateinit var apiService: ApiService

    lateinit var viewModel: SourceViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = SourceViewModel(apiService)
    }

    @Test
    fun testCallApiSource() {
        // Given
        val expectedSources = listOf(
            Source("category1", "country1", "description1", "id1", "language1", "name1", "url1"),
            Source("category2", "country2", "description2", "id2", "language2", "name2", "url2")
        )

        val response = Response.success(expectedSources)

        Mockito.`when`(apiService.getAllSources("category")).thenReturn(
            Response.success(expectedSources) as Call<List<Source>>
        )

        // When
        viewModel.callApiSource("category")

        // Then
        val liveDataSource = viewModel.getDataSource()

        Assert.assertEquals(expectedSources, liveDataSource.value)
    }

    @Test
    fun testCallApiSourceError() {
        // Given
        val errorMessage = "Error getting sources"

        val throwable = Throwable(errorMessage)

        Mockito.`when`(apiService.getAllSources("category")).thenThrow(throwable)

        // When
        viewModel.callApiSource("category")

        // Then
        val liveDataSource = viewModel.getDataSource()

        Assert.assertNull(liveDataSource.value)
    }



}



