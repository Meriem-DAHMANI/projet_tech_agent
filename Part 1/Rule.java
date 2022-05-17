package Part1;

import java.util.ArrayList;

public class Rule {
	 private String name;
	 private ArrayList<Clause> antecedents;
	 private Clause consequent;
	 private boolean truth ;
	 private boolean used = false;
	 
	//constructor
	public Rule(String name, ArrayList<Clause> antecedents, Clause consequent) {
		this.name = name;
		this.antecedents = antecedents;
		this.consequent = consequent;
	}
	
	
	//methods
	//and or dude
	public void setTruth() {

	}
	
	public boolean getTruth(ArrayList<Clause> facts) {
		this.truth = true;
		boolean found;
		int i;
		for(Clause c : antecedents) {
			found = false;
			i = 0;
			while(!found && i<facts.size()) {
				if(c.equals(facts.get(i))) found = true;
				i++;
			}
			if(!found) return false;
		}
		return true;
	}

	
	//setters & getters
	public Clause getConsequent() {
		return consequent;
	}


	public void setConsequent(Clause consequent) {
		this.consequent = consequent;
	}

	
	public boolean isUsed() {
		return used;
	}
	

	public void setUsed(boolean used) {
		this.used = used;
	}


	public void setTruth(boolean truth) {
		this.truth = truth;
	}
	
	
	

	//toString
	@Override
	public String toString() {
		return  name;
	}
	

}
