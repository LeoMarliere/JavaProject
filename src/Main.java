

import java.util.ArrayList;
import java.util.List;

import Exception.AllBooksAlreadyReturnedException;
import Exception.BookNotFoundException;
import Exception.UnavailableBookException;

public class Main {
	

	private static IBibliotheque bibi;

	public static void main(String[] args) throws BookNotFoundException, UnavailableBookException, AllBooksAlreadyReturnedException {
		// TODO Auto-generated method stub
		
		Book book1 = new Book(1, "AAA", "Auteur1", "Titre1", 2);
		Book book2 = new Book(2, "AAB", "Auteur2", "Titre2", 2);
		Book book3 = new Book(3, "AAC", "Auteur3", "Titre3", 2);
		
		List <Book>listBook=new ArrayList<Book>();
		listBook.add(book1);
		listBook.add(book2);
		listBook.add(book3);
		
		
		User user1= new User(1, "Capon");
		User user2= new User(2, "Charclo");
		User user3= new User(3, "Titou");

		List <User>listUser= new ArrayList<User>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		
		
		bibi = new Bibliotheque(listUser, listBook);
		
		System.out.println("Livre id=1 :"+bibi.getBook("1"));
		System.out.println("Tous les livres :"+bibi.getBooks());
		
		System.out.println("\n --------------------------------");
		
		System.out.println("Il reste 1 :"+ book1.getNbExemplaire());
		bibi.borrowBook("2", "Capon");
		bibi.borrowBook("1", "Capon");
		System.out.println("Emprunt du livre "+book2.getTitre()+"  par "+user1.getUsername());
		System.out.println("Actuellement : user1 a" +user1.getBook());
		System.out.println("Actuellement : user2 a" +user2.getBook());
		System.out.println("Actuellement : user3 a" +user3.getBook());
		
		System.out.println("Il reste 1 :"+ book1.getNbExemplaire());
		
		System.out.println("\n --------------------------------");
		bibi.returnBook("2", "Capon");
		bibi.returnBook("3", "Capon");
		System.out.println("Actuellement : user1 a" +user1.getBook());
		System.out.println("Actuellement : user2 a" +user2.getBook());
		System.out.println("Actuellement : user3 a" +user3.getBook());
		
		System.out.println("\n --------------------------------");
		System.out.println(bibi.searchBooks("Titre3"));
		System.out.println(bibi.searchBooks("Auteur1"));

	}

}
