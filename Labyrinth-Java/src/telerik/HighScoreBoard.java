package telerik;

import java.util.LinkedList;

public class HighScoreBoard {
	LinkedList list;//private. Also should this be initialized to type player?
	public final int boardSize = 5;
	public HighScoreBoard(){
		list = new LinkedList();
	}

	public boolean addPlayerToChart(Player player){
		if(list.size()==0){
			// should be caught
			list.addFirst(player);
			return true;
		}
		Player pl = (Player) list.get(list.size()-1);
		if((list.size()>0)&&(list.size()<boardSize)){
			if(player.movesCount>pl.movesCount){
				// should be caught
				list.addLast(player);
				return true;
			}
			int index = 0;
			while(index<list.size()){
				pl = (Player) list.get(index);
				if(player.movesCount<=pl.movesCount){

					//pointless
					{
						// should be caught
						list.add(index,player);
					}
					return true;
				}
				index++;
			}
		}
		// cyclomatic complexity too high
		// merge ifs
		if((list.size()==boardSize)) {
			if((player.movesCount<pl.movesCount)){
				list.remove(list.size() - 1);
				int index = 0;
				while (index < list.size()) {
					pl = (Player) list.get(index);
					if (player.movesCount <= pl.movesCount) {
						list.add(index, player);
//spacing

						return true;
					}
					index++;
				}
			}
		}
		return false;
	}
	void printBoard(LinkedList list){
		System.out.println("Score :");
		for(int i=0;i<list.size();i++){
			Player p = (Player) list.get(i);
			// use s.o.printf to merge three prints
			System.out.print((i+1)+". Name - "+p.name+" ");
			System.out.print("Escaped in "+p.movesCount+" moves");
			System.out.println();
		}
	}
}
