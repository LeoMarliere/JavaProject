package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.*;

import Exception.LibraryException;
import Project.Bibliotheque;
import Project.Book;
import Project.User;

public class BibliothequeTest {

	List<Book> listofbooks = new ArrayList();
	List<User> listofUsers = new ArrayList();

	@Test
	public void testGetBook() {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final Optional result = Optional.of(bibliothequetotest.getBook("4"));
		// then ?
		assertEquals(Optional.of(booktotest),bibliothequetotest.getBook("4"));
		assertNotEquals(Optional.of(booktotest),bibliothequetotest.getBook("3"));
		assertNull(bibliothequetotest.getBook("2"));
	}

	@Test
	public void testgsearchBooksByAuteur() {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book( "456DEF", "Voltaire", "Candide", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		final List<Book> result = bibliothequetotest.searchBooks("Voltaire");
		// then ?
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testgsearchBooksByIsbn() {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book( "456DEF", "Voltaire", "Zadig", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
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
	public void testgsearchBooksByTitre() {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final Book booktotest2 = new Book( "456DEF", "Voltaire", "Zadig", 1);
		listofbooks.add(booktotest);
		listofbooks.add(booktotest2);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
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
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(0, "Croquet");
		listofUsers.add(usertotest);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		bibliothequetotest.borrowBook("4", "Croquet");
		// then ?
		final List<Book> bibliothequelistofbooks = bibliothequetotest.getBooks();
		final List<User> bibliothequelistofuser = bibliothequetotest.getUser();
		final Book thebookbeanborrow = bibliothequelistofbooks.get(0);
		final User theuserwhoborrowbook = bibliothequelistofuser.get(0);
		final int numberofbookborrowbyuser = theuserwhoborrowbook.getBook().size();
		final int numberofbookinbibliotheque = thebookbeanborrow.getNbExemplaire();
		assertEquals(0, numberofbookinbibliotheque);
		assertEquals(1, numberofbookborrowbyuser);
	}

	@Test
	public void testReturnBook() throws LibraryException {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(1, "Croquet");
		final User usertotest2 = new User(1, "Franck");
		listofbooks.add(booktotest);
	
		listofUsers.add(usertotest);
		listofUsers.add(usertotest2);

		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
		bibliothequetotest.borrowBook("4","Croquet");
		
		assertEquals(0, bibliothequetotest.getBook().get(0).getNbExemplaire());
		assertEquals(booktotest, bibliothequetotest.getUser().get(0).getBook().get(0));
		
		bibliothequetotest.returnBook("4","Croquet");
		// then ?
		assertEquals(1, bibliothequetotest.getBook().get(0).getNbExemplaire());
	}

	@Test
	public void testAddBook() throws LibraryException {
		// what ?
		final Book booktotest = new Book( "123ABC", "Voltaire", "Candide", 1);
		final User usertotest = new User(0, "Croquet");
		listofUsers.add(usertotest);
		listofbooks.add(booktotest);
		final Bibliotheque bibliothequetotest = new Bibliotheque(listofUsers, listofbooks);
		// when ?
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
