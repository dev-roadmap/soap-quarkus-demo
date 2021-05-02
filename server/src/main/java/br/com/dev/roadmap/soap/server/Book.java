package br.com.dev.roadmap.soap.server;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Book")
@XmlRootElement
public class Book {
	private Long id;
	private String isbn;
	private List<String> authors;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getName() {
		return name;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authors, id, isbn, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(id, other.id) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, isbn=%s, authors=%s, name=%s]", id, isbn, authors, name);
	}

}