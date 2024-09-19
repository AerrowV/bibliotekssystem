package persistence;

import dto.BookDTO;
import dto.BorrowedBooksDTO;
import dto.LenderDTO;
import entities.Lender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotekMapper {

    private Database database;

    public BibliotekMapper(Database database) {
        this.database = database;
    }

    public Lender getLenderById(int lenderID) {

        String sql = "select * from laaner where laaner_id = ?";
        Lender lender = null;
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, lenderID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("navn");
                    String address = rs.getString("adresse");
                    int postalCode = rs.getInt("postnr");
                    lender = new Lender(name, address, postalCode);
                }
            } catch (SQLException e) {
                throw new SQLException("Couldn't receive lender with id: " + lenderID, e);

            }
        } catch (SQLException f) {
            throw new RuntimeException(f);
        }
        return lender;
    }

    public List<LenderDTO> findAllLenders() {
        List<LenderDTO> lenders = new ArrayList<>();
        String sql = "select laaner.laaner_id, laaner.navn, laaner.adresse, postnummer.postnr, postnummer.by " +
                "from laaner " +
                "join postnummer on laaner.postnr = postnummer.postnr";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int lenderId = rs.getInt("laaner_id");
                    String name = rs.getString("navn");
                    String address = rs.getString("adresse");
                    int postalCode = rs.getInt("postnr");
                    String city = rs.getString("by");
                    lenders.add(new LenderDTO(lenderId, name, address, postalCode, city));
                }
            } catch (SQLException e) {
                throw new SQLException("Couldn't receive lenders: " + lenders, e);

            }
        } catch (SQLException f) {
            throw new RuntimeException(f);
        }
        return lenders;
    }

    public List<BookDTO> findAllBooksAndAuthors() {
        List<BookDTO> books = new ArrayList<>();
        String sql = "select bog.bog_id, bog.titel, bog.udgivelsesaar, forfatter.forfatter_id, forfatter.navn " +
                "from bog " +
                "join forfatter on bog.forfatter_id = forfatter.forfatter_id";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bookId = rs.getInt("bog_id");
                    String title = rs.getString("titel");
                    int releaseYear = rs.getInt("udgivelsesaar");
                    int authorId = rs.getInt("forfatter_id");
                    String authorName = rs.getString("navn");
                    books.add(new BookDTO(bookId, title, releaseYear, authorId, authorName));
                }
            } catch (SQLException e) {
                throw new SQLException("Couldn't receive books: " + books, e);

            }
        } catch (SQLException f) {
            throw new RuntimeException(f);
        }
        return books;
    }

    public List<BorrowedBooksDTO> findAllBorrowedBooks() {
        List<BorrowedBooksDTO> borrowedBooks = new ArrayList<>();

        String sql = "select laaner.laaner_id, laaner.navn as laaner_navn, laaner.adresse, laaner.postnr, bog.bog_id, bog.titel as bog_titel, bog.udgivelsesaar, forfatter.forfatter_id, forfatter.navn as forfatter_navn " +
                "from udlaan " +
                "join laaner on udlaan.laaner_id = laaner.laaner_id " +
                "join bog on udlaan.bog_id = bog.bog_id " +
                "join forfatter on bog.forfatter_id = forfatter.forfatter_id";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int lenderId = rs.getInt("laaner_id");
                    String name = rs.getString("laaner_navn");
                    String address = rs.getString("adresse");
                    int postalCode = rs.getInt("postnr");
                    int bookId = rs.getInt("bog_id");
                    String title = rs.getString("bog_titel");
                    int releaseYear = rs.getInt("udgivelsesaar");
                    int authorId = rs.getInt("forfatter_id");
                    String authorName = rs.getString("forfatter_navn");
                    borrowedBooks.add(new BorrowedBooksDTO(lenderId, name, address, postalCode, bookId, title, releaseYear, authorId, authorName));
                }
            } catch (SQLException e) {
                throw new SQLException("Couldn't receive books: " + borrowedBooks, e);

            }
        } catch (SQLException f) {
            throw new RuntimeException(f);
        }
        return borrowedBooks;
    }

    public Lender insertLender(Lender lender) {

        boolean result = false;
        int newId = 0;

        String sql = "insert into laaner (navn, adresse, postnr) values (?, ?, ?)";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, lender.getName());
                ps.setString(2, lender.getAddress());
                ps.setInt(3, lender.getPostalCode());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    lender.setLender_id(newId);
                } else {
                    lender = null;
                }

            } catch (SQLException e) {
                throw new SQLException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lender;
    }

    public boolean deleteBorrowedBook(int lenderId, int bookId) {
        boolean result = false;
        String sql = "delete from udlaan where laaner_id = ? and bog_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, lenderId);
                ps.setInt(2, bookId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                    System.out.println("Loan deleted for lender ID " + lenderId + " and book ID " + bookId);
                } else {
                System.out.println("No loan found for lender ID " + lenderId + " and book ID " + bookId);
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}

