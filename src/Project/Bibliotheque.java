package Project;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import Exception.LibraryException;

public class Bibliotheque implements IBibliotheque{
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
		int i=0;
		Iterator it=book.iterator();
		while(it.hasNext()){
			if(book.get(i).getId()==Integer.parseInt(id)){
				return  Optional.of(book.get(i));
			}
			i++;
			it.next();
		}
		return null;
	}

	public Optional<String> addBook(String isbn) {
		int i=0;
		Iterator<Book> it=book.iterator();
		while(it.hasNext()){
			if(book.get(i).getIsbn()==isbn){
				book.get(i).setNbExemplaire(book.get(i).getNbExemplaire()+1);
			}
			it.next();
			i++;
		}
		return null;
	}

	public void borrowBook(String id, String username) throws LibraryException {
		int i=0;
		Iterator<Book> it=book.iterator();
		int j=0;
		Iterator<User> it2=user.iterator();
		while(it.hasNext()){
			if(book.get(i).getId()==Integer.parseInt(id)){
				while(it2.hasNext()){
					if(user.get(j).getUsername()==username && !user.get(j).getBook().contains(book.get(i))){
						if(book.get(i).getNbExemplaire()<=0){
							throw new LibraryException("Le livre "+book.get(j).getTitre()+" n'est plus disponible");
						}
						user.get(j).addBook(book.get(i));
						book.get(i).setNbExemplaire(book.get(i).getNbExemplaire()-1);
					}
					j++;
					it2.next();
				}
			}
			i++;
			it.next();
		}
		if(j==0){
			throw new LibraryException("le livre que vous chercher n'est pas dans notre bibliothèque");
		}
	}

	public void returnBook(String id, String username) throws LibraryException {
		int i=0;
		Iterator<Book> it=book.iterator();
		int j=0;
		Iterator<User> it2=user.iterator();
		while(it.hasNext()){
			if(book.get(i).getId()==Integer.parseInt(id)){
				while(it2.hasNext()){
					if(user.get(j).getUsername()==username && user.get(j).getBook().contains(book.get(i))){
						user.get(j).removeBook(book.get(i));
						book.get(i).setNbExemplaire(book.get(i).getNbExemplaire()+1);
					}
					j++;
					it2.next();
				}
			}
			i++;
			it.next();
		}
		if(j==0){
			throw new LibraryException("le livre que vous voulez nous retourner n'est pas référencé dans notre bibliothèque");
		}
	}

	public List<Book> getBooks() {
		return book;
	}

	public List<Book> searchBooks(String searchTerm) {
		List <Book> res= new ArrayList<Book>();
		int i=0;
		Iterator<Book> it=book.iterator();
		while(it.hasNext()){
			if(book.get(i).getAuteur().matches(searchTerm) || book.get(i).getTitre().matches(searchTerm) || book.get(i).getIsbn().matches(searchTerm)){
				res.add((book).get(i));
			}
			i++;
			it.next();
		}
		return res;
	}

}
