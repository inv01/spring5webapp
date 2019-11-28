package guru.springframework.spring5webapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	private String title;
	private String isbn;
	private String publisher;
	
	@ManyToMany
	private Set<Author> authors = new HashSet<>();

	public Book() {
	}

	public Book(String title, String isbn, String publisher, Set<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}

	public Book(String title, String isbn, String publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	
}
