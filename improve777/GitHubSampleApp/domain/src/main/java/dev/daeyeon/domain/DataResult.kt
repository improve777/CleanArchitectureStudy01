/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.daeyeon.domain

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class DataResult<out R> {

    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val error: Throwable) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            Loading -> "Loading"
        }
    }

    companion object {

        @JvmStatic
        fun <T> success(data: T) = Success(data)

        @JvmStatic
        fun error(t: Throwable) = Error(t)

        @JvmStatic
        fun loading() = Loading
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val DataResult<*>.succeeded
    get() = this is DataResult.Success<*> && data != null