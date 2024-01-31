package dev.bogibek.tvjetflix.util

import dev.bogibek.jetflixtv.model.Movie


val movie = Movie(
    id = 1,
    title = "iPhone 9",
    description = "An apple mobile which is nothing like apple",
    rating = 4.34,
    category = "smartfon",
    thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
    images = listOf(
        "https://cdn.dummyjson.com/product-images/1/1.jpg",
        "https://cdn.dummyjson.com/product-images/1/2.jpg",
        "https://cdn.dummyjson.com/product-images/1/3.jpg",
        "https://cdn.dummyjson.com/product-images/1/4.jpg",
        "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
    )
)


val movies = ArrayList<Movie>().also {
    it.apply {
        add(
            Movie(
                id = 1,
                title = "Movie1",
                description = "Movie description1",
                rating = 4.34,
                category = "smartfon",
                thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                images = listOf(
                    "https://cdn.dummyjson.com/product-images/1/1.jpg",
                    "https://cdn.dummyjson.com/product-images/1/2.jpg",
                    "https://cdn.dummyjson.com/product-images/1/3.jpg",
                    "https://cdn.dummyjson.com/product-images/1/4.jpg",
                    "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
                )
            )
        )
        add(
            Movie(
                id = 2,
                title = "Movie2",
                description = "Movie description2",
                rating = 4.34,
                category = "smartfon",
                thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                images = listOf(
                    "https://cdn.dummyjson.com/product-images/1/1.jpg",
                    "https://cdn.dummyjson.com/product-images/1/2.jpg",
                    "https://cdn.dummyjson.com/product-images/1/3.jpg",
                    "https://cdn.dummyjson.com/product-images/1/4.jpg",
                    "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
                )
            )
        )
        add(
            Movie(
                id = 3,
                title = "Movie3",
                description = "Movie description3",
                rating = 4.34,
                category = "smartfon",
                thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                images = listOf(
                    "https://cdn.dummyjson.com/product-images/1/1.jpg",
                    "https://cdn.dummyjson.com/product-images/1/2.jpg",
                    "https://cdn.dummyjson.com/product-images/1/3.jpg",
                    "https://cdn.dummyjson.com/product-images/1/4.jpg",
                    "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
                )
            )
        )
        add(
            Movie(
                id = 4,
                title = "Movie4",
                description = "Movie description4",
                rating = 4.34,
                category = "smartfon",
                thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                images = listOf(
                    "https://cdn.dummyjson.com/product-images/1/1.jpg",
                    "https://cdn.dummyjson.com/product-images/1/2.jpg",
                    "https://cdn.dummyjson.com/product-images/1/3.jpg",
                    "https://cdn.dummyjson.com/product-images/1/4.jpg",
                    "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
                )
            )
        )
    }

}