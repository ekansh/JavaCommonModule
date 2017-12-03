package enumerations;

public enum Day {
	SUNDAY (1,"Holiday"),
	MONDAY(2,"Business Day"), 
	TUESDAY(3,"Business Day"),
	SATURDAY(7,"Business Day");
	private int dow;
	private String typeOfDay;
	Day(int dow, String typeOfDay){
		this.dow=dow;
		this.typeOfDay=typeOfDay;
	}
	public int getDow() {
		return dow;
	}
	public String getTypeOfDay() {
		return typeOfDay;
	}
 
	
}