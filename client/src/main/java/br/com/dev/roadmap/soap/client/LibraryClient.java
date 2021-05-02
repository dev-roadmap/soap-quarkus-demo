package br.com.dev.roadmap.soap.client;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.dev.roadmap.soap.server.Book;
import br.com.dev.roadmap.soap.server.Books;
import br.com.dev.roadmap.soap.server.BooksService;

public class LibraryClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/library/books?wsdl");
		BooksService service = new BooksService(url);
		Book book = new Book();
		book.setIsbn("978-6580210015");
		book.setName("Memórias Póstumas De Brás Cubas");
		book.getAuthors().add("Machado de Assis");
		Books books = service.getBooksPort();
		System.out.println(books.all());
		books.add(book);
		System.out.println(books.all());

	}
}
