package Part1;

public class Clause {
	private RuleVariable lhs;
	private String rhs;
	private Condition condition;
	private boolean truth = false;
	
	//constructor
	public Clause(RuleVariable lhs, String rhs, Condition condition) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.condition = condition;
	}
	
	
	//setters & getters
	public RuleVariable getLhs() {
		return lhs;
	}
	
	public void setLhs(RuleVariable lhs) {
		this.lhs = lhs;
	}
	
	public String getRhs() {
		return rhs;
	}
	
	public void setRhs(String rhs) {
		this.rhs = rhs;
	}
	
	public Condition getCondition() {
		return condition;
	}
	
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public void setTruth(boolean truth) {
		this.truth = truth;
	}


	public boolean getTruth() {
		return this.truth;
	}


	public boolean equals(Clause obj) {
		if((this.lhs.toString() == obj.lhs.toString()) && (this.condition.getSymbol() == obj.condition.getSymbol()) && (this.rhs == obj.rhs)) {
			return true;
		}
		else return false;
	}


	@Override
	public String toString() {
		return "Clause [lhs= " + lhs + ", rhs= " + rhs + ", condition= " + condition.getSymbol() + "]";
	}
	
	




}
