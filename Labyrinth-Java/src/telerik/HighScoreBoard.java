package telerik;
import java.util.LinkedList;


public class HighScoreBoard {
	LinkedList<Player> playerList;
	public final int boardSize = 5;

	public HighScoreBoard(){
		playerList = new LinkedList<Player>();
	}
	
	public boolean addPlayerToChart(Player player){
		if(playerList.size() == 0){
			playerList.addFirst(player);
			return true;
		}	
		Player lastPlayer = playerList.getLast();

		if(isLessThanFivePlayers()){
			if(player.movesCount > lastPlayer.movesCount){
				playerList.addLast(player);
				return true;
			}

			int index = 0;
			while(index < playerList.size()){
				lastPlayer = playerList.get(index);
				if(player.movesCount <= lastPlayer.movesCount){
					playerList.add(index,player);
					return true;
				}
				index++;
			}
		}

		if ((playerList.size() == boardSize) && (player.movesCount < lastPlayer.movesCount)) {
			playerList.remove(playerList.size() - 1);
			int index = 0;
			while (index < playerList.size()) {
				lastPlayer = playerList.get(index);
				if (player.movesCount <= lastPlayer.movesCount) {
					playerList.add(index, player);
					return true;
				}
				index++;
			}
		}

		return false;
	}

	private boolean isLessThanFivePlayers(){
		return (playerList.size() < boardSize);
	}

	void printBoard(LinkedList<Player> list){
		System.out.println("Score :");
		for(int i = 0; i < list.size(); i++){
			Player p = list.get(i);
			System.out.print((i + 1) + ". Name - " + p.name + " Escaped in " + p.movesCount + " moves\n");
		}
	}
}
