package Part1;

public class Condition {
private String symbol;
private int index;


//constructor
public Condition(String symbol) {
	this.symbol = symbol;
	if(symbol.equals("=")) {
		index = 1;
	}else if(symbol.equals(">")) {
		index = 2;
	}else if(symbol.equals("<")) {
		index = 3;
	}else if(symbol.equals("!=")) {
		index = 4;
	}else {
		index = -1;
	}
}

//setters & getters
public String getSymbol() {
	return symbol;
}

public void setSymbol(String symbol) {
	this.symbol = symbol;
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}

}
