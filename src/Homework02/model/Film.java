package Homework02.model;

import java.util.Arrays;
import java.util.List;

public class Film {

    private String name;

    private int year;

    private String director;

    private double imdb;

    private int time;

    private List<Category> categoryArr;

    private List<String> platformList;

    private List<String> sessionTimes;


    public Film() {
        this.name = "Lord of the Rings";
        this.year = 2001;
    }

    public Film(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public Film(String name, int year, String director, double imdb, int time, List<Category> categoryArr, List<String> platformList, List<String> sessionTimes) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.imdb = imdb;
        this.time = time;
        this.categoryArr = categoryArr;
        this.platformList = platformList;
        this.sessionTimes = sessionTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public List<Category> getCategoryArr() {
        return categoryArr;
    }

    public void setCategoryArr(List<Category> categoryArr) {
        this.categoryArr = categoryArr;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<String> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<String> platformList) {
        this.platformList = platformList;
    }

    public List<String> getSessionTimes() {
        return sessionTimes;
    }

    public void setSessionTimes(List<String> sessionTimes) {
        this.sessionTimes = sessionTimes;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", imdb=" + imdb +
                ", time=" + time +
                ", categoryArr=" + categoryArr +
                ", platformList=" + platformList +
                ", sessionTimes=" + sessionTimes +
                '}';
    }
}

