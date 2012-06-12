package com.Shows.Domain.Exceptions;

public class PagamentNoAutoritzat extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PagamentNoAutoritzat() {
		super();
	}
	
	public PagamentNoAutoritzat(String message) {
		super(message);
	}

}
