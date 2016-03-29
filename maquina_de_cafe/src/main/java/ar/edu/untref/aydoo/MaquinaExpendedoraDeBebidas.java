package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
	
	private Vaso                  vaso;
	private Azucarero             azucarero;	
	
	private HacedorDeCafeConLeche hacedorDeCafeConLeche;
	
	
	// solo una funcion!
	
	public Vaso hacerCafeConLecheConNDeAzucar (int cucharadasQueQuieroAgregarDeAzucar){
		
		//arranco con el vaso, se pone vacio:
		this.vaso = new Vaso();
		//arranco
		this.hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
		// ele paso el vaso
		this.vaso = this.hacedorDeCafeConLeche.prepararEnEsteVaso(vaso);
		
		//arracnco
		this.azucarero = new Azucarero();
		//les paso el vacso
		this.vaso = this.azucarero.ponerNEnEsteVaso(cucharadasQueQuieroAgregarDeAzucar, vaso);
		
		//listo, resultado final, preparado
		return this.vaso;
	}

}
