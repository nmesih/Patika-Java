package Homework02.model;

public class Category {

    private String name;

    private int filmCount;

    public Category(){

    }
    public Category(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", filmCount=" + filmCount +
                '}';
    }
}
