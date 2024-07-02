package dev.tomco.class24b_and_8.Interfaces;

import dev.tomco.class24b_and_8.Models.Movie;

public interface MovieCallback {
    void favoriteButtonClicked(Movie movie, int position);
}
