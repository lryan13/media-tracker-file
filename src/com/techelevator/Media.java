package com.techelevator;

import java.util.Calendar;

public abstract class Media {
    private String title;
    private Calendar startDate;
    private Calendar endDate;
    private String genre;
    private boolean isComplete;

    public Media(String title, Calendar startDate, String genre) {
        this.title = title;
        this.startDate = startDate;
        this.genre = genre;
    }

    public Media(String title, Calendar startDate, String genre, Calendar endDate) {
        this.title = title;
        this.startDate = startDate;
        this.genre = genre;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String displayStartDate() {
        return startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.DATE) + "/" + startDate.get(Calendar.YEAR);
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public String displayEndDate() {
        return endDate.get(Calendar.MONTH) + "/" + endDate.get(Calendar.DATE) + "/" + endDate.get(Calendar.YEAR);
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public abstract String toString();

    public void finish() {
        this.isComplete = true;
    }

    public void notFinish() {
        this.isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }
}