public class Service extends Item {

	//declared property for service
	private String description;
	
	public Service(String itemNumber, String itemName, double itemPrice, String description){
		super(itemNumber, itemName, itemPrice);
		super.isTaxable = false;
		this.description = description;
	}
	
	//retrieve information about the service
	public String getDescription(){
		return this.description;
	}
	
	//modify information about the service
	public void setTaxStatus(boolean status){
		super.isTaxable = status;
	}
	
	@Override
	public void setPrice(double price){
		super.setPrice(price);
	}
}
