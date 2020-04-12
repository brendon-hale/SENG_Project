package Data_Sys;

public class Test_Types {
	
	static String[] types = {Constants.bp, Constants.cancer, Constants.cardiovascular, Constants.urineAnalysis};
	
	static String[] results = {Constants.pos, Constants.neg};
	
	public static String[] getTypes() {
		return types;
	}
	
	public static String[] getResults() {
		return results;
	}

}