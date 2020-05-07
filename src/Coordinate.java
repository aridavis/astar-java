
public class Coordinate {
	private Integer x;
	private Integer y;
	
	public Coordinate(Integer y, Integer x) {
		super();
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}	
	
	public Boolean isSameCoordinate(Coordinate c) {
		return x == c.getX() && y == c.getY();
	}
}
