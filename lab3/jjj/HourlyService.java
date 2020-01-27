public class HourlyService extends Service {

	//declared properties for hourly service
	private int numOfHour;
	private double hourlyRate;
	
	public HourlyService(String itemNumber, String itemName, String description, int hours, double rate){
		super(itemNumber, itemName, hours * rate, description);
		setTaxStatus(true);
		this.numOfHour = hours;
		this.hourlyRate = rate;
	}
	
	//retrieve information about the hourly service
	public int getNumOfHours(){
		return this.numOfHour;
	}
	
	public double getHourlyRate(){
		return this.hourlyRate;
	}
}
