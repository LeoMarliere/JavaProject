import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import Exception.AllBooksAlreadyReturnedException;
import Exception.BookNotFoundException;
import Exception.UnavailableBookException;

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


	@Override
	public Optional<Book> getBook(String id) {
		// TODO Auto-generated method stub
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

	@Override
	public Optional<String> addBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrowBook(String id, String username) throws BookNotFoundException, UnavailableBookException {
		// TODO Auto-generated method stub
		int i=0;
		Iterator<Book> it=book.iterator();
		int j=0;
		Iterator<User> it2=user.iterator();
		while(it.hasNext()){
			if(book.get(i).getId()==Integer.parseInt(id)){
				while(it2.hasNext()){
					if(user.get(j).getUsername()==username){
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
	}

	@Override
	public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
		// TODO Auto-generated method stub
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
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub		
		return book;
	}

	@Override
	public List<Book> searchBooks(String searchTerm) {
		// TODO Auto-generated method stub
		List <Book> res= new ArrayList<>();
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