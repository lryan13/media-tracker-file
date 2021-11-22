package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Media> library = new ArrayList<>();
        System.out.println("Welcome to this media library");
        int option = 1;
        while (option >= 1 && option <= 5) {
            System.out.println("--------------------------");
            System.out.println("Press:");
            System.out.println("0 to quit");
            System.out.println("1 to add a media");
            System.out.println("2 to remove a media");
            System.out.println("3 to display library");
            System.out.println("4 to change entries");
            System.out.println("5 to save library to a file");
            System.out.println("--------------------------");
            option = scanner.nextInt();
            if (option == 1) {
                addItem(library);
            } else if (option == 2) {
                removeItem(library);
            } else if (option == 3) {
                displayLibrary(library);
            } else if (option == 4) {
                changeItem(library);
            } else if (option == 5) {
                saveLibrary(library);
            } else {
                System.out.println("Thank you, Goodbye!");
            }
        }
    }

    public static void addItem(List<Media> collection) {
        Scanner scanner = new Scanner(System.in);
        String mediaForm = "";
        while (!mediaForm.equals("movie") && !mediaForm.equals("book")  && !mediaForm.equals("series")) {
            System.out.println("Is this a movie, book, or series: ");
            mediaForm = scanner.nextLine().toLowerCase();
            if (!mediaForm.equals("movie") && !mediaForm.equals("book")  && !mediaForm.equals("series")) {
                System.out.println("Invalid media choice, please choose \"movie\", \"book\", or \"series\"");
            }
        }
        System.out.println("What is the title: ");
        String title = scanner.nextLine();
        System.out.println("What is the start date (mm dd yyyy): ");
        int startMonth = scanner.nextInt();
        int startDay = scanner.nextInt();
        int startYear = scanner.nextInt();
        Calendar startDate = Calendar.getInstance();
        startDate.set(startYear, startMonth, startDay);

        scanner.nextLine();
        System.out.println("What is the genre: ");
        String genre = scanner.nextLine();
        System.out.println("Would you like to add an end date now? (y/n): ");
        String option = scanner.nextLine().toLowerCase();
        int endMonth = 0;
        int endDay = 0;
        int endYear = 0;
        Calendar endDate = Calendar.getInstance();
        endDate.set(endYear, endMonth, endDay);
        if (option.equals("y")) {
            while (endDate.before(startDate)) {
                System.out.println("What is the end month, date, and year(ex: mm dd yyyy): ");
                endMonth = scanner.nextInt();
                endDay = scanner.nextInt();
                endYear = scanner.nextInt();
                endDate.set(endYear, endMonth, endDay);
                if (endDate.before(startDate)) {
                    System.out.println("End date must be after the start date, please try again");
                }
            }
            scanner.nextLine();
        }
        if (mediaForm.equals("movie")) {
            Movie movie;
            if (option.equals("y")) {
                movie = new Movie(title, startDate, genre, endDate);
            } else {
                movie = new Movie(title, startDate, genre);
            }
            collection.add(movie);
        }
        if (mediaForm.equals("series")) {
            System.out.println("How many episodes does the show have: ");
            int totalEpisodes = scanner.nextInt();
            Series series;
            if (option.equals("y")) {
                series = new Series(title, startDate, genre, totalEpisodes, endDate);
            } else {
                series = new Series(title, startDate, genre, totalEpisodes);
            }
            collection.add(series);
        }
        if (mediaForm.equals("book")) {
            System.out.println("How many pages does the book have: ");
            int totalPages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What type of book is this: ");
            String type = scanner.nextLine();
            Book book;
            if (option.equals("y")) {
                book = new Book(title, startDate, genre, totalPages, endDate, type);
            } else {
                book = new Book(title, startDate, genre, totalPages, type);
            }
            collection.add(book);
        }
        System.out.println("Entry added successfully");
    }

    public static void removeItem(List<Media> collection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the entry to be deleted: ");
        String removedTitle = scanner.nextLine();
        for (Media item : collection) {
            if (item.getTitle().equals(removedTitle)) {
                collection.remove(item);
            }
        }
        System.out.println("Entry deleted successfully");
    }

    public static void displayLibrary(List<Media> collection) {
        System.out.println(collection);
    }

    public static void changeItem(List<Media> collection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the entry to be changed: ");
        String title = scanner.nextLine();
        System.out.println("changing end date? (y/n)");
        String option = scanner.nextLine().toLowerCase();
        for (Media item : collection) {
            if (item.getTitle().equals(title)) {
                int endMonth = 0;
                int endDay = 0;
                int endYear = 0;
                Calendar newEndDate = Calendar.getInstance();
                newEndDate.set(endYear, endMonth, endDay);
                if (option.equals("y")) {
                    while (newEndDate.before(item.getStartDate())) {
                        System.out.println("What is the end month, day, and year(mm dd yyyy): ");
                        endMonth = scanner.nextInt();
                        endDay = scanner.nextInt();
                        endYear = scanner.nextInt();
                        scanner.nextLine();
                        newEndDate.set(endYear, endMonth, endDay);
                        if (newEndDate.before(item.getStartDate())) {
                            System.out.println("End date must be after the start date, please try again");
                        }
                    }
                    item.setEndDate(newEndDate);
                    System.out.println("Changing completion status? (y/n): ");
                    option = scanner.nextLine().toLowerCase();
                    if (option.equals("y")) {
                        System.out.println("complete or incomplete: ");
                        option = scanner.nextLine().toLowerCase();
                        if(option.equals("complete")) {
                            item.finish();
                        } else {
                            item.notFinish();
                        }
                    }

                }
                if (item instanceof Series) {
                    System.out.println("updating episodes watched? (y/n): ");
                    option = scanner.nextLine().toLowerCase();
                    if (option.equals("y")) {
                        System.out.println("How many episodes have been seen: ");
                        int episodesWatched = scanner.nextInt();
                        ((Series) item).setEpisodesWatched(episodesWatched);
                    }
                }
                if (item instanceof Book) {
                    System.out.println("updating pages read? (y/n)");
                    option = scanner.nextLine().toLowerCase();
                    if (option.equals("y")) {
                        System.out.println("How many pages have been read: ");
                        int pagesRead = scanner.nextInt();
                        ((Book) item).setPagesRead(pagesRead);
                    }
                }
            }

        }
    }

    public static void saveLibrary(List<Media> collection) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please provide the file path: ");
        String path = userInput.nextLine();

        File outputFile = new File(path);
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            writer.println(collection);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
}