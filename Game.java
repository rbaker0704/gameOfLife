//Game model for Game of Life implementation

public class Game {

	private boolean[][] currentGen;
	private boolean[][] nextGen;
	private int gen; //Generation counter
	private int rows;
	private int cols;
	private boolean paused;
	
	public Game(int size, int height, int width) {
		rows = height/size;
		cols = width/size;
		
		currentGen = new boolean[rows][cols];
		nextGen = new boolean[rows][cols];
	}
	
	public void initialize() {
		paused = true;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				currentGen[i][j] = false;
			}
		}
		gen = 1;
	}

	public void start() {
		paused = false;
		calculateNextGen();
	}
	
	public void pause() {
		paused = true;
	}
	
	private void calculateNextGen() {
		
		for(int i = 0; i < currentGen.length; i++) {
			for(int j = 0; j < currentGen[i].length; j++) {
				nextGen[i][j] = persist(i,j);
			}
		}
		switchGen();
	}
	
	//Method to calculate, based on game of life rules, whether a cell survives into the next generation.
	private boolean persist(int row, int col) {
		
		int neighbors = 0;
		if(row-1 >= 0 && col-1 >=0 && currentGen[row-1][col-1]) {  //NW
			neighbors++;
		}
		if(row-1 >= 0 && currentGen[row-1][col]) {  	           //N
			neighbors++;
		}
		if(row-1 >= 0 && col+1 < cols && currentGen[row-1][col+1]) { //NE
			neighbors++;
		}
		if(col+1 < cols && currentGen[row][col+1]) { 		   //E
			neighbors++;
		}
		if(row+1 < rows && col+1 < cols && currentGen[row+1][col+1]) { //SE
			neighbors++;
		}
		if(row+1 < rows && currentGen[row+1][col]) {		   //S
			neighbors++;
		}
		if(row+1 < rows && col-1 >= 0 && currentGen[row+1][col-1] ) {//SW
			neighbors++;
		}
		if(col-1 >= 0 && currentGen[row][col-1]) {		   //W
			neighbors++;
		}
	
		if(currentGen[row][col] && (neighbors == 2 || neighbors == 3)) {
			return true;
		}
		else if(currentGen[row][col] == false && neighbors == 3) {
			return true;
		}
		return false;
	}
	
	private void switchGen() {
		for(int i = 0; i < currentGen.length; i++) {
			for(int j = 0; j < currentGen[i].length; j++) {
				currentGen[i][j] = nextGen[i][j];
			}
		}
		gen++;
	}
	
	public void printGen() { //Method for console output
		for(int i = 0; i < currentGen.length; i++) {
			for(int j = 0; j < currentGen[i].length; j++) {
				if(currentGen[i][j]) {
					System.out.print("0");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public void create(int row, int col) { //Method for brining a cell to life when it is clicked
		currentGen[row][col] = true;
	}
	
	public boolean getCellState(int row, int col) {
		return currentGen[row][col];
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	//Currently unimplemented method for generating a pre-made structure on click
	public void addPulsar() { //Creates a Pulsar, a period 3 oscillator, in the NW corner of the game field
		currentGen[1][3] = true;
		currentGen[1][4] = true;
		currentGen[1][5] = true;
		
		currentGen[1][9] = true;
		currentGen[1][10] = true;
		currentGen[1][11] = true;
		
		currentGen[3][1] = true;
		currentGen[4][1] = true;
		currentGen[5][1] = true;
		
		currentGen[3][6] = true;
		currentGen[4][6] = true;
		currentGen[5][6] = true;
		
		currentGen[3][8] = true;
		currentGen[4][8] = true;
		currentGen[5][8] = true;
		
		currentGen[3][13] = true;
		currentGen[4][13] = true;
		currentGen[5][13] = true;
		
		currentGen[6][3] = true;
		currentGen[6][4] = true;
		currentGen[6][5] = true;
		
		currentGen[6][9] = true;
		currentGen[6][10] = true;
		currentGen[6][11] = true;
		
		currentGen[8][3] = true;
		currentGen[8][4] = true;
		currentGen[8][5] = true;
		
		currentGen[8][9] = true;
		currentGen[8][10] = true;
		currentGen[8][11] = true;
		
		currentGen[9][1] = true;
		currentGen[10][1] = true;
		currentGen[11][1] = true;
		
		currentGen[9][6] = true;
		currentGen[10][6] = true;
		currentGen[11][6] = true;
		
		currentGen[9][8] = true;
		currentGen[10][8] = true;
		currentGen[11][8] = true;
		
		currentGen[9][13] = true;
		currentGen[10][13] = true;
		currentGen[11][13] = true;
		
		currentGen[13][3] = true;
		currentGen[13][4] = true;
		currentGen[13][5] = true;
		
		currentGen[13][9] = true;
		currentGen[13][10] = true;
		currentGen[13][11] = true;

	}
				
		
}
	
