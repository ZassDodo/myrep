package pt.upacademy.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity {
	
	public ArrayList<Integer> shelfs = new ArrayList<Integer>();
	private int disc = 0;
	private int iva = 0;
	private int pvp = 0;


	public Product (int disc, int iva, int pvp) {
	    this.disc = disc;
	    this.iva = iva;
	    this.pvp = pvp;
	
	}



	public ArrayList<Integer> getShelfs() {
		return shelfs;
	}
	
	public void addShelf(int shelfId) {
		this.shelfs.add(shelfId);
	}
	
	public void removeShelf(int shelfId) {
		this.shelfs.remove(new Integer(shelfId));
	}

 

	public void setShelfs(ArrayList<Integer> shelfs) {
		this.shelfs = shelfs;
	}



	public int getDisc() {
		return disc;
	}



	public void setDisc(int disc) {
		this.disc = disc;
	}



	public int getIva() {
		return iva;
	}



	public void setIva(int iva) {
		this.iva = iva;
	}



	public int getPvp() {
		return pvp;
	}



	public void setPvp(int pvp) {
		this.pvp = pvp;
	}



	@Override
	public String toString() {
		return "Prateleiras = " + shelfs + "; Desconto = " + disc + ", IVA = " + iva + "; Preço de venda = " + pvp + "";
	}

	
}
