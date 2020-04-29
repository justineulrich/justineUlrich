import java.util.Scanner;
import java.util.Random;

public class mines {
	public static void main(String[] args) {
		Random rand = new Random();
		char [][] visible = new char[5][5];
		char [][] hidden = new char[5][5];
		int r = 0;
		int s = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				visible[i][j] = '_';
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				hidden[i][j] = 'S';
			}
		}
		
		for(int i = 0; i < 5; i++) {
			hidden[rand.nextInt(5)][rand.nextInt(5)] = 'B';
		}
		Recursive(visible, hidden, r, s);
	}

		
	public static int Recursive(char[][] visible, char[][] hidden, int round, int score) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < visible.length; i++) {
			for(int j = 0; j < visible[i].length; j++) {
				System.out.print(visible[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Please enter a row position (0-4):");
		int row = scan.nextInt();
		if(row > 4) {
			System.out.println("Incorrect input, try again");
		}
		System.out.println("Please enter a column position (0-4):");
		int col = scan.nextInt();
		if(col > 4) {
			System.out.println("Incorrect input, try again");
		}
		
		if(hidden[row][col] == 'S') {
			score++;
			round++;
			visible[row][col] = 'S';
			return Recursive(visible, hidden, round, score);
		}
		else {
			for(int i = 0; i < hidden.length; i++) {
				for(int j = 0; j < hidden[i].length; j++) {
					System.out.print(hidden[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("");
			System.out.println("You stepped on a bomb in round " + round + "! Your score was: " + score);
			return 0;
		}
		
	}
}


