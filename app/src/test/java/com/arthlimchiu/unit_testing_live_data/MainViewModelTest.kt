package com.arthlimchiu.unit_testing_live_data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    private val observer: Observer<User> = mock()

    @Before
    fun before() {
        viewModel = MainViewModel()
        viewModel.user.observeForever(observer)
    }

    @Test
    fun fetchUser_ShouldReturnUser() {
        val expectedUser = User(1)

        viewModel.fetchUser(expectedUser.id)

        val captor = ArgumentCaptor.forClass(User::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertEquals(expectedUser, value)
        }
    }
}