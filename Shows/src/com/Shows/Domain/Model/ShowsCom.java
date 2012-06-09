package com.Shows.Domain.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShowsCom {
	@Id
	private int id;
	private int codiBanc;
	private String numeroCompte;
	private Float comissio;
	private Moneda divisa;
	private Set<Moneda> canvis;
	
}
