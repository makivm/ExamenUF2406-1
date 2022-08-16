package modelo;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Envio {
	private String ciudadOrigen;
	private boolean origenNacional;
	private String ciudadDestino;
	private boolean destinoNacional;
	private String tipoEnvio;
	private int peso;
	
	
	
	public Envio() {
	}


	public Envio(String ciudadOrigen, boolean origenNacional, String ciudadDestino, boolean destinoNacional,
			String tipoEnvio, int peso) {
		this.ciudadOrigen = ciudadOrigen;
		this.origenNacional = origenNacional;
		this.ciudadDestino = ciudadDestino;
		this.destinoNacional = destinoNacional;
		this.tipoEnvio = tipoEnvio;
		this.peso = peso;
	}


	public String getCiudadOrigen() {
		return ciudadOrigen;
	}


	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}


	public boolean isOrigenNacional() {
		return origenNacional;
	}


	public void setOrigenNacional(boolean origenNacional) {
		this.origenNacional = origenNacional;
	}


	public String getCiudadDestino() {
		return ciudadDestino;
	}


	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}


	public boolean isDestinoNacional() {
		return destinoNacional;
	}


	public void setDestinoNacional(boolean destinoNacional) {
		this.destinoNacional = destinoNacional;
	}


	public String getTipoEnvio() {
		return tipoEnvio;
	}


	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ciudadDestino, ciudadOrigen, destinoNacional, origenNacional, peso, tipoEnvio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envio other = (Envio) obj;
		return Objects.equals(ciudadDestino, other.ciudadDestino) && Objects.equals(ciudadOrigen, other.ciudadOrigen)
				&& destinoNacional == other.destinoNacional && origenNacional == other.origenNacional
				&& peso == other.peso && Objects.equals(tipoEnvio, other.tipoEnvio);
	}
	
	public double  calcularImporte() {
		int importe=0;
		if(origenNacional&&destinoNacional) {
			importe=4;
		}else {
			importe=7;
		}
		if(tipoEnvio.equals("Paq 10- Antes de las 10h")) {
			importe=importe+5;
		}else if(tipoEnvio.equals("Paq 14- Antes de las 14h")) {
			importe=importe+2;
		}
		int recargo=peso/10;
		
		return importe+(3.5*recargo);
	}
	

}

