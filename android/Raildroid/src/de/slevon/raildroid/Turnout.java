package de.slevon.raildroid;

public class Turnout {
	
	int adress=0;
	String name="xxx";
	boolean state=true;
	boolean inverted = true;
	
	public Turnout(int adress,String name, boolean state, boolean inverted) {
		this.adress = adress;
		this.name 	= name;
		this.state 	= state;
		this.inverted = inverted;
	}

}
