package com.hb.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.hb.data.datasource.WallpaperDataSourceImplTest
import com.hb.data.repository.WallpaperRepositoryImplTest
import com.hb.data.usecase.GetPhotosUseCaseTest
import com.hb.domain.commun.onSuccess
import com.hb.domain.models.PhotoModel
import com.hb.domain.usecase.GePhotosRequest
import com.hb.domain.usecase.GetListPhotosUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
class GetListPhotosTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var getListPhotosUseCase: GetListPhotosUseCase
    private lateinit var wallpaperRepositoryImplTest: WallpaperRepositoryImplTest

    @Before
    @Throws(IOException::class)
    fun init() {
        wallpaperRepositoryImplTest = WallpaperRepositoryImplTest(WallpaperDataSourceImplTest())
        getListPhotosUseCase = GetPhotosUseCaseTest(wallpaperRepositoryImplTest)
    }

    @Test
    fun getPhotosList() = runBlocking {
        var listPhotos: List<PhotoModel>? = null
        getListPhotosUseCase(GePhotosRequest(1, "latest"))
            .onSuccess {
                listPhotos = it
            }
        Truth.assertThat(listPhotos).isNotEmpty()
        Truth.assertThat(listPhotos?.size).isAtLeast(5)
        Truth.assertThat(listPhotos?.get(0)?.id).matches("EzYq1HOl5_8")
        Truth.assertThat(listPhotos?.get(0)?.description).isNotNull()
    }
}