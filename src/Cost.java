
public class Cost {
	private Double gCost;
	private Double hCost; 
	private Double fCost;
	
	public Double getgCost() {
		return gCost;
	}
	public Double gethCost() {
		return hCost;
	}
	public Double getfCost() {
		return fCost;
	}
	public Cost(Double gCost, Double hCost) {
		super();
		this.gCost = gCost;
		this.hCost = hCost;
		this.fCost = gCost + hCost;
	}
	
	public Boolean isMoreThan(Cost cost) {
		return this.fCost > cost.getfCost();
	}
}
