
public class Node {
	
	private Coordinate coor;
	private Cost cost;
	private Character c;
	private Boolean isOpened;
	private Node parent;
	
	public Node(Coordinate coor, Character c) {
		super();
		this.coor = coor;
		this.cost = new Cost((double)0,(double)0);
		this.c = c;
		this.isOpened = false;
		this.parent = null;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Coordinate getCoor() {
		return coor;
	}
	
	public Cost getCost() {
		return cost;
	}
	
	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public Character getC() {
		return c;
	}

	public void setC(Character c) {
		this.c = c;
	}

	public Boolean getIsOpened() {
		return isOpened;
	}

	public void setIsOpened(Boolean isOpened) {
		this.isOpened = isOpened;
	}	
	
}
