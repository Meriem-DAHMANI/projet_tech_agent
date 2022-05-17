package Part1;

import java.util.ArrayList;

public class SE {
	private ArrayList<Rule> rules;
	private ArrayList<Clause> facts;
	private ArrayList<Rule> conflictSet =  new ArrayList<Rule>();
	private RuleVariable goalVariable;
	private boolean goalAchieved;

	//constructor
	public SE(ArrayList<Rule> rules, ArrayList<Clause> facts, RuleVariable goalVariable) {
		this.rules = rules;
		this.facts = facts;
		this.conflictSet = new ArrayList<Rule>();
		this.goalVariable = goalVariable;
		this.goalAchieved = false;
	}
	
	
	//methods
    //la méthode du chainage avant
	public void applyRules() {
		do{      
			//sélectionner les règles possibles
			     for(Rule r : this.rules) {
						if(r.getTruth(facts) && !r.isUsed()) {
							this.conflictSet.add(r);
						}
					}
			     
			     if(conflictSet.isEmpty()) {
			    	 System.out.println("sorry but we couldn't find wech ykheredj 3lik ! ");
			    	 break;
			     }

			     //afficher conflict set
			     System.out.print("conflict set : ");
			     for(Rule r: conflictSet) {
			    	 System.out.print(r+" ");
			     }
				 System.out.print("\n");
			    
			    //choisir la règle à appliquer parmi les règles du conflict set 
				Rule appliedRule = selectRule();
				System.out.println("applied rule : "+ appliedRule);
				//void fire()
				conflictSet.remove(0);
				appliedRule.setUsed(true);
				Clause resultClause = appliedRule.getConsequent();
				resultClause.setTruth(true);
				this.facts.add(resultClause);
				
				if(resultClause.getLhs().equals(goalVariable)) {
					this.goalAchieved = true;
					System.out.println("but atteint :"+ goalVariable+" = "+resultClause.getRhs());
				}
		}while(!goalAchieved);
		
	}

	//La méthode selectRule permet de sélectionner la règle à appliquer parmi les règles du conflict set
	public Rule selectRule() {
		return this.conflictSet.get(0);
	}
	

	
	
}
