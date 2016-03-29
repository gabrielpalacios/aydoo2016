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

//		if(cucharadasAAgregarDeAzucarAlVaso < 0){
//			try {
//				throw new Exception("No existen cantidades negativas de azucar.");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

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
