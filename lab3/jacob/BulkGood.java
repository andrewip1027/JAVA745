public class BulkGood extends Item {

	//declared properties for package good
	private int unitQuantity;
	private double unitPrice;
	
	
	public BulkGood(String itemNumber, String itemName, int quantity, double price){   
		super(itemNumber, itemName, quantity * price);
		this.unitQuantity = quantity;
		this.unitPrice = price;
	}
	
	//retrieve information about the package good
	public int getUnitQuantity(){
		return this.unitQuantity;
	}
	
	public double getUnitPrice(){
		return this.unitPrice;
	}
}