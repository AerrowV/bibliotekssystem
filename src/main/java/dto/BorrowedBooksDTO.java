package dto;

public class BorrowedBooksDTO {

    public int lender_id;
    public String name;
    public String address;
    public int postalCode;
    private int book_id;
    private String title;
    private int release_year;
    private int author_id;
    private String author_name;

    public BorrowedBooksDTO(int lender_id, String name, String address, int postalCode, int book_id, String title, int release_year, int author_id, String author_name) {
        this.lender_id = lender_id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.book_id = book_id;
        this.title = title;
        this.release_year = release_year;
        this.author_id = author_id;
        this.author_name = author_name;
    }

    public int getLender_id() {
        return lender_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
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

    public String getAuthor_name() {
        return author_name;
    }

    @Override
    public String toString() {
        return "BorrowedBooksDTO{" +
                "lender_id=" + lender_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", book_id=" + book_id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                ", author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                '}';
    }
}
