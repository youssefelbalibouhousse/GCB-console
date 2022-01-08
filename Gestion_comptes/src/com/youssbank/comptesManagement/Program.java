package com.youssbank.comptesManagement;

import java.util.Date;

public class Program {
	public static void AfficherDetailCompte (Compte compte) {
		
	}

	public static void main(String[] args) {
		/*Scenario*/
		
		Client client = new Client(11, "Youssef", "Bunshischi");
		Compte compte = new Compte(11, "11111", client);
		client.setCompte(compte);//Association du compte au client creer precedement (d'ou l'absence de parametre compte dans client)
		
		Operation op1 = new Operation(new Date(2021,3,5), "VERSE  ", 4000, compte); // on realise une operation
		compte.addOperation(op1); // On ajoute une operation a la collection 
		
		Operation op2 = new Operation(new Date(2021,3,7), "RETRAIT", 3000, compte); // on realise une operation
		compte.addOperation(op2); // On ajoute une operation a la collection 
		
		//AfficherDetailCompte(compte);
		
		System.out.println("Client:"+client.getNom()+" "+client.getPrenom());
		System.out.println("Compte:"+compte.getNumero());
		
		System.out.println("Date\t\t\t\t Type\t Montant");
		
		for(Operation op: compte.getOperations()) {
			System.out.println(op.getDate()+ "\t "+ op.getType()+" "+op.getMontant());
		}
		
		System.out.println("Solde: "+compte.getSolde());
		

	}

}
