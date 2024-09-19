import dto.BookDTO;
import dto.BorrowedBooksDTO;
import dto.LenderDTO;
import entities.Book;
import entities.Lender;
import persistence.BibliotekMapper;
import persistence.Database;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";
    private final static String URL = "jdbc:postgresql://localhost:5432/bibliotekssystem";

    public static void main(String[] args) {

        Database database = new Database(USER, PASSWORD, URL);
        BibliotekMapper bibliotekMapper = new BibliotekMapper(database);
        // insertLender(bibliotekMapper);
        // deleteBorrowedBooks(1,1, bibliotekMapper);

        List<LenderDTO> lender = bibliotekMapper.findAllLenders();
        List<BookDTO> book = bibliotekMapper.findAllBooksAndAuthors();
        List<BorrowedBooksDTO> borrowedBooks = bibliotekMapper.findAllBorrowedBooks();

        showLenderById(bibliotekMapper, 2);
        showLendersWithCity(lender);
        showBooksWithAuthorName(book);
        showBorrowedBooks(borrowedBooks);

    }

    private static void showLenderById(BibliotekMapper bibliotekMapper, int lenderID) {
        System.out.println("\n***** Låner ID. " + lenderID + " *******");
        System.out.println(bibliotekMapper.getLenderById(lenderID).toString());
    }

    private static void showLendersWithCity(List<LenderDTO> lenderList) {
        System.out.println("\n***** Liste af låner *****");
        for (LenderDTO lender : lenderList) {
            System.out.println(lender.toString());
        }
    }

    private static void showBooksWithAuthorName(List<BookDTO> bookList) {
        System.out.println("\n***** Liste af bøger *****");
        for (BookDTO books : bookList) {
            System.out.println(books.toString());
        }
    }

    private static void showBorrowedBooks(List<BorrowedBooksDTO> borrowedList) {
        System.out.println("\n***** Lånte bøger *****");
        for (BorrowedBooksDTO borrowList : borrowedList) {
            System.out.println(borrowList.toString());
        }
    }

    private static int insertLender(BibliotekMapper bibliotekMapper) {
        Lender lenderOne = new Lender("Asim", "Allerød", 7500);
        Lender lenderTwo = bibliotekMapper.insertLender(lenderOne);
        showLenderById(bibliotekMapper, lenderTwo.getLender_id());
        return lenderTwo.getLender_id();

    }

    private static void deleteBorrowedBooks(int lender_id, int book_id, BibliotekMapper bibliotekMapper) {

        if (bibliotekMapper.deleteBorrowedBook(lender_id, book_id)) {
            System.out.println("Loan for lender ID: " + lender_id + " borrowed book ID: " + book_id + "deleted from the database");
        } else {
            System.out.println("No loan found for lender ID: " + lender_id + " borrowed book ID: " + book_id);
        }
    }
}