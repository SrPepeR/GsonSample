package gSonPersona;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Persona {
	
	String nombre;
	String apellidos;
	int edad;
	
	Persona( String nombre, String apellidos, int edad ){
		
		if( nombre != "" && apellidos != "" && edad > 0 ) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
		}else {
			System.out.println("Los datos introducidos no son correctos...");
			System.out.println();
			recogerDatos();
		}
		
	}
	
	public static void recogerDatos() {
		
		Scanner scanner = new Scanner(System.in);
		
		int edad = -1;
		
		System.out.println("Introduzca su nombre:");
		String nombre = scanner.nextLine();
		System.out.println("Introduzca sus apellidos:");
		String apellidos = scanner.nextLine();
		
		System.out.println("Introduzca su edad:");
		String edadStr = scanner.nextLine();
		
		try {
			edad = Integer.parseInt(edadStr);
		}catch( NumberFormatException e ) {
		}
		
		scanner.close();
		
		Persona p = new Persona( nombre, apellidos, edad );
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);
		System.out.println(json);
		
	}
	
}
