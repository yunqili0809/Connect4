package app;

import java.util.Scanner;

public class Launcher {

	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("----- WELCOME -----");
		System.out.println("------- TO --------");
		System.out.println("---- CONNECT 4 ----");
		System.out.println("...press Enter to play");
		// takes an input and ignores it
		s.nextLine();
		Board game = new Board();
		// do guarentees this will run at least once
		do {
			game.reset();
			gameLoop(game);
			System.out.print("Do you want to play again? (y/n): ");
			s.nextLine();
		// while makes the do-while into a loop
		} while(s.nextLine().equals("y"));

	}
	
	public static void gameLoop(Board game) {
		
		boolean player1 = true;
		while(true) {
			System.out.println(game);
			if(player1) {
				System.out.print("Player 1, select column:  ");
				int choice = s.nextInt();
				while(!game.dropPiece('x', choice)) {
					System.out.print("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('x')) {
					System.out.println("!! Player 1 wins!!");
					System.out.println(game);
					System.out.println("!! Player 1 wins!!");
					break;
				}
				// check if the column is available
				// add player1's 'x' to the column
			}else {
				System.out.print("Player 2, select column:  ");
				int choice = s.nextInt();
				while(!game.dropPiece('o', choice)) {
					System.out.print("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('o')) {
					System.out.println("!! Player 2 wins!!");
					System.out.println(game);
					System.out.println("!! Player 2 wins!!");
					break;
				}
				
			}
			if(game.tieGame()) {
				System.out.println("Tie game. Everyone loses.");
				break;
			}
			// change whose turn it is
			player1 = !player1;
		}
	}

}