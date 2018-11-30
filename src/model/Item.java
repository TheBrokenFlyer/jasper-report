package model;

public class Item {
	private int number;
	private String name;

	public Item(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public int getNumber() { return this.number; }
	public String getName() { return this.name; }
}
