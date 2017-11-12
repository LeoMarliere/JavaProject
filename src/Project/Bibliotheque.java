package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import Exception.LibraryException;

public class Bibliotheque implements IBibliotheque {
	private List<User> user;
	private List<Book> book;

	public Bibliotheque(List<User> user, List<Book> book) {
		super();
		this.user = user;
		this.book = book;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Optional<Book> getBook(String id) {
		int i = 0;
		final Iterator it = book.iterator();
		Boolean flag=false;
		while (it.hasNext()) {
			if (book.get(i).getId() == Integer.parseInt(id)) {
				flag=true;
				return Optional.of(book.get(i));
			}
			i++;
			it.next();
		}
		System.out.println("Le livre ID = "+id+" n'existe pas");
		return null;
	}

	public Optional<String> addBook(String isbn) {
		int i = 0;
		final Iterator<Book> it = book.iterator();
		Boolean flag=false;
		while (it.hasNext()) {
			if (book.get(i).getIsbn().equals(isbn)) {
				book.get(i).setNbExemplaire(book.get(i).getNbExemplaire() + 1);
				flag=true;
				System.out.println("On ajoute un exemplaire du livre "+ book.get(i).getTitre());
			}
			it.next();
			i++;
		}
		if(!flag){
			System.out.println("Le livre ISBN="+isbn+" n'existe pas");
		}
		return null;
	}

	public void borrowBook(String id, String username) throws LibraryException {
		int i = 0;
		final Iterator<Book> it = book.iterator();
		int j = 0;
		final Iterator<User> it2 = user.iterator();
		while (it.hasNext()) {
			if (book.get(i).getId() == Integer.parseInt(id)) {
				while (it2.hasNext()) {
					if (user.get(j).getUsername() == username) {
						if(!user.get(j).getBook().contains(book.get(i))){
						if (book.get(i).getNbExemplaire() <= 0) {
							throw new LibraryException("Le livre " + book.get(i).getTitre() + " n'est plus disponible");
						}
						user.get(j).addBook(book.get(i));
						book.get(i).setNbExemplaire(book.get(i).getNbExemplaire() - 1);
						System.out.println(username + " emprunte le livre : "+ book.get(i).getTitre());
						}else{
							throw new LibraryException(username+" a deja le livre "+book.get(i).getTitre());
						}
					}
					j++;
					it2.next();
				}
			}
			i++;
			it.next();
		}
		if (j == 0) {
			throw new LibraryException("le livre que vous chercher n'est pas dans notre bibliothèque");
		}
	}

	public void returnBook(String id, String username) throws LibraryException {
		int i = 0;
		final Iterator<Book> it = book.iterator();
		int j = 0;
		final Iterator<User> it2 = user.iterator();
		while (it.hasNext()) {
			if (book.get(i).getId() == Integer.parseInt(id)) {
				while (it2.hasNext()) {
					if (user.get(j).getUsername() == username ) {
						if(user.get(j).getBook().contains(book.get(i))){
						user.get(j).removeBook(book.get(i));
						book.get(i).setNbExemplaire(book.get(i).getNbExemplaire() + 1);
						System.out.println(username+" rend le livre : "+book.get(i).getTitre());
						}else {
							throw new LibraryException(username+" a deja rendu le livre : "+book.get(i).getTitre());
						}
					}
					j++;
					it2.next();
				}
			}
			i++;
			it.next();
		}
		if (j == 0) {
			throw new LibraryException(
					"le livre id = "+id+" que vous voulez nous retourner n'est pas référencé dans notre bibliothèque");
		}
	}

	public List<Book> getBooks() {
		return book;
	}

	public List<Book> searchBooks(String searchTerm) {
		final List<Book> res = new ArrayList<Book>();
		int i = 0;
		boolean flag = false;
		final Iterator<Book> it = book.iterator();
		while (it.hasNext()) {
			if (book.get(i).getAuteur().matches(searchTerm) || book.get(i).getTitre().matches(searchTerm)
					|| book.get(i).getIsbn().matches(searchTerm)) {
				res.add((book).get(i));
				flag=true;
			}
			i++;
			it.next();
		}
		if(!flag){
			System.out.println("Recherche introuvable");
		}
		return res;
	}

}
