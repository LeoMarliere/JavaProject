package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

import Exception.LibraryException;
import Project.Bibliotheque;
import Project.Book;
import Project.User;

public class BibliothequeTest {
	static List<Book> listofbooks;
	static List<User> listofUsers;
	static User usertotest;
	static Book booktotest;
	static Book booktotest2;
	static Bibliotheque bibliothequetotest;

	@BeforeClass
	public static void initialize() {
		listofbooks = new ArrayList();
		listofUsers = new ArrayList();
		usertotest = new User(1, "Croquet");
		booktotest = new Book("123ABC", "Voltaire", "Candide", 1);
		booktotest2 = new Book("456DEF", "Voltaire", "Zadig", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		listofUsers.add(usertotest);
		bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
	}

	@Test
	public void testGetBook() {
		assertEquals(Optional.of(booktotest), bibliothequetotest.getBook("1"));
		assertNotEquals(Optional.of(booktotest), bibliothequetotest.getBook("3"));
		assertNull(bibliothequetotest.getBook("4"));
	}

	@Test
	public void testsearchBooksByAuteur() {

		// when ?
		final List<Book> result = bibliothequetotest.searchBooks("Voltaire");
		// then ?
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testsearchBooksByIsbn() {

		// when ?
		final List<Book> result1 = bibliothequetotest.searchBooks("123ABC");
		final List<Book> result2 = bibliothequetotest.searchBooks("456DEF");
		// then ?
		assertNotNull(result1);
		assertNotNull(result2);
		assertEquals(1, result1.size());
		assertEquals(1, result2.size());
	}

	@Test
	public void testsearchBooksByTitre() {
		// when ?
		final List<Book> result1 = bibliothequetotest.searchBooks("Candide");
		final List<Book> result2 = bibliothequetotest.searchBooks("Zadig");
		// then ?
		assertNotNull(result1);
		assertNotNull(result2);
		assertEquals(1, result1.size());
		assertEquals(1, result2.size());
	}

	@Test
	public void testBorrowBook() throws LibraryException {
		// when ?
		bibliothequetotest.borrowBook("1", "Croquet");
		// then ?
		final List<Book> bibliothequelistofbooks = bibliothequetotest.getBooks();
		final List<User> bibliothequelistofuser = bibliothequetotest.getUser();
		final Book thebookbeanborrow = bibliothequelistofbooks.get(0);
		final User theuserwhoborrowbook = bibliothequelistofuser.get(0);
		final int numberofbookborrowbyuser = theuserwhoborrowbook.getBook().size();
		final int numberofbookinbibliotheque = thebookbeanborrow.getNbExemplaire();
		assertEquals(1, numberofbookinbibliotheque);
		assertEquals(1, numberofbookborrowbyuser);
	}

	@Test
	public void testReturnBook() throws LibraryException {
		bibliothequetotest.borrowBook("1", "Croquet");
		assertEquals(1, bibliothequetotest.getBook().get(0).getNbExemplaire());
		assertEquals(booktotest, bibliothequetotest.getUser().get(0).getBook().get(0));
		bibliothequetotest.returnBook("1", "Croquet");
		// then ?
		assertEquals(2, bibliothequetotest.getBook().get(0).getNbExemplaire());
	}

	@Test
	public void testAddBook() throws LibraryException {
		bibliothequetotest.addBook("123ABC");
		bibliothequetotest.addBook("ABCDEF");
		// then ?
		final List<Book> bibliothequelistofbooks = bibliothequetotest.getBooks();
		final Book thebookadded = bibliothequelistofbooks.get(0);
		final int numberofbookinbibliotheque = thebookadded.getNbExemplaire();
		assertEquals(2, numberofbookinbibliotheque);
		assertNotEquals(3, numberofbookinbibliotheque);
	}

}
