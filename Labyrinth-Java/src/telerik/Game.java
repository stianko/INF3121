package telerik;

import java.util.Scanner;

public class Game {
	public static void main(String[] args){
		generirane labyrinth = new generirane();
		labyrinth.initializeScoreBoard();
		// will never quit without throwing exception
		while(true){
			labyrinth.initializeMaze();
			// spacing between ands please
			while((labyrinth.playersCurrentColumn!=0)&&(labyrinth.playersCurrentColumn!=6)
					&&(labyrinth.playersCurrentRow!=0)&&(labyrinth.playersCurrentRow!=6)){
				labyrinth.inputCommand();

				//spacing

			}
			System.out.println();
			labyrinth.printMaze();
			// these can be merged
			System.out.println("Congratulations! You escaped in "+labyrinth.playersMovesCount+" moves.");
			System.out.println();

			//spaceing

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your name : ");
			String name = scanner.next();
			Player player = new Player(name,labyrinth.playersMovesCount);
			// function is already boolean
			if(labyrinth.board.addPlayerToChart(player)==true){
				System.out.println("Your score is in top 5!");
				labyrinth.board.printBoard(labyrinth.board.list);
			}
			labyrinth.isExit = false;
			labyrinth.playersCurrentColumn = 3;
			labyrinth.playersCurrentRow = 3;
			labyrinth.playersMovesCount = 0;
		}

		//spacing

	}
}
