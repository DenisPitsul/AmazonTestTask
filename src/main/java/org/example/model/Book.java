package org.example.model;

import java.util.List;
import java.util.Objects;

public class Book {
    private boolean isBestSeller;
    private String name;
    private String author;
    private List<String> prices;

    public Book(boolean isBestSeller, String name, String author, List<String> prices) {
        this.isBestSeller = isBestSeller;
        this.name = name;
        this.author = author;
        this.prices = prices;
    }

    public Book(boolean isBestSeller, String name, String author) {
        this.isBestSeller = isBestSeller;
        this.name = name;
        this.author = author;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "isBestSeller=" + isBestSeller +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", prices=" + prices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isBestSeller == book.isBestSeller && name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBestSeller, name, author);
    }
}
