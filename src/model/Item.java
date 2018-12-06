package model;

public class Item {
	private static int counter = -1;
	private int number;
	private String name;

	public Item(int number, String name) {
		this.number = number;
		this.name = name;
	}
	public Item(String name) {
		this.number = ++counter;
		this.name = name;
	}
	
	public int getNumber() { return this.number; }
	public String getName() { return this.name; }
}
