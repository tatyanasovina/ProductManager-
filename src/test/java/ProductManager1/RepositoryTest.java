package ProductManager1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Necromans", 437,"Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450,"Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500,"Leah Arden");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book2,book3};

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void emptyRepository() {
        Repository repo = new Repository();

        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void WhenWeDeleteOneBook() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Necromans", 437,"Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450,"Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500,"Leah Arden");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book3};

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void WhenWeDeleteSeveralBook() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Necromans", 437,"Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450,"Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500,"Leah Arden");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);
        repo.removeById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected,actual);
    }

}