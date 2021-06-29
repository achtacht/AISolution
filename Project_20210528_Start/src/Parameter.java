
public class Parameter {

	int maxTime ;
	int minTime ;
	
	
	public Parameter() {
		this(-1, -1);
	}
	
	public Parameter(int minTime, int maxTime) {
		this.minTime = minTime;
		this.maxTime = maxTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public int getMinTime() {
		return minTime;
	}

	public void setMinTime(int minTime) { 
		this.minTime = minTime;
	}

	
	@Override
	public String toString() {
		return "Time Spent On Online : (" 
	+ this.minTime + " ~ " + this.maxTime + ")"; 
	}
}
