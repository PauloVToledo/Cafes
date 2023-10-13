package model;

public class Cafe {
	private int gCafe;
	private int mmAgua;
	private String size;
	private String optIngrediente;

	public Cafe(int gCafe, int mmAgua, String size, String optIngrediente) {
		this.gCafe = gCafe;
		this.mmAgua = mmAgua;
		this.size = size;
		this.optIngrediente = optIngrediente;
	}

	public int getGCafe() {
		return this.gCafe;
	}

	public void setGCafe(int gCafe) {
		this.gCafe = gCafe;
	}

	public int getMmAgua() {
		return this.mmAgua;
	}

	public void setMmAgua(int mmAgua) {
		this.mmAgua = mmAgua;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOptIngrediente() {
		return this.optIngrediente;
	}

	public void setOptIngrediente(String optIngrediente) {
		this.optIngrediente = optIngrediente;
	}
}