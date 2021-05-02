package br.com.dev.roadmap.soap.server;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Books {

	@WebMethod
	Set<Book> all();
	
	@WebMethod
	Set<Book> search(String name);
	
	@WebMethod
	Book add(Book newBook);
	
	@WebMethod
	Book remove(Book book);
}
