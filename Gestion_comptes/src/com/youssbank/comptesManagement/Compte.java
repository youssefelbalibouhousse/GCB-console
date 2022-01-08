package com.youssbank.comptesManagement;

import java.util.ArrayList;
import java.util.List;

public class Compte {
	private int id;
	private String numero;
	private double solde;
	// Navigation pour 1 seul reference pour faire le lien entre les classe
	private Client client; 
	
	// Ici un compte peut avoir plusieurs (reference) operation on utilisera donc une collection
	// revoir les interfaces
	private List<Operation> operations = new ArrayList<Operation>();
	
	//Les constructeurs//
	
	//sans parametre
	public Compte() {
		solde = 0;
		
	}
	//avec parametre
	
	public Compte(int id, String numero, Client client) {
		//super(); pas necessaire car aucun heritage
		this.id = id;
		this.numero = numero;
		this.solde = 0;
		this.client = client; //on peut passer par les getters et setters 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}
	
	//Methode qui va ajouter une operation a notre collection declarer plus haut
	//Elle ne concerne que le compte qui contitent la collection d'operations du meme compte
	public void addOperation(Operation operation) {
		operations.add(operation);
		if(operation.getType().equals("VERSE  ")) 
			solde=solde+operation.getMontant();
		
		if(operation.getType().equals("RETRAIT")) 
			solde=solde-operation.getMontant();
	}
	
	
	

}
