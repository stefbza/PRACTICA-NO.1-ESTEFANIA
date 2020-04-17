package Proyecto;

import  java.io.BufferedReader ;
import  java.io.BufferedWriter ;
import  java.io.FileWriter ;
import  java.io.InputStreamReader ;
import  java.util.Scanner ;

import javax.management.relation.Role;

public class Lista {
	
	public NODO inicio = null;
	public int tamanio = 0;
	Scanner entrada = new Scanner(System.in);
	
	public boolean isVacia() {
		return tamanio == 0;
	}
    
	// METODO CLIENTE FIFO
	public void agregarClienteFIFO (Cliente informacionCliente) {
		NODO nodoTemporal = new NODO (informacionCliente, null);
		
		if (isVacia()) {
			inicio = nodoTemporal;
			
		}else {
			NODO nodoTemporal2 = inicio ;
			while (nodoTemporal2.siguiente!=null) {
				nodoTemporal2 = nodoTemporal2.siguiente;
			}
			nodoTemporal2.siguiente = nodoTemporal;
			
		}
		tamanio ++;
		if (tamanio <= 100) {
			int parking = 100 - tamanio;
			System.out.println("Disponibles"+ parking + " Estacionamientos disponibles de (100)");		
		}	
	}
	
	// METODO CLIENTE LIFO
	
	public void agregarClienteLifo(Cliente informacionCliente) {
		NODO nodoTemporal = new NODO (informacionCliente, null);
		
		if (isVacia()) {
			inicio =nodoTemporal;
			
		}else {
			nodoTemporal.siguiente = inicio;
			inicio = nodoTemporal;
		}
		tamanio ++;
		if (tamanio <= 100) {
			int parking = 100 - tamanio;
			System.out.println("Disponibles" + parking + "Estacionamientos Disponibles de (100)");
		}
		
	}
	
	// METODO SALIDA DEL CLIENTE
	
	public void SalidaCliente (String NuevaPlaca) {
		Scanner entrada = new Scanner(System.in);
		
		Lista NuevaLista = new Lista ();
		NODO nodoTemporal = inicio;
		
		int contador = 0;
		boolean encontrado = false;
		
		while(nodoTemporal.siguiente!=null) {
			if(nodoTemporal.informacionCliente.placaAutomovil.contains(NuevaPlaca)) {
			System.out.println("  |              Se encontro El CLIENTE                                   |");
			System.out.println("   ----------------------------------------------------------------------- ");
			System.out.println("  |DATOS DEL CLIENTE  |                                                   |");
			System.out.println("   ------------------");
			System.out.println("  |Nombre:            |"+nodoTemporal.informacionCliente.nombre         +"|");
			System.out.println("  |NIT:               |"+nodoTemporal.informacionCliente.nit            +"|");
			System.out.println("  |Fecha de Nacimiento|"+nodoTemporal.informacionCliente.FechaNacimiento+"|");
			System.out.println("  |Telefono           |"+nodoTemporal.informacionCliente.Telefono       +"|");
			System.out.println("  |Hora entrada       |"+nodoTemporal.informacionCliente.HoraEntrada    +"|");
			System.out.println("  |Placa              |"+nodoTemporal.informacionCliente.placaAutomovil +"|");
			System.out.println("  |DPI                |"+nodoTemporal.informacionCliente.DPI            +"|");
			System.out.println("  |Modelo             |"+nodoTemporal.informacionCliente.ModeloAutomovil+"|");
			System.out.println("  |____________________________________________________________________"+"|");
			System.out.println("  |____________________________________________________________________"+"|");
			System.out.println("  |Ingrese la hora del Salida del Cliente: |");
			System.out.println("  |________________________________________|");
			int horaSalida = entrada.nextInt();
			int conversion = (horaSalida - nodoTemporal.informacionCliente.HoraEntrada)*(15);
			
			System.out.println("   --------------------------------------- |--|----------|");
			System.out.println("  |El total a cancelar es: Q" +conversion+"|  |          |");
			System.out.println("  |________________________________________|__|          |");
			System.out.println("  | Ingrese el Efectivo con el que Cancelara  |          |");
			double PagoEfectivo = entrada.nextDouble();
			double cambio = PagoEfectivo-conversion;
			System.out.println("  |________________________________________|__|          |");
			System.out.println("  | El monto del Cambio es: Q              |__|"+cambio+"|");
			encontrado = true;
			System.out.println(" EL PROCESO DEL CLIENTE SE REALIZO CON EXITO ( EL CLIENTE SE ELIMINO CORRECTAMENTE )");
			
		}
		nodoTemporal = nodoTemporal.siguiente;
		contador++;
		}
	if (!encontrado ) {
		System.out.println(" No encontrado ");
	}
   }
	
	
	// METODO BUSCAR CLIENTE
	
	public void BuscarCliente (String nuevoNombre, String NuevaPlaca ) {
		NODO nodoTemporal = inicio;
		int contador = 0;
		boolean encontrado = false;
		
		while(nodoTemporal.siguiente!=null) {
		if (nodoTemporal.informacionCliente.nombre.contains(nuevoNombre)|| nodoTemporal.informacionCliente.placaAutomovil.contains(NuevaPlaca)) {
			System.out.println(" SE ENCONTRO EL ELEMENTO EN EL INDICE "+ contador);
			
		}
		nodoTemporal = nodoTemporal.siguiente;
		contador++;
		
	}
	
	if(!encontrado) {
		System.out.println(" No se Encontro ");
		
	}
   }
	
	
	// METODO ELIMINAR CLIENTE
	
	public void EliminarCliente (String NuevaPlaca) {
		
		NODO nodoTemporal = inicio;
		NODO nodoprevious = null;
		int contador = 0;
		boolean encontrado = false;
		
		while(nodoTemporal.siguiente!= null) {
			if (nodoTemporal.informacionCliente.placaAutomovil.contains(NuevaPlaca)) {
				System.out.println(" | Se encontro el Elemento||En el indice|"+ contador);
				
				if (contador == 0 ) {
					NODO remove = null;
					remove = inicio;
					inicio = inicio.siguiente;
					remove.siguiente = null;
					encontrado = true;
					break;
				}else {
					nodoprevious.siguiente = nodoTemporal.siguiente;
					encontrado = true;
					break;	
				}
			}
			nodoprevious = nodoTemporal;
			nodoTemporal = nodoTemporal.siguiente;
			contador++;
			
		}
		if(!encontrado ) {
			System.out.println(" Cliente no Encontrado: ");
		}
		
	}
	
	// METODO GRAFO EMPTY
	
	public void GrafoEMPTY() {
		
		try {
			NODO nodoTemporal = inicio;
			tamanio =0;
			BufferedWriter escritura = new BufferedWriter ( new FileWriter ("C: \\Usuarios \\ AmbienteUMG \\ WorkSpace \\ grafo.gv"));
			escritura.write("digrafo G {\n");
			escritura.write(" rankdir = LR; \n ");
			escritura .write(" nodo [forma = Mrecord , estilo = relleno, color de relleno = gris];\n");
			
			String lineaGraph = "";
			lineaGraph = lineaGraph + "\" "+ " Nombre : "+ nodoTemporal.informacionCliente.nombre + "\n" + " NIT: "+ nodoTemporal.informacionCliente.nit + "\n"+ "TELEFONO: "+nodoTemporal.informacionCliente.Telefono + "\n"+ "Fecha de Nacimiento: "+nodoTemporal.informacionCliente.FechaNacimiento + "\n" + "Placa Automovil"+ nodoTemporal.informacionCliente.placaAutomovil+"\n"+"DPI CLIENTE: "+nodoTemporal.informacionCliente.DPI + "\n"+"Modelo Automovil: "+ nodoTemporal.informacionCliente.ModeloAutomovil+ "\n"+"HORA ENTRADA:"+ nodoTemporal.informacionCliente.HoraEntrada+   " \n " ;
			
			while(nodoTemporal.siguiente != null) {
				nodoTemporal = nodoTemporal.siguiente;
				
				if ((tamanio == 0 )|| (tamanio % 2)== 0) {
					escritura.write("nodo[forma = Mrecord]; \n");
			lineaGraph = lineaGraph + "\" "+ " Nombre : "+ nodoTemporal.informacionCliente.nombre + "\n" + " NIT: "+ nodoTemporal.informacionCliente.nit + "\n"+ "TELEFONO: "+nodoTemporal.informacionCliente.Telefono + "\n"+ "Fecha de Nacimiento: "+nodoTemporal.informacionCliente.FechaNacimiento + "\n" + "Placa Automovil"+ nodoTemporal.informacionCliente.placaAutomovil+"\n"+"DPI CLIENTE: "+nodoTemporal.informacionCliente.DPI + "\n"+"Modelo Automovil: "+ nodoTemporal.informacionCliente.ModeloAutomovil+ "\n"+"HORA ENTRADA:"+ nodoTemporal.informacionCliente.HoraEntrada+   " \n " ;

				}else {
					escritura.write("    nodo[forma = Mrecord, estilo = relleno , color de relleno = gris]; \n " );
			lineaGraph = lineaGraph + "\" "+ " Nombre : "+ nodoTemporal.informacionCliente.nombre + "\n" + " NIT: "+ nodoTemporal.informacionCliente.nit + "\n"+ "TELEFONO: "+nodoTemporal.informacionCliente.Telefono + "\n"+ "Fecha de Nacimiento: "+nodoTemporal.informacionCliente.FechaNacimiento + "\n" + "Placa Automovil"+ nodoTemporal.informacionCliente.placaAutomovil+"\n"+"DPI CLIENTE: "+nodoTemporal.informacionCliente.DPI + "\n"+"Modelo Automovil: "+ nodoTemporal.informacionCliente.ModeloAutomovil+ "\n"+"HORA ENTRADA:"+ nodoTemporal.informacionCliente.HoraEntrada+   " \n " ;
					
				}
				tamanio ++;
			}
			lineaGraph = lineaGraph + "\"null\";\n";
			escritura.write(lineaGraph);
			escritura.write("}\n");
			escritura.close();
			System.out.println (" Ya escribio lo solicitado en el archivo: C: \\ Usuarios \\ AmbienteUMG \\ WorkSpace \\ grafo.gv " );
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	// METODO GRAFO DESDE JAVA
	public void MetodoJava() {
		try {
			ProcessBuilder constructor =  new  ProcessBuilder ( " cmd.exe " , " / c " , " cd \" C: \\Usuarios \\ AmbienteUMG \\ WorkSpace \\ grafo.gv");
			constructor . redirectErrorStream (true);
			Process C = constructor.start();
			BufferedReader r =  new  BufferedReader ( new  InputStreamReader (C . getInputStream ()));
			String line ;
			while(true) {
				line = r .readLine();
				if (line ==  null ) { break ; }
				System.out.println(line);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
}
