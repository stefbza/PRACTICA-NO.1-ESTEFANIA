package Proyecto;

import java.util.Scanner;


public class MAIN {
	
	public static void main (String args[]) {
		Scanner entrada = new Scanner(System.in);
		Lista ListaEstefania = new Lista ();
		
		int opcion = 0 ;
		
		String NuevoNombre = " ";
		String NuevaPlaca1 ="";
		
		do {
			System.out.println(" =================================== ");
			  System.out.println("|           MENU PRINCIPAL          |");
			  System.out.println(" =================================== ");
			  System.out.println("| Que Operación desea realizar?     |");
			  System.out.println(" ===================================|");
			  System.out.println(" ----------------------------------- ");
			  System.out.println("|1. Registro de Clientes            |");
			  System.out.println(" ----------------------------------- ");
			  System.out.println("|2. Salida de Clientes              |");
			  System.out.println(" ----------------------------------- ");
			  System.out.println("|3. Vizualizacion de Parqueo        |");
			  System.out.println(" ----------------------------------- ");
			  System.out.println("|4. Busqueda de Cliente             |");
			  System.out.println(" ----------------------------------- ");
			  System.out.println("|5. Salir                           |");
			  System.out.println(" ----------------------------------- ");
			  System.out.println(" Que operacion Desea Realizar:       ");
			  opcion = entrada.nextInt();
			  switch (opcion ) {
			  
			  case 1:
			
				  do {
					  System.out.println(" | --------------------------------------------||");
					  System.out.println(" | |         INGRESARA UN NUEVO CLIENTE        ||");
					  System.out.println(" | | __________________________________________||");
					  System.out.println(" |______________________________________________|");
					  System.out.println(" |Ingrese el nombre del Cliente:|               |");
					  String nombre = entrada.next();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese el NIT del Cliente:   |               |");
					  String nit = entrada.next();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese la fecha de Nacimineto del Cliente    |");
					  int FechaNacimiento = entrada.nextInt();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese el Telefono del Cliente:              |");
					  String Telefono1 = entrada.next();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese la hora de Entrada del Cliente:       |");
					  int HoraEntrada = entrada.nextInt();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese la placa del Automovil:               |");
					  String placaAutomovil = entrada.next();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" |Ingrese el DPI del Cliente:                   |");
					  String DPI = entrada.next();
					  System.out.println("  ----------------------------------------------|");
					  System.out.println(" | Ingrese el Modelo del Vehiculo:              |");
					  String ModeloAutomovil = entrada.next();
					  
					  int edad = 2020 - FechaNacimiento;
					  
					  Cliente newClient = new Cliente (nombre, nit, FechaNacimiento, Telefono1, HoraEntrada, placaAutomovil, DPI, ModeloAutomovil );
					  
					  if(edad <=50) {
						  ListaEstefania.agregarClienteFIFO(newClient);
						  System.out.println(" El cliente fue ingresado al Final del Parqueo por que no es de la (TERCERA EDAD)");
					  }else {
						  ListaEstefania.agregarClienteLifo(newClient);
						  System.out.println(" El cliente Ingresado es de la TERCERA EDAD, Por lo tanto fue ingresado al Inicio del Parqueo");
					  }
					  System.out.println( " DESEA INGRESAR OTRO CLIENTE?");
					  System.out.println("  1. SI             2. NO     ");
					  opcion = entrada.nextInt(); 
				  }while(opcion ==1 );
				  
				  break;
				  
			  case 2:
				  System.out.println(" Ingrese la Placa del Cliente que Saldra del PARQUEO: ");
				  NuevaPlaca1 = entrada.next();
				  
				  	ListaEstefania.SalidaCliente(NuevaPlaca1);
				  	ListaEstefania.EliminarCliente(NuevaPlaca1);
				  	
				  	System.out.println(" Desea volver al menu principal ? ");
				  	System.out.println(" (1. si )   ( 2. No)"              );
				  	opcion = entrada.nextInt();
				  	
				  break;
				  
			  case 3:
				  ListaEstefania.GrafoEMPTY();
				  ListaEstefania.MetodoJava();
			      break;
			      
			  case 4:
				  System.out.println(" Ingrese del Cliente que desea Buscar:  ");
				  NuevoNombre = entrada.next();
				  System.out.println(" Ingrese la Placa del Vehiculo:         ");
				  NuevaPlaca1 = entrada.next();
				  ListaEstefania.BuscarCliente(NuevoNombre, NuevaPlaca1);
				  
				  System.out.println(" Desea Volver al Menu Principal : ");
				  System.out.println(" (6.si)             (7.no)        ");
				  opcion = entrada.nextInt();
				  
				  break;
				  
		      default:
		    	  break;
	 
			  }
			  
		}while(  opcion  == 2  );
		
		
	}

}
