package com.techelevator.test;

import com.techelevator.Series;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class SeriesTests {

    @Test
    public void getEpisodesLeft_returns_correct_value_when_no_episodes_watched() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);

        int expected = 300;
        int actual = series.getEpisodesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEpisodesLeft_returns_correct_value_when_some_episodes_watched() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(160);
        int expected = 140;
        int actual = series.getEpisodesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEpisodesLeft_returns_correct_value_when_all_episodes_watched() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(300);
        int expected = 0;
        int actual = series.getEpisodesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void finish_sets_complete_status_to_true_when_called() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.finish();

        boolean expected = true;
        boolean actual = series.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void complete_status_is_false_when_finish_is_not_called() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);

        boolean expected = false;
        boolean actual = series.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEpisodesWatched_sets_complete_status_to_true_when_totalEpisodes_and_episodesWatched_are_the_same() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(300);

        boolean expected = true;
        boolean actual = series.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEpisodesWatched_does_not_effect_complete_status_when_totalEpisodes_and_episodesWatched_are_not_the_same() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(299);

        boolean expected = false;
        boolean actual = series.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEpisodesWatched_sets_to_totalEpisodes_when_given_a_value_higher_than_totalEpisodes() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(310);

        int expected = 300;
        int actual = series.getEpisodesWatched();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEpisodesWatched_sets_to_zero_when_given_a_value_lower_than_zero() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Series series = new Series("Naruto", startDate, "shonen", 300);
        series.setEpisodesWatched(-5);

        int expected = 0;
        int actual = series.getEpisodesWatched();

        Assert.assertEquals(expected, actual);
    }
}