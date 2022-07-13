package it.polito.tdp.genes.model;

public class ArchiAdiacenti {

	
	String loca;
	double peso;
	
	
	
	public ArchiAdiacenti(String loca, double peso) {
		super();
		this.loca = loca;
		this.peso = peso;
	}
	public String getLoca() {
		return loca;
	}
	public void setLoca(String loca) {
		this.loca = loca;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String toString() {
		
		return this.loca + " " + this.peso + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loca == null) ? 0 : loca.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchiAdiacenti other = (ArchiAdiacenti) obj;
		if (loca == null) {
			if (other.loca != null)
				return false;
		} else if (!loca.equals(other.loca))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	
	
	
	
}
