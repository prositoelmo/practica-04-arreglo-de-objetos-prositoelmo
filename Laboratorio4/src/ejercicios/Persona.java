package ejercicios;
//Laboratorio Nro 4
//Autor: Frank Alexis Villafuerte Ccapira
//Difucultades o comentarios
public class Persona {

	private String nombre;
	private String dni;
	private String celular;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void imprimirDatos() {
		
		System.out.println("Nombre : "+this.nombre);
		System.out.println("DNI    : "+this.dni);
		System.out.println("Celular: "+this.celular);
	}
}
