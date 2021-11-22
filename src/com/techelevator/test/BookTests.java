package com.techelevator.test;

import com.techelevator.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class BookTests {
    @Test
    public void getPagesLeft_returns_correct_value_when_no_pages_read() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");

        int expected = 300;
        int actual = book.getPagesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPagesLeft_returns_correct_value_when_some_pages_read() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(160);
        int expected = 140;
        int actual = book.getPagesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPagesLeft_returns_correct_value_when_all_pages_read() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(300);
        int expected = 0;
        int actual = book.getPagesLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void finish_sets_complete_status_to_true_when_called() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.finish();

        boolean expected = true;
        boolean actual = book.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void complete_status_is_false_when_finish_is_not_called() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");

        boolean expected = false;
        boolean actual = book.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPagesRead_sets_complete_status_to_true_when_totalPages_and_pagesRead_are_the_same() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(300);

        boolean expected = true;
        boolean actual = book.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPagesRead_does_not_effect_complete_status_when_totalPages_and_pagesRead_are_not_the_same() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(299);

        boolean expected = false;
        boolean actual = book.isComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPagesRead_sets_to_totalPages_when_given_a_value_higher_than_totalPages() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(310);

        int expected = 300;
        int actual = book.getPagesRead();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPagesRead_sets_to_zero_when_given_a_value_lower_than_zero() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2005, 5, 20);
        Book book = new Book("Divergent", startDate, "action", 300, "chapter book");
        book.setPagesRead(-5);

        int expected = 0;
        int actual = book.getPagesRead();

        Assert.assertEquals(expected, actual);
    }
}