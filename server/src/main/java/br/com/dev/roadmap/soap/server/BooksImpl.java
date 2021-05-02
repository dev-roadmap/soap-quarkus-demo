package br.com.dev.roadmap.soap.server;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.dev.roadmap.soap.server.Books")
public class BooksImpl implements Books {

	private Set<Book> database = Collections.synchronizedSet(new HashSet<Book>());

	@Override
	public Set<Book> all() {
		return database;
	}

	@Override
	public Set<Book> search(String name) {
		return database.stream().filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toSet());
	}

	@Override
	public Book add(Book newBook) {
		newBook.setId(database.stream().mapToLong(Book::getId).max().orElse(0L) + 1);
		database.add(newBook);
		return newBook;
	}

	@Override
	public Book remove(Book book) {
		database.remove(book);
		return book;
	}

}
