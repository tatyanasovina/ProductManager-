package ProductManager1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500, "Leah Arden");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddEmpty() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);


        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenTheWordIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500, "Leah Arden");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Mara");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenMultipleValuesAreFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500, "Leah Arden");
        Book book4 = new Book(4, "Mara and Moroc 2", 500, "Leah Arden");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Mara");
        Product[] expected = {book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenNoValueIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500, "Leah Arden");
        Book book4 = new Book(4, "Mara and Moroc 2", 500, "Leah Arden");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("One");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenTheRequestIsEmpty() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Book book3 = new Book(3, "Mara and Moroc", 500, "Leah Arden");
        Book book4 = new Book(4, "Mara and Moroc 2", 500, "Leah Arden");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("");
        Product[] expected = {book1, book2, book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenThePhoneNameIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Smartphone smartphone1 = new Smartphone(3, "Iphone8", 56_000, "APPLE");
        Book book3 = new Book(4, "Mara and Moroc", 500, "Leah Arden");
        Book book4 = new Book(5, "Mara and Moroc 2", 500, "Leah Arden");
        Smartphone smartphone2 = new Smartphone(6, "A4", 18_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Iphone8");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenThePhoneNameIsFound1() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Necromans", 437, "Evgenia Safonova");
        Book book2 = new Book(2, "Sholoh", 450, "Antonina Crane");
        Smartphone smartphone1 = new Smartphone(3, "Iphone 8", 56_000, "APPLE");
        Book book3 = new Book(4, "Mara and Moroc", 500, "Leah Arden");
        Book book4 = new Book(5, "Mara and Moroc 2", 500, "Leah Arden");
        Smartphone smartphone2 = new Smartphone(6, "A4", 18_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(7, "Iphone 14", 98_000, "APPLE");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }


}