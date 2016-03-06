package telerik;

import java.util.Random;
import java.util.Scanner;

// all functions need spacing between them

// should be uppercase. Also should it be GenericLane? Was this class written by a Chinese?
public class generirane {
	public boolean isVisited[][] = new boolean[7][7];
	public char maze[][] = new char[7][7];
	public int playersCurrentRow;
	public int playersCurrentColumn;
	public String command;
	public boolean isExit = false;
	public int playersMovesCount = 0;
	HighScoreBoard board;//private


	void initializeMaze(){
		// second word should be uppercase
		Random randomgenerator = new Random();
		// Generates a new maze until at least one solution is found
		/*  Missing indentation.
			Also for-loops can be moved to a method
		 */
		do{
			for(int row=0;row<7;row++){
				for(int column=0;column<7;column++){
					isVisited[row][column]=false;
					if(randomgenerator.nextInt(2)==1){
						maze[row][column] = 'X';
					}
					else {
						maze[row][column] = '-';
					}
				}
			}
		}
		// function is alread a boolean
		// replace with while(!isSolvable)
		while(isSolvable(3, 3)==false);
		playersCurrentRow = 3;
		playersCurrentColumn = 3;
		//spacing

		maze[playersCurrentRow][playersCurrentColumn] = '*';
		printMaze();
	}
	public void initializeScoreBoard(){
		board = new HighScoreBoard();
	}
	public boolean isSolvable(int row, int col){
		if((row==6)||(col==6)||(row==0)||(col==0)){
			// set isExit = true on return. return isExit = true;
			isExit = true;
			return isExit;
		}
		if((maze[row-1][col]=='-')){
			//function is already boolean
			if((isVisited[row-1][col]==false)) {
				isVisited[row][col] = true;
				isSolvable(row - 1, col);
			}
		}
		/* two ifs can be merged */
		if((maze[row+1][col]=='-')){
			//function is already boolean
			if((isVisited[row+1][col]==false)){
				isVisited[row][col]=true;
				isSolvable(row+1, col);
			}
		}
		/* two ifs can be merged */
		if((maze[row][col-1]=='-')){
			//function is already boolean
			if((isVisited[row][col-1]==false)) {
				isVisited[row][col] = true;
				isSolvable(row, col - 1);
			}
		}
		/* two ifs can be merged */
		if((maze[row][col+1]=='-')){
			//function is already boolean
			if((isVisited[row][col+1]==false)) {
				isVisited[row][col] = true;
				isSolvable(row, col + 1);
			}
		}
		return isExit;
	}
	void printMaze(){
		for(int row=0;row<7;row++){
			for(int column=0;column<7;column++){
				System.out.print(maze[row][column]+" ");
			}
			//doesn't need to be local
			{
				System.out.println();
			}
		}
	}
	public void inputCommand(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your next move : L(left), " +
				"R(right), U(up), D(down) ");
		command = scanner.next();
		int size = command.length();
		// cyclomatic complexity too high
		// move to function
		if (!command.equals("exit")) {
			if(command.equals("restart")){
				isExit = false;
				initializeMaze();
			}
			else if(command.equals("top")){
				if(board.list.size()>0){
					board.printBoard(board.list);
				}
				else{
					System.out.println("The High score board is empty!");
				}
			}
			else if(size>1){
				System.out.println("Invalid command!");
			}
			else {
				movePlayer(command.charAt(0));
			}
		} else {
			System.out.println("Good bye!");
			System.exit(0);
		}
	}
	// whole function should be split up in subscripts
	public  void movePlayer(char firstLetter){
		if (firstLetter == 'L' || firstLetter == 'l') {
			if (maze[playersCurrentRow][playersCurrentColumn - 1] != 'X') {
				swapCells(playersCurrentRow, playersCurrentRow,
						playersCurrentColumn, playersCurrentColumn - 1);
				// all this is pointless as this variable is global
				{
					playersCurrentColumn--;
					{
						{
							{
								playersMovesCount++;
							}
						}
					}
				}
			} else {
				System.out.println("Invalid move!");
				printMaze();
			}
		} else if (firstLetter == 'R' || firstLetter == 'r') {
			if (maze[playersCurrentRow][playersCurrentColumn + 1] != 'X') {
				swapCells(playersCurrentRow, playersCurrentRow,
						playersCurrentColumn, playersCurrentColumn + 1);
				System.out.println();
				// all this is pointless as this variable is global
				{
					{
						printMaze();
						{
							{
								playersCurrentColumn++;
								playersMovesCount++;
							}
						}
					}
				}
			} else {
				System.out.println("Invalid move!");
				printMaze();
			}
		} else if (firstLetter == 'U' || firstLetter == 'u') {
			if (maze[playersCurrentRow - 1][playersCurrentColumn] != 'X') {
				swapCells(playersCurrentRow, playersCurrentRow - 1,
						playersCurrentColumn, playersCurrentColumn);
				{
					{
						{
							{
								playersCurrentRow--;
								playersMovesCount++;
							}
						}
					}
				}
			} else {
				System.out.println("Invalid move!");
				printMaze();
			}
		} else if (firstLetter == 'D' || firstLetter == 'd') {
			if (maze[playersCurrentRow + 1][playersCurrentColumn] != 'X') {
				swapCells(playersCurrentRow, playersCurrentRow + 1,
						playersCurrentColumn, playersCurrentColumn);
				{
					playersCurrentRow++;
					{
						playersMovesCount++;
					}
				}
			} else {
				System.out.println("Invalid move!");
				printMaze();
			}
		} else {
			System.out.println("Invalid command!");
		}
	}


	void swapCells(int currentRow, int newRow, int currentColumn, int newColumn){
		// pointless as its always true
		boolean evaluate=true;//evaluate()
		if(evaluate) {
			char previousCell = maze[currentRow][currentColumn];
			maze[currentRow][currentColumn] = maze[newRow][newColumn];
			maze[newRow][newColumn] = previousCell;
			System.out.println();
			printMaze();
		}
	}


}