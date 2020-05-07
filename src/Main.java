import java.util.Scanner;
import java.util.Vector;

public class Main {
	final Integer SIZE = 20;
	
	Node[][] map = new Node[25][25];	
	Vector<Node> vOpen = new Vector<Node>();
	
	Integer[] nX = {1,0,-1,0};
	Integer[] nY = {0,1,0,-1};
	
	public Main() {
		initMap();
		aStar(new Coordinate(1, 1), new Coordinate(15, 11));
	}
	
	void sort() {
		for(int i = 0; i < vOpen.size();i++) {
			for(int j=0;j<vOpen.size() -1; j++) {
				if(vOpen.get(j).getCost().getfCost() > vOpen.get(j+1).getCost().getfCost()) {
					Node temp = vOpen.get(j);
					vOpen.set(j, vOpen.get(j+1));
					vOpen.set(j+1, temp);
				}
			}
		}
	}
	
	private Double findEuclidean(Coordinate start, Coordinate end) {
		return Math.sqrt(Math.pow(start.getY()-end.getY(), 2) + Math.pow(end.getX() - start.getX(), 2));
	}
	
	private void aStar(Coordinate start, Coordinate end) {
		int x = 0;
		Node curr = map[start.getY()][start.getX()];
		vOpen.add(curr);
		curr.setIsOpened(true);
		
		while(vOpen.size() > 0) {
			x++;
			sort();
			curr = vOpen.remove(0);
			if(end.isSameCoordinate(curr.getCoor())) {
				break;
			}
			
			for(int i = 0; i < 4;i++) {
				if(!isValidNeighbor(curr.getCoor(), i)) {
					continue;
				}
				
				Node neighbor = map[curr.getCoor().getY() + nY[i]][curr.getCoor().getX() + nX[i]];
				Cost currCost = curr.getCost();
				Cost tempCost = new Cost(currCost.getgCost() + 1, findEuclidean(neighbor.getCoor(), end));
				
				if(neighbor.getIsOpened()) {
					if(neighbor.getCost().isMoreThan(tempCost)) {
						neighbor.setParent(curr);
						neighbor.setCost(tempCost);
					}
				}
				else {
					neighbor.setParent(curr);
					neighbor.setCost(tempCost);
					vOpen.add(neighbor);
				}	
				neighbor.setIsOpened(true);
			}
		}
		System.out.println("Total Complexity: " + x);
		backtrack(end);
		
	}
	
	private void backtrack(Coordinate end) {
		Node curr = map[end.getY()][end.getX()];
		while(curr != null) {
			curr.setC('*');
			curr = curr.getParent();
		}
		printMap();
	}
	
	private Boolean isValidNeighbor(Coordinate coor,int i) {
		return coor.getX() + nX[i] > 0 && coor.getX() + nX[i] < SIZE - 1 && 
				coor.getY() + nY[i] > 0 && coor.getY() + nY[i] < SIZE - 1 &&
				map[coor.getY()][coor.getX()].getC() != '#';
	}
	
	private void printMap() {
		for(int i = 0;i<SIZE;i++) {
			for(int j = 0; j<SIZE; j++) {
				System.out.print(map[i][j].getC());
			}
			System.out.println();
		}
	}
	
	private void initMap() {
		for(int i = 0;i<SIZE;i++) {
			for(int j = 0; j < SIZE; j++) {
				if(i == 0 || i == SIZE-1 || j == 0 || j == SIZE-1) {
					map[i][j] = new Node(new Coordinate(i,j), '#');
				}
				else {
					map[i][j] = new Node(new Coordinate(i,j), ' ');
				}
				
			}
		}
		for(int i = 0;i < 18;i++) {
			map[i][4].setC('#');
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
