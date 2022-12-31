package com.example.extensions

import com.example.models.Movie
import com.example.models.MovieList
import com.example.models.TvShow
import com.example.models.TvShowList
import com.example.models.tmdb.TmdbMovie
import com.example.models.tmdb.TmdbMovieList
import com.example.models.tmdb.TmdbShow
import com.example.models.tmdb.TmdbShowList
import com.example.models.ui.*

fun TmdbMovie.asMovie(): Movie = Movie(
    id = this.id,
    title = this.title,
    voteCount = this.vote_count,
    averageVote = this.vote_average,
    description = this.overview,
    posterImage = poster_path?.let {"https://image.tmdb.org/t/p/w780${this.poster_path}" } ?: "",
    backdropImage = backdrop_path?.let { "https://image.tmdb.org/t/p/w780${this.backdrop_path}" } ?: "",
    genres = this.genre_ids,
    releaseDate = this.release_date
)

fun TmdbMovieList.asMovieList(): MovieList = MovieList(
    page = this.page,
    pages = this.total_pages,
    totalCount = this.total_results,
    pageCount = results.size,
    results = this.results.map { it.asMovie() }
)

fun TmdbShow.asShow() = TvShow(
    id = this.id,
    posterImage = poster_path?.let {"https://image.tmdb.org/t/p/w780${this.poster_path}" } ?: "",
    backdropImage = backdrop_path?.let { "https://image.tmdb.org/t/p/w780${this.backdrop_path}" } ?: "",
    firstAirDate = this.first_air_date,
    genres = this.genre_ids,
    name = this.name,
    description = this.overview,
    popularity = this.popularity,
    averageVote = this.vote_average,
    voteCount = this.vote_count,
)

fun TmdbShowList.asShowList(): TvShowList = TvShowList(
    page = this.page,
    pages = this.total_pages,
    totalCount = this.total_results,
    pageCount = results.size,
    results = this.results.map { it.asShow() }
)

fun Movie.asServerUi(): ServerView = CardView(
    ColumnView(
        listOf(
            BoxView(
                constrainHeight = true,
                padding = 0,
                items = listOf(
                    FullWidthImageView(
                        this.backdropImage.ifEmpty { this.posterImage },
                        contentDescription = this.title
                    ),
                    ColumnView(
                        listOf(
                            SpacerView(),
                            TitleWithScrimView(this.title)
                        ),
                    )
                )
            ),
            AnimatedVisibility(
                BoxView(
                    constrainHeight = true,
                    padding = 8,
                    items = listOf(
                        TextView(this.description)
                    )
                )
            )
        ),
    )
)

fun TmdbMovieList.asServerUi(): ServerView =
    ListView(this.results.map { it.asMovie().asServerUi() })

fun TvShow.asServerUi(): ServerView {
    return CardView(
        ColumnView(
            listOf(
                BoxView(items = listOf(
                    FullWidthImageView(this.backdropImage.ifEmpty { this.posterImage }, contentDescription = this.name, height = 200),
                    ColumnView(
                        listOf(
                            TitleWithScrimView(this.name),
                            SpacerView(vertical = true),
                            BoxView(
                                items = listOf(
                                    TextView(
                                        text = this.description,
                                        fontSize = 16,
                                        color = "#ffffff",
                                        wrapText = false,
                                        padding = 4
                                    )
                                ),
                                bgColor = "#66000000"
                            )
                        )
                    )
                )),
                AnimatedVisibility(
                    BoxView(
                        constrainHeight = true,
                        padding = 8,
                        items = listOf(
                            ColumnView(listOf(
                                TextView(this.firstAirDate, bold = true, fontSize = 18),
                                TextView(this.description)
                            ))
                        )
                    )
                )
            )
        )
    )
}

fun TmdbShowList.asServerUi(): ServerView =
    ListView(this.results.map { it.asShow().asServerUi() })