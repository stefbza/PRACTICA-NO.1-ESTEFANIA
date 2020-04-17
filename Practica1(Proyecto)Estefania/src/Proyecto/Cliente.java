package Proyecto;

public class Cliente {
	
	String nombre = "";
	String nit = "";
	int FechaNacimiento;
	String Telefono="";
	int HoraEntrada;
	String placaAutomovil="";
	String DPI="";
	String ModeloAutomovil ="";
	
	public Cliente(String nombre, String nit, int fechaNacimiento, String telefono, int horaEntrada,
			String placaAutomovil, String dPI, String modeloAutomovil) {
		super();
		this.nombre = nombre;
		this.nit = nit;
		this.FechaNacimiento = fechaNacimiento;
		this.Telefono = telefono;
		this.HoraEntrada = horaEntrada;
		this.placaAutomovil = placaAutomovil;
	    this.DPI = dPI;
		this.ModeloAutomovil = modeloAutomovil;
	}
	
	
	
	

}
