public class ScaleGood extends Item {

	//declared properties for scale good
	private double weight;
	private double pricePerKg;
	
	public ScaleGood(String itemNumber, String itemName, double weight, double pricePerKg){
		super(itemNumber, itemName, weight * pricePerKg);
		this.weight = weight;
		this.pricePerKg = pricePerKg;
	}
	
	//retrieve information about the scale good
	public double getWeight(){
		return weight;
	}
	
	public double getPricePerKg(){
		return pricePerKg;
	}
}