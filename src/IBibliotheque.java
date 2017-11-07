import java.util.List;
import java.util.Optional;
import Exception.LibraryException;

public interface IBibliotheque {
	/**
	* Get a book from its id
	*
	* @param id the id of the wanter book
	* @return a book with the given id if there is one
	*/
	Optional<Book> getBook(String id);
	/**
	* Add a book with the given ISBN
	*
	* @param isbn the ISBN
	* @return the id of the added book if the isbn exists
	*/
	Optional<String> addBook(String isbn);
	/**
	* Borrow a book from the library
	*
	* @param id the id of the borrowed book
	* @param username the name of the user
	* @throws BookNotFoundException if no book in the library has the given id
	* @throws UnavailableBookException if all books in the library with the given id
	have been borrowed
	*/
	void borrowBook(String id, String username) throws LibraryException;
	/**
	* Return a book back to the library
	*
	* @param id the id of the book to borrow
	* @param username the name of the user
	* @throws BookNotFoundException if no book in the library has the given id
	* @throws AllBooksAlreadyReturnedException if all books with the given id are
	already returned
	*/
	void returnBook(String id, String username) throws LibraryException;
	/**
	* Get all books of the library
	*

	* @return the books
	*/
	List<Book> getBooks();
	/**
	* Return all books with an author, a title or an ISBN matching the search term
	*
	* @param searchTerm the searched term
	* @return the books matching the search term
	*/
	List<Book> searchBooks(String searchTerm);
}
