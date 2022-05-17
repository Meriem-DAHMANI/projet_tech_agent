package Part1;

import java.util.ArrayList;
import java.util.Arrays;

public class SE1 {
//le système expert des vehicules
	private ArrayList<Rule> rules = new ArrayList<Rule>();
	private ArrayList<Clause> facts =  new ArrayList<Clause>();
	private RuleVariable goalVariable;
	
	public void define() {
		//définition des règles
		
		//rules
		//first rule 
		Clause r1c1 = new Clause(RuleVariable.vehicleType, "Cycle", new Condition("="));
		Clause r1c2  = new Clause(RuleVariable.num_wheels, "2", new Condition("="));
		Clause r1c3 = new Clause(RuleVariable.motor, "no", new Condition("="));
		Clause r1Consequent = new Clause(RuleVariable.vehicle, "Bicycle", new Condition("="));
	
		Rule r1 = new Rule("Bicycle",new ArrayList<Clause>(Arrays.asList(r1c1, r1c2, r1c3)), r1Consequent);
		this.rules.add(r1);
		
		
		//second rule 
		Clause r2c1 = new Clause(RuleVariable.vehicleType, "Cycle", new Condition("="));
		Clause r2c2  = new Clause(RuleVariable.num_wheels, "3", new Condition("="));
		Clause r2c3 = new Clause(RuleVariable.motor, "no", new Condition("="));
		Clause r2Consequent = new Clause(RuleVariable.vehicle, "Tricycle", new Condition("="));
		
		Rule r2 = new Rule("Tricycle",new ArrayList<Clause>(Arrays.asList(r2c1, r2c2, r2c3)), r2Consequent);
		this.rules.add(r2);
		
		
		//3rd rule 
		Clause r3c1 = new Clause(RuleVariable.vehicleType, "Cycle", new Condition("="));
		Clause r3c2  = new Clause(RuleVariable.num_wheels, "2", new Condition("="));
		Clause r3c3 = new Clause(RuleVariable.motor, "yes", new Condition("="));
		Clause r3Consequent = new Clause(RuleVariable.vehicle, "Motocycle", new Condition("="));
		
		Rule r3	= new Rule("Motocycle",new ArrayList<Clause>(Arrays.asList(r3c1, r3c2, r3c3)), r3Consequent);
		this.rules.add(r3);
		
		
		//4th rule 
		Clause r4c1 = new Clause(RuleVariable.vehicleType, "Cycle", new Condition("="));
		Clause r4c2  = new Clause(RuleVariable.size, "small", new Condition("="));
		Clause r4c3 = new Clause(RuleVariable.num_doors, "2", new Condition("="));
		Clause r4Consequent = new Clause(RuleVariable.vehicle, "SportCar", new Condition("="));
		
		Rule r4	= new Rule("SportCar",new ArrayList<Clause>(Arrays.asList(r4c1, r4c2, r4c3)), r4Consequent);
		this.rules.add(r4);
		
		
		//5th rule 
		Clause r5c1 = new Clause(RuleVariable.vehicleType, "automobile", new Condition("="));
		Clause r5c2  = new Clause(RuleVariable.size, "medium", new Condition("="));
		Clause r5c3 = new Clause(RuleVariable.num_doors, "4", new Condition("="));
		Clause r5Consequent = new Clause(RuleVariable.vehicle, "Sedan", new Condition("="));
		
		Rule r5	= new Rule("Sedan",new ArrayList<Clause>(Arrays.asList(r5c1, r5c2, r5c3)), r5Consequent);
		this.rules.add(r5);
		
		
		//6th rule 
		Clause r6c1 = new Clause(RuleVariable.vehicleType, "automobile", new Condition("="));
		Clause r6c2  = new Clause(RuleVariable.size, "medium", new Condition("="));
		Clause r6c3 = new Clause(RuleVariable.num_doors, "3", new Condition("="));
		Clause r6Consequent = new Clause(RuleVariable.vehicle, "MiniVar", new Condition("="));
		
		Rule r6 = new Rule("MiniVar",new ArrayList<Clause>(Arrays.asList(r6c1, r6c2, r6c3)), r6Consequent);
		rules.add(r6);
		
		
		//7th rule 
		Clause r7c1 = new Clause(RuleVariable.vehicleType, "automobile", new Condition("="));
		Clause r7c2  = new Clause(RuleVariable.size, "large", new Condition("="));
		Clause r7c3 = new Clause(RuleVariable.num_doors, "4", new Condition("="));
		Clause r7Consequent = new Clause(RuleVariable.vehicle, "SportUtilityVehicle", new Condition("="));
		
		Rule r7 = new Rule("SUV",new ArrayList<Clause>(Arrays.asList(r7c1, r7c2, r7c3)), r7Consequent);
		this.rules.add(r7);
		
		//8th rule 
		Clause r8c1 = new Clause(RuleVariable.num_wheels, "4", new Condition("<"));
		Clause r8Consequent = new Clause(RuleVariable.vehicleType, "Cycle", new Condition("="));
		
		Rule r8 = new Rule("Cycle",new ArrayList<Clause>(Arrays.asList(r8c1)), r8Consequent);
		this.rules.add(r8);
		
		//9th rule
		Clause r9c1  = new Clause(RuleVariable.num_wheels, "4", new Condition("="));
		Clause r9c2 = new Clause(RuleVariable.motor, "yes", new Condition("="));
		Clause r9Consequent = new Clause(RuleVariable.vehicleType, "automobile", new Condition("="));
	
		Rule r9 = new Rule("Automobile",new ArrayList<Clause>(Arrays.asList(r9c1, r9c2)), r9Consequent);
		rules.add(r9);
		

		//facts
		Clause f1 = new Clause(RuleVariable.num_wheels, "4", new Condition("="));
		Clause f2 = new Clause(RuleVariable.motor, "yes", new Condition("="));
		Clause f3 = new Clause(RuleVariable.num_doors, "3", new Condition("="));
		Clause f4 = new Clause(RuleVariable.size, "medium", new Condition("="));
		this.facts.add(f1);
		this.facts.add(f2);
		this.facts.add(f3);
		this.facts.add(f4);
		
		//goal
		this.goalVariable = RuleVariable.vehicle;
		
		//define SE
		SE vehiclesSystem = new SE(this.rules, this.facts, this.goalVariable);
		vehiclesSystem.applyRules();
		
	}

	
	
}
