package com.sankdev.streamapi;

import java.util.ArrayList;
import java.util.List;

public class MovieListProgram {

    public static void main(String[] args) {

        final List<Movie> movies = new ArrayList<>(7);
        movies.add(new Movie("Batman", "Tim Burton", 1989, 7.9));
        movies.add(new Movie("Batman Returns", "Tim Burton", 1992, 7.0));
        movies.add(new Movie("Batman Forever", "Joel Schumacher", 1995, 5.4));
        movies.add(new Movie("Batman & Robin", "Joel Schumacher", 1997, 3.7));
        movies.add(new Movie("Batman Begins", "Christopher Nolan", 2005, 8.3));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", 2007, 9.0));
        movies.add(new Movie("The Dark Knight Rises", "Christopher Nolan", 2012, 8.5));

        MovieList movieListImperative = new MovieListImperative();

        List<String> movieTitlesImperative = movieListImperative.getMovieTitles(movies);
        System.out.println("All Movie Titles in imperative style: "
                + System.lineSeparator() + movieTitlesImperative);

        List<Movie> nolanMovies = movieListImperative.getNolanMovies(movies);
        System.out.println("Nolan Movie Titles in imperative style: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(nolanMovies));

        List<Movie> bestMovies = movieListImperative.getBestMovies(movies);
        System.out.println("Best Movie Titles in imperative style: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(bestMovies));

        double averageNolanRating = movieListImperative.getAverageRating(nolanMovies);
        System.out.println("Average Rating of Nolan movies in imperative style"
                + System.lineSeparator() + averageNolanRating);

        List<Movie> moviesOlderThan2000 = movieListImperative.getMoviesOlderThan2000(movies);
        System.out.println("Movies older than 2000 in imperative style: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(moviesOlderThan2000));

    }

}
