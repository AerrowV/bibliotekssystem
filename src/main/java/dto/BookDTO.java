package dto;

public class BookDTO {

    private int book_id;
    private String title;
    private int release_year;
    private int author_id;
    private String name;

    public BookDTO(int book_id, String title, int release_year, int author_id, String name) {
        this.book_id = book_id;
        this.title = title;
        this.release_year = release_year;
        this.author_id = author_id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                ", author_id=" + author_id +
                ", name='" + name + '\'' +
                '}';
    }
}
