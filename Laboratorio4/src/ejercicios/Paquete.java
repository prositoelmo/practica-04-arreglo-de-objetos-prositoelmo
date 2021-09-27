package ejercicios;

//Laboratorio 4
//Frank Alexis Villafuerte Ccapira
public class Paquete {

	private int identificador;
	private String fechaRecepcion;
	private String fechaEntrega;
	private int pesoKg;
	private String direccion;
	private float costo;
	private Persona persona;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(int pesoKg) {
		this.pesoKg = pesoKg;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public void setPersona(Persona persona) {
		this.persona= persona;
	}
	public Persona getPersona() {
		return persona;
	}
	
public void imprimirDatos() {
		
		System.out.println("ID   			  : "+this.identificador);
		System.out.println("Fecha de Recepcion: "+this.fechaRecepcion);
		System.out.println("Fecha de Entrega  : "+this.fechaEntrega);
		System.out.println("Peso en Kg		  : "+this.pesoKg);
		System.out.println("Direccion         : "+this.direccion);
		System.out.println("Costo			  : "+this.costo);
		System.out.println("Remitente		  : "+this.persona.getNombre());
	}
}
