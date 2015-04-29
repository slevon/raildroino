package de.slevon.raildroid;

public class Train {
	
	int adress=0; 
	String name=""; 
	boolean direction=false;
	int speed =0;
	int function =0;
	
	public Train(int adress,String name,boolean direction,int speed,int function){
		this.adress=adress;
		this.name=name;
		this.direction=direction;
		this.speed=speed;
		this.function=function;
	}
 
}
