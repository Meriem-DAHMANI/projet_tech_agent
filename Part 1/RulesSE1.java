package Part1;

public class RulesSE1 {
private String vehicleType;
private int num_wheels;
private int num_doors;
private boolean motor;
private String vehicle;
private String size;

private boolean truth; 

//constructor
//1
public RulesSE1(String vehicleType, int num_wheels, boolean motor) {
	super();
	this.vehicleType = vehicleType;
	this.num_wheels = num_wheels;
	this.motor = motor;
}

//2
public RulesSE1(String vehicleType, int num_doors, String size) {
	super();
	this.vehicleType = vehicleType;
	this.num_doors = num_doors;
	this.size = size;
}

//3
public RulesSE1(int num_wheels) {
	super();
	this.num_wheels = num_wheels;
}

//4
public RulesSE1(int num_wheels, boolean motor) {
	super();
	this.num_wheels = num_wheels;
	this.motor = motor;
}



}
