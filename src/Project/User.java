package Project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
	private int id;
	private String username;
	private List<Book> book= new ArrayList<Book>();


	public User(int id, String username) {
		super();
		this.id = id;
		this.username=username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	
	
	public void addBook(Book b) {  
		book.add(b);
	}

	public void removeBook(Book b) {  
		book.remove(b);
	}



@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", book=" + book + "]";
	}

@Override
public boolean equals(Object obj) {
	User other = (User) obj;
	if (id != other.id)
		return false;
	return true;
}

}
