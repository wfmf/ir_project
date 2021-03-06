package project2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import project2.Util;
import project2.model.Attributes;
import project2.model.Page;
import project2.model.Posting;

public class Main {

	public static void main(String[] args){
		
		
		Util util = new Util();
		String pathSerial = "serial.txt";
		
		//*
		String path = "xml_nome_id/";
		List<Page> pages = util.ler(path);
		
		
		boolean grap = false;
		boolean discreto = false;
		
		
		Postings postings = discreto ? util.processarPagesAtributos(pages, grap) : util.processarPages(pages, grap);
		Consulta consulta = new Consulta(postings);
		String query = "";
		
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Escreva uma consulta ou digite (SAIR)");
			query = scanner.nextLine();
			
			List<Posting> list = discreto ? consulta.searchQuartis(query, false) : consulta.search(query, false);
			for(Posting po : list){
				System.out.println(po.toString());
			}
			System.out.println("______________________");
		}while(!query.equals("SAIR"));
		scanner.close();

		
		/*
		try {
			atributos.setMap(null);
			util.serialization(pathSerial, atributos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**/
				
		/*
		Postings postings = null;
		try {
			postings = (Postings) util.deSerialization(pathSerial);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		/**/
		
		//3.034.176 bytes (3,2 MB no disco) grap false
		//3.034.176 bytes (3,2 MB no disco) grap true
		
		// 506.740 bytes (508 KB no disco) grap false
		// 484.974 bytes (487 KB no disco) grap true
	}
	
}
