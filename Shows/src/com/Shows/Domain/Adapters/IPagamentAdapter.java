package com.Shows.Domain.Adapters;


public interface IPagamentAdapter {
    
    public boolean autoritza(String dni, int codiB, String numCompte, float importe, int codiBancShows, String numcompteShows);
}
