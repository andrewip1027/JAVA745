/**
 * Model of a weather reading.
 * Full documentation to follow.
 *  *
 */

public class Reading {

	int id;
	Location loc;
	double temp;
	double windspeed;
	
	static public final double MAX_TEMP = 50;
	static public final double MIN_TEMP = -40;	

	static public final double MAX_WIND = 150;
	static public final double MIN_WIND = 0;	
	
	private Reading(Location l, double t, double w) {
		id = (int) ((Math.random() * ((Integer.MAX_VALUE - 0) + 1)) + 0);	
		loc = l;
		temp  = t;
		windspeed = w;
	}
	
	public static Reading createObject (Location l) {	
		return new Reading(
				l,
				((Math.random() * ((Reading.MAX_TEMP - Reading.MIN_TEMP) + 1)) + Reading.MAX_TEMP),
				(double) ((Math.random() * (Reading.MAX_WIND + 1)) + 0)
		);
	}
	
	public String toString() {
		return
				"reading id: " + this.id +
				" loc: " + this.loc.getString() +
				" windspeed: " + this.windspeed + " km/h" + 
				" temparature: " + this.temp + " degrees";		
	}
};

enum Location { 

	NW(1,"North West"),
	NE(2, "North East"),
	SW(3, "South West"),
	SE(4, "South East");
	
	private final int locId;
	private final String locString;
	
	Location(int l, String s) { 
		locId = l; 
		locString = s;
	};
	
	public int getId() { return locId; }
	public String getString() { return locString; }
	
};