package Sonvico;

public class Alumno {
	// Atributos
	String nombre;
	String apellido;
	int edad;
	double[] notas;
	boolean ultimo;

	// Constructor
	public Alumno(String nombre, String apellido, int edad, double[] notas, boolean ultimo) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.notas = notas;
		this.ultimo = ultimo;

	}
	//Constructor para los alumnos vacios
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public boolean isUltimo() {
		return ultimo;
	}

	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
	}
	
	//En este metodo calcularemos la nota media
	public double getNotaMedia() {
		double notaM;
		notaM = 0;

		// Sumaremos todos los valores de las notas a la variable notaM
		for (int i = 0; i < notas.length; i++) {
			notaM = notaM + notas[i];
		}
		// Aqui le devolvemos la media, que es todas las notas sumadas entre la cantidad
		// de notas
		return notaM / notas.length;
	}
	
	//En este metodo mostraremos todas las notas
	public void showNotas(double []notas) {

		for (int i = 0; i < notas.length; i++) {
			System.out.print(notas[i]+",");
		}
	}
	
	//En este metodo me sirve para usarlo despues en el toString para imprimir las notas
	//Lo que hace es imprimir cada nota ordenadamente
	public String stringNotas() {
		
		String strNotas = "";
		for (int i = 0; i < this.notas.length; i++) {
			strNotas += this.notas[i] + "\n";
		}
		return strNotas;
		
	}
	
	//Este es el toString que nos dara todo la info del alumno
	public String toString(){
		
		
		
		return "Alumno -->" +nombre +" "+apellido+", Edad: "+ edad+"\n"+"Notas: "+"\n"+ stringNotas()+"Nota Media "+getNotaMedia();
	}
	
	//Este metodo nos servira para cambiar las notas cuando sea necesario
	public void setNota(double nota, int modulo) {
		
		notas[modulo] = nota;
	}
}
