package ejercicios;

import java.util.Scanner;
//Laboratorio 4
//Frank Alexis Villafuerte Ccapira
public class Menu {

	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] personas=new Persona[10];
		Paquete[] paquete= new Paquete[20];
		int contadorPersona=0;
		int contadorPaquete=0;
		int opcion=0;
		System.out.println("1.Registrar personas");
		
		registrarPersonas(personas, contadorPersona);
		System.out.println("2.Registrar paquetes");
		registrarPaquetes(paquete, personas, contadorPaquete);
		do {
			mostrarMenu();
			opcion=scan.nextInt();
			switch(opcion) {
				case 1: registrarFechaEntrega(paquete);
					break;
				case 2: mostrarPaquetesPorPeso(paquete);
					break;
				case 3: mostrarPaquetesPorCosto(paquete);
					break;
				case 4: mostrarPaquetesPendientes(paquete);
					break;
				case 5: mostrarDatosRemitente(paquete);
					break;
				case 6: mostrarDatosPaqueteConDni(paquete);
					break;
			}
		}
		while(opcion>1&&opcion<8);
		
		
		
	}
	private static void mostrarDatosPaqueteConDni(Paquete[] paquete) {
		// TODO Auto-generated method stub
		String dni;
		
		System.out.println("Ingresar DNI de usuario");
		dni=scan.next();
		
		for(int i=0;i<paquete.length;i++) {
			if(paquete[i].getPersona().getDni().equals(dni)) {
				paquete[i].imprimirDatos();
				System.out.print("\n" );
			}
		}
		System.out.print("Fin de resultados" );
	}
	private static void mostrarDatosRemitente(Paquete[] paquete) {
		
		int id;
		int contador=0;
		System.out.println("Ingresar identificador de paquete");
		id=scan.nextInt();
		while(contador<paquete.length) {
			
			if(id==paquete[contador].getIdentificador()) {
				paquete[contador].getPersona().imprimirDatos();
				break;
			}
			contador++;
		}
		if(contador==paquete.length) {
			System.out.println("No existe paquete con identificador ingresado");
		}
		
	}
	private static void mostrarPaquetesPendientes(Paquete[] paquete) {
		for(int i=0;i<paquete.length;i++) {
			if(paquete[i].getFechaEntrega().equals(null)) {
				paquete[i].imprimirDatos();
				System.out.print("\n");
			}
		}
		
	}
	private static void mostrarPaquetesPorCosto(Paquete[] paquete) {
		float costo;
		System.out.println("Ingresar costo para búsqueda de paquete");
		costo=scan.nextFloat();
		for(int i=0;i<paquete.length;i++) {
			if(paquete[i].getCosto()==costo) {
				paquete[i].imprimirDatos();
			}
		}
		System.out.println("Fin de resultados");
		
		
	}
	private static void mostrarPaquetesPorPeso(Paquete[] paquete) {
		int peso;
		System.out.println("Ingresar peso para mostrar paquetes mayores");
		peso=scan.nextInt();
		for(int i=0;i<paquete.length;i++) {
			if(paquete[i].getPesoKg()>peso) {
				paquete[i].imprimirDatos();
			}
		}
		System.out.println("Fin de resultados");
	}
	private static void registrarPaquetes(Paquete[] paquetes, Persona[] personas, int contadorPaquete) {
		
		int identificador;
		String fechaRecepcion;
		int pesoKg;
		String direccion;
		float costo;
		String dni;
	
		System.out.println("Hay "+(contadorPaquete+1)+" paquete(s) registradas actualmente");
		System.out.println("Ingresar identificador del paquete");
		identificador=scan.nextInt();
		System.out.println("Ingresar fecha de recepción del paquete ");
		fechaRecepcion=scan.next();
		System.out.println("Ingresar peso del paquete en kilogramos");
		pesoKg=scan.nextInt();
		System.out.println("Ingresar dirección de entrega del paquete");
		scan.nextLine();
		direccion=scan.nextLine();
		System.out.println("Ingresar costo para entrega del paquete");
		costo=scan.nextFloat();
		
		paquetes[contadorPaquete]=new Paquete();
		paquetes[contadorPaquete].setIdentificador(identificador);
		paquetes[contadorPaquete].setFechaRecepcion(fechaRecepcion);
		paquetes[contadorPaquete].setPesoKg(pesoKg);
		paquetes[contadorPaquete].setDireccion(direccion);
		paquetes[contadorPaquete].setCosto(costo);
		
		System.out.println("Ingresar número de DNI del remitente");
		dni=scan.next();
		int i=0;
		while(i<personas.length) {
			
			if(personas[i].getDni().equals(dni)) {
				paquetes[contadorPaquete].setPersona(personas[i]);
				break;
			}
			if(i==10) {
				System.out.println("No hay ningún usuario con el número de DNI ingresado");
			}
			i++;
		}
		contadorPaquete++;
		
		if(contadorPaquete<2) {
			registrarPaquetes(paquetes, personas, contadorPaquete);
		}
	}
	private static void registrarPersonas(Persona[] personas, int contadorPersona) {
		
		String nombre;
		String dni;
		String celular;
		System.out.println("Hay "+(contadorPersona)+" persona(s) registradas actualmente");
		System.out.println("Ingresar nombre de la persona");
		nombre=scan.nextLine();
		scan.nextLine();
		System.out.println("Ingresar dni de la persona");
		dni=scan.next();
		System.out.println("Ingresar número de celular de la persona");
		celular=scan.next();
		
		personas[contadorPersona]=new Persona();
		personas[contadorPersona].setNombre(nombre);
		personas[contadorPersona].setDni(dni);
		personas[contadorPersona].setCelular(celular);
		
		contadorPersona++;
		
		if(contadorPersona<2) {
			registrarPersonas(personas, contadorPersona);
		}	
	}
	
	private static void mostrarMenu() {
		System.out.println("\t MENU");
		System.out.println("Ingrese el numero con la opcion deseada");
		System.out.println("1.Registrar fecha de paquetes entregados");
		System.out.println("2.Buscar paquetes con pesos superiores al ingresado");
		System.out.println("3.Buscar paquetes por costos");
		System.out.println("4.Buscar paquetes sin enviar");
		System.out.println("5.Buscar personas mediante identificador de paquetes");
		System.out.println("6.Buscar paquetes por DNI de remitentes");
		System.out.println("Cualquier valor: Salir");
	}
	
	private static void registrarFechaEntrega(Paquete[] paquetes) {
		
		System.out.print("Ingrese identificador de paquete");
		int id=scan.nextInt();
		String fechaEntrega;
		int contador=0;
		while(contador<20) {
			if(paquetes[contador].getIdentificador()==id) {
				System.out.print("Ingresar fecha de Entrega");
				fechaEntrega=scan.next();
				paquetes[contador].setFechaEntrega(fechaEntrega);
				break;
			}
			contador++;
		}
		if(contador==20) {
			System.out.println("No existe paquete con identificador ingresado");
		}
	}
}
