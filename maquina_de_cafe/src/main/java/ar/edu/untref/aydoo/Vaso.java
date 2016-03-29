package ar.edu.untref.aydoo;

public class Vaso {

	private int cantidadQueTieneDeCucharadasDeAzucar;
	private boolean tieneCafe;
	private boolean tieneLeche;

	public Vaso() { // cons:
		
		//lo inicializo vacio!
		this.setAzucar(0); 		this.setCafe(false); 		this.setLeche(false);
	}

	public int getAzucar   () {		
		
		return cantidadQueTieneDeCucharadasDeAzucar;
	}

	public void setAzucar (int cucharadasAAgregarDeAzucarAlVaso) {
		this.cantidadQueTieneDeCucharadasDeAzucar = cucharadasAAgregarDeAzucarAlVaso;
	}

	public boolean getCafe () {
		
		return tieneCafe;
	}

	public void setCafe  (boolean pongoCafe) {
		
		
		this.tieneCafe = pongoCafe;	
	}

	public boolean getLeche() {
		
		return tieneLeche;
	}

	public void setLeche ( boolean pongoLeche) {
		
		this.tieneLeche = pongoLeche;
	}
	
}
