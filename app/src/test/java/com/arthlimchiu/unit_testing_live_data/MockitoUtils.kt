package com.arthlimchiu.unit_testing_live_data

import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)