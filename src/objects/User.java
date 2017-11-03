package objects;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String username;
	private List<Book> bookTake;

	public User(String username) {
		this.username = username;
		this.bookTake = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Book> getBookTake() {
		return bookTake;
	}

	public void setBookTake(List<Book> bookTake) {
		this.bookTake = bookTake;
	}

	/**
	 * Cette méthode sert à ajouter un livre à la liste des livres empruntés
	 * Appellé lorsque un user emprunte un livre
	 * 
	 * @param bookId
	 */
	public void addBookInList(Book theBook) {
		this.bookTake.add(theBook);
	}

	/**
	 * Cette méthode supprime un livre de la liste des livres empruntés Appelé
	 * lorsque un user rend un livre
	 * 
	 * @param bookId
	 */
	public void deleteBookInList(String bookId) {
		for (final Book thebooktodelete : bookTake) {
			if (thebooktodelete.getId() == bookId) {
				bookTake.remove(thebooktodelete);
			}
		}
	}
}
