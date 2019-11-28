package guru.springframework.spring5webapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	

	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors")	
	private Set<Book> books = new HashSet<>();
	
	

	public Author() {	
	}
	
	public Author(String firstName, String lastName, Set<Book> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else 
			if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}
	
	
	
}
