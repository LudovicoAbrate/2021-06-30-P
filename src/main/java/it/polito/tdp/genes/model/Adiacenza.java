package it.polito.tdp.genes.model;

public class Adiacenza {

	String loca1;
	String loca2;
	double p;
	public Adiacenza(String loca1, String loca2, double p) {
		super();
		this.loca1 = loca1;
		this.loca2 = loca2;
		this.p = p;
	}
	public String getLoca1() {
		return loca1;
	}
	public void setLoca1(String loca1) {
		this.loca1 = loca1;
	}
	public String getLoca2() {
		return loca2;
	}
	public void setLoca2(String loca2) {
		this.loca2 = loca2;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	
	
	
}
