package Sonvico;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean on = true;
		// ArrayList que me guardará todos los alumnos
		ArrayList<Alumno> alums = new ArrayList<Alumno>();

		// Este sera el while que me dejará volver al inicio cada vez que acabe una
		// opcion
		while (on) {
			// Print del menu
			menuAlum();
			int inputMenu = sc.nextInt();

			// Switch donde se encuentran todas las opciones posibles
			switch (inputMenu) {
			case 1:
				System.out.println(
						"Desea crear un Alumno con todos los datos? (1 - Alumno Completo // 2 - Alumno sin Datos");
				int inputDatos = sc.nextInt();
				// Creamos otro switch para poder elegir si se crea completo o sin datos.
				switch (inputDatos) {
				case 1:
					addAlum(alums);

					break;

				case 2:

					alums.add(new Alumno());

					break;

				default:
					break;
				}

				break;
			case 2:

				verAlum(alums);

				break;
			case 3:

				modNota(alums);

				break;

			case 4:

				datosPersonales(alums);

				break;
			case 5:
				// Switch para Salir del menu
				on = false;

				break;

			default:
				break;
			}
		}

	}

	// Metodo para imprimir el menu
	public static void menuAlum() {
		System.out.println();
		System.out.println("-------------------");
		System.out.println("1 -Crear Alumno");
		System.out.println("2 -Mostrar Alumno");
		System.out.println("3 -Modificar Nota");
		System.out.println("4 -Modificar Datos Personales");
		System.out.println("5 -Salir");
		System.out.println("-------------------");
		System.out.println();
		System.out.println("Indique que desea hacer:");

	}

	// Metodo para añadir un alumno nuevo
	public static void addAlum(ArrayList<Alumno> alums) {
		Scanner sc = new Scanner(System.in);
		String nombre, apellido;
		int edad;
		double[] notas = new double[4];
		boolean ultimo;

		System.out.println("Introduzca el nombre del alumno a añadir");
		nombre = sc.next();

		System.out.println("Introduzca el apellido del alumno a añadir");
		apellido = sc.next();

		System.out.println("Introduzca la edad del alumno añadido");
		edad = sc.nextInt();

		System.out.println("Introduzca las notas del alumno añadido:");
		System.out.println("Introduzcalas en el siguiente orden: Programacion, Trasversal, BaseDatos, Javascript");
		notas[0] = sc.nextDouble();
		notas[1] = sc.nextDouble();
		notas[2] = sc.nextDouble();
		notas[3] = sc.nextDouble();

		System.out.println("El alumno esta cursando el ultimo curso? (true -> Si // false -> No");
		ultimo = sc.nextBoolean();

		// Aqui añadiremos al array alums todos los parametros recogidos anteriormente
		alums.add(new Alumno(nombre, apellido, edad, notas, ultimo));

	}

	// Metodo para ver la info del alumno
	public static void verAlum(ArrayList<Alumno> alums) {
		Scanner sc = new Scanner(System.in);
		String nombre, apellido;

		System.out.println("Indique el nombre y apellido del alumno a mostrar");
		nombre = sc.next();
		apellido = sc.next();

		// Este for es para recorrer el array alums segun su tamaño y comprueba con el
		// equals si el nombre y el apellido es igual

		for (int i = 0; i < alums.size(); i++) {
			// Aqui creamos alumnoSearch para que guarde la posicion del alumno en el array.
			Alumno alumnoSearch = alums.get(i);
			if (alumnoSearch.getNombre().equalsIgnoreCase(nombre)
					&& alumnoSearch.getApellido().equalsIgnoreCase(apellido)) {

				// Este toString nos imprime todos los datos del alumno, identificandolo con su
				// posicion en i.
				System.out.println(alumnoSearch.toString());

			} else {

				System.out.println("Este alumno no existe");

			}

		}

	}

	// Metodo para modificar una nota de un alumno
	public static void modNota(ArrayList<Alumno> alums) {
		Scanner sc = new Scanner(System.in);
		String nombre, apellido;

		System.out.println("Indique el nombre y apellido del alumno que desee modificar una nota");
		nombre = sc.next();
		apellido = sc.next();

		// Este for es el usado anteriormente para encontrar el alumno en el array.
		for (int i = 0; i < alums.size(); i++) {
			Alumno alumnoSearch = alums.get(i);
			if (alumnoSearch.getNombre().equalsIgnoreCase(nombre)
					&& alumnoSearch.getApellido().equalsIgnoreCase(apellido)) {

				System.out.println(alumnoSearch.toString());

				System.out.println("Indique la materia de la nota que quiera modificar");
				System.out.println("Programacion, Transversal, BaseDatos, Javascript");

				String materiaEdit = sc.next();
				int materiaSwitch = 0;

				// Esta serie de if son basicamente para pasar el String que le pedimos al
				// usuario, a numeros para poder buscarlo en el array de notas.

				if (materiaEdit.equalsIgnoreCase("Programacion")) {
					materiaSwitch = 0;
				} else if (materiaEdit.equalsIgnoreCase("Transversal")) {
					materiaSwitch = 1;
				} else if (materiaEdit.equalsIgnoreCase("BaseDatos")) {
					materiaSwitch = 2;
				} else if (materiaEdit.equalsIgnoreCase("Javascript")) {
					materiaSwitch = 3;
				} else {
					System.out.println("Esta materia no existe");
					break;
				}

				System.out.println("Indique el valor de la nota");
				double valorNota = sc.nextDouble();

				// Aqui cambiamos la nota con el metodo setNota en la posicion guardada por
				// alumnoSearch
				alumnoSearch.setNota(valorNota, materiaSwitch);

			} else {

				System.out.println("Este alumno no existe");

			}

		}

	}

	// Metodo para modificar los datos personales de un alumno
	public static void datosPersonales(ArrayList<Alumno> alums) {
		Scanner sc = new Scanner(System.in);
		String nombre, apellido;
		int opcion;

		System.out.println("Indique el nombre y apellido del alumno que desee modificar una nota");
		nombre = sc.next();
		apellido = sc.next();

		// For para encontrar el alumno en el array
		for (int i = 0; i < alums.size(); i++) {
			Alumno alumnoSearch = alums.get(i);
			if (alumnoSearch.getNombre().equalsIgnoreCase(nombre)
					&& alumnoSearch.getApellido().equalsIgnoreCase(apellido)) {

				System.out.println(alumnoSearch.toString());
				System.out.println("Que dato desea modificar? (1 -> Nombre // 2 -> Apellido)");
				opcion = sc.nextInt();

				// Este switch se divide en el de modificar nombre o apellido segun se indique
				switch (opcion) {
				case 1:
					String newNombre = null;
					System.out.println("A que nombre desea modificar el nombre " + alumnoSearch.getNombre() + "?");
					newNombre = sc.next();
					// Aqui modificamos el valor nombre con setNombre por el nuevo indicado
					alumnoSearch.setApellido(newNombre);

					break;
				case 2:
					String newApellido = null;
					System.out
							.println("A que apellido desea modificar el apellido " + alumnoSearch.getApellido() + "?");
					newApellido = sc.next();
					// Aqui modificamos el valor apellido con setApellido por el nuevo indicado
					alumnoSearch.setApellido(newApellido);

					break;

				default:
					break;
				}

			} else {

				System.out.println("Este alumno no existe");

			}

		}

	}
}
