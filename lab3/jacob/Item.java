public class Item {

	//item properties whether for good or service
	private String itemNumber;
	private String itemName;
	private double itemPrice;
	public boolean isTaxable;
	public boolean isFlagged;
	
	public Item(String itemNumber, String itemName, double itemPrice){
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.isTaxable = true;
		this.isFlagged = false;
	}
	
	//retrieve information about the item
	public String getItemNumber(){
		return this.itemNumber;
	}
	
	public String getItemName(){
		return this.itemName;
	}
	
	public double getItemPrice(){
		return this.itemPrice;
	}
	
	//calculate the price after tax based on the tax rate input
	public double getPriceAfterTax(double taxRate){
		double priceAfterTax = this.itemPrice * (1 + taxRate);
		return priceAfterTax;
	}
	
	//change the price of the item
	public void setPrice(double price){
		this.itemPrice = price;
	}
}
