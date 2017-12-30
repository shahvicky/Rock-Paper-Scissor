import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	enum HandSign {
		ROCK, PAPER, SCISSOR
	}

	public static void main(String[] args) throws InputMismatchException{
		Scanner scan = new Scanner(System.in);
		
		boolean gameOver = false;
		int playerScore=0, compScore =0, tie=0;
		HandSign compMove, playerMove = HandSign.PAPER;
		System.out.println("r for ROCK");
		System.out.println("p for PAPER");
		System.out.println("s for SCISSOR");
		System.out.println("q to QUIT");
		
		while(!gameOver) {
			
			try {
				System.out.println("Please enter your choice:");
				char playerInput = scan.next().charAt(0);
				if(playerInput == 'q') {
					gameOver= true;
				}else{
					playerMove = getPlayerMove(playerInput);
				}
				
				if(!gameOver){
					compMove = getComputerMove();
					
					//score calculation part
					
					if(compMove == playerMove){
						System.out.println("It's a tie");
						tie++;
					} else if(compMove==HandSign.ROCK && playerMove==HandSign.SCISSOR){
						compScore++;
						System.out.println("Computer wins this move");
					} else if(compMove==HandSign.PAPER && playerMove==HandSign.ROCK){
						compScore++;
						System.out.println("Computer wins this move");
					} else if(compMove==HandSign.SCISSOR && playerMove==HandSign.PAPER){
						compScore++;
						System.out.println("Computer wins this move");
					} else {
						playerScore++;
						System.out.println("You win this move");
					}	
				}
			}
			catch(Exception e) {
				System.out.println("Invalid Character:" + e.getMessage());
			}
			
			
		}
		scan.close();
		System.out.println();
		System.out.println("***********FINAL SCORE************");
		System.out.println("Computer's Score: "+compScore);
		System.out.println("Player's Score: "+playerScore);
		System.out.println("Ties: "+ tie);
		if(playerScore == compScore){
			System.out.println("The GAME IS A TIE");
		} else {
			System.out.println(playerScore>compScore ? "YOU WIN!!!!" : "COMPUTER WINS!!!");
		}
		
		// final score printing
		
		
	}
	
	
	static HandSign getPlayerMove(char move) throws InputMismatchException{
		HandSign playerMove = null;
		switch(move) {
		
		case 'r':
			playerMove= HandSign.ROCK;
			break;		
		case 'p':
			playerMove = HandSign.PAPER;
			break;
		case 's':
			playerMove = HandSign.SCISSOR;
			break;
		default:
			throw new InputMismatchException("Please enter a valid character");
		}
		System.out.println("YOUR MOVE: "+playerMove);
		return playerMove;
	}
	
	static HandSign getComputerMove(){
		HandSign computerMove = null;
		Random random = new Random();
		int compInput = random.nextInt(3);
		switch (compInput) {
		case 0:
			computerMove = HandSign.SCISSOR;
			break;
		case 1:
			computerMove = HandSign.ROCK;
			break;
		case 2:
			computerMove = HandSign.PAPER;
			break;
		}
		System.out.println("COMPUTER'S MOVE: "+computerMove);
		return computerMove;
	}
	
	

}
