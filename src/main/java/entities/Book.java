package entities;

public class Book {

    private int book_id;
    private String title;
    private int release_year;
    private int author_id;

    public Book(int book_id, String title, int release_year, int author_id) {
        this.book_id = book_id;
        this.title = title;
        this.release_year = release_year;
        this.author_id = author_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                ", author_id=" + author_id +
                '}';
    }
}
