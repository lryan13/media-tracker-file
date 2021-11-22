package com.techelevator;


import java.util.Calendar;

public class Series extends Media{

    private int totalEpisodes;
    private int episodesWatched;

    public Series(String title, Calendar startDate, String genre, int totalEpisodes) {
        super(title, startDate, genre);
        this.totalEpisodes = totalEpisodes;
        this.episodesWatched = 0;
    }

    public Series(String title, Calendar startDate, String genre, int totalEpisodes, Calendar endDate) {
        super(title, startDate, genre, endDate);
        this.totalEpisodes = totalEpisodes;
        this.episodesWatched = 0;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public int getEpisodesWatched() {
        return episodesWatched;
    }

    public void setEpisodesWatched(int episodesWatched) {
        if(episodesWatched > totalEpisodes) {
            episodesWatched = totalEpisodes;
        }
        if (episodesWatched < 0) {
            episodesWatched = 0;
        }
        this.episodesWatched = episodesWatched;
        if (this.episodesWatched == totalEpisodes) {
            finish();
        }
    }

    public int getEpisodesLeft() {
        return totalEpisodes - episodesWatched;
    }

    @Override
    public void finish() {
        super.finish();
        episodesWatched = totalEpisodes;
    }

    @Override
    public String toString() {
        try {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: " + displayEndDate() + " total episodes: " + getTotalEpisodes() + " episodes watched: " + getEpisodesWatched() + " episodes remaining: " + getEpisodesLeft() + " complete: " + isComplete() + "\n";
        } catch (NullPointerException e) {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: N/A" + " total episodes: " + getTotalEpisodes() + " episodes watched: " + getEpisodesWatched() + " episodes remaining: " + getEpisodesLeft() + " complete: " + isComplete() + "\n";
        }
    }
}