package objects;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String username;
	private List<String> bookTake;

	public User(String username){
		this.username = username;
		this.bookTake = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getBookTake() {
		return bookTake;
	}
	public void setBookTake(List<String> bookTake) {
		this.bookTake = bookTake;
	}
	
	/**
	 * Cette méthode sert à ajouter un livre à la liste des livres empruntés
	 * Appellé lorsque un user emprunte un livre
	 * @param bookId
	 */
	public void addBookInList(String bookId){
		this.bookTake.add(bookId);
	}
	
	/**
	 * Cette méthode supprime un livre de la liste des livres empruntés
	 * Appelé lorsque un user rend un livre
	 * @param bookId
	 */
	public void deleteBookInList(String bookId){
		for (String id : bookTake){
			if (id == bookId){
				bookTake.remove(id);
			}
		}
	}
	
	
}
