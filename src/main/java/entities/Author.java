package entities;

public class Author {

    private int author_id;
    private String name;

    public Author(int author_id, String name) {
        this.author_id = author_id;
        this.name = name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getName() {
        return name;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                '}';
    }
}
