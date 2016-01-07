package com.example.timetoeat;

public class Shop {
	protected int love;
	protected int spe;
	protected int lazy;
	protected String name;
	public Shop(){
		this.name=" ";
		this.love=0;
		this.spe=0;
		this.lazy=0;
	}
	public Shop(String n,int l,int s,int la){
		this.name=n;
		this.love=l;
		this.spe=s;
		this.lazy=la;
	}
}
