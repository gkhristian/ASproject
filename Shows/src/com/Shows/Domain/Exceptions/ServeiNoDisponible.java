package com.Shows.Domain.Exceptions;

public class ServeiNoDisponible extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServeiNoDisponible() {
		super();
	}
	
	public ServeiNoDisponible(String message) {
		super(message);
	}

}
