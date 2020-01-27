public enum TaxRates {

	//fixed sets of provincial tax rates
	AB(0.03, 0.05, "Alberta"), ON(0.05, 0.06, "Ontario"), 
	BC(0.09, 0.09, "British Columbia"), QC(0.08, 0.07, "Quebec");
	
	//declared properties for each set of provincial tax rates
	private final double goodRate;
	private final double serviceRate;
	private final String province;
	
	TaxRates(double gr, double sr, String prov){
		goodRate = gr;
		serviceRate = sr;
		province = prov;
	}
	
	//retrieve information about each set of provincial tax rates
	public String[] getTaxInfo(){
		String[] taxInfo = new String[3];
		taxInfo[0] = goodRate + "";
		taxInfo[1] = serviceRate + "";
		taxInfo[2] = province;
		
		return taxInfo;
	}
}