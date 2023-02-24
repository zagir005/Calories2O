package com.example.caloriesmonitor.core.reaction

sealed class Reaction<T> {
    class OnSuccess<T>(val data: T): Reaction<T>()

    class OnError<T>(val error: Throwable): Reaction<T>()

    class OnLoading<T> : Reaction<T>()

    class IsEmpty<T> : Reaction<T>()
}