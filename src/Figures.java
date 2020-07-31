import java.util.Scanner;

//------------------------------------------------------------------
// Garrett McCue 
// 07/30/20
// SU2-CPSC-501-002
// Programming Fundamentals
// Program 2
//
// This has four static methods, (1) main, (2) printBox, (3) printDiamond
// (4) printX. User inputs size (odd num) of figure and picks a shape 
// (box, diamond or X) from a list of options in the main method. 
// 
//------------------------------------------------------------------
public class Figures {
	static int size;

	public static void main(String[] args) {
		// Assignment header
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Garrett McCue");
		System.out.println("PROGRAMMING ASSIGNMENT 2\n");

		Scanner scan = new Scanner(System.in);

		// prompts user and gets size of shape
		System.out.print("Enter the size of the figure (odd number): ");
		size = scan.nextInt();

		// makes sure the size is an odd number if not it has the user renter the size
		// until it is odd
		while (size % 2 == 0) {
			System.out.println("Invalid figure size - must be an odd number\n");
			System.out.print("Renter the size of the figure: ");
			size = scan.nextInt();
		}

		// infinite loop that can only be broken by choosing option 4. Option 4 breaks
		// the loop because it sets i < 0 and ends the program. Other choices call 
		// the corresponding methods. Choosing a value outside of 1-4 has the user 
		// try again until a proper choice is made.
		// Menu reprints after every iteration allowing the user to exit or choose another shape to print.
		for (int i = 1; i > 0; i++) {
			System.out.println("\nMENU:\n1. Print box\n2. Print diamond\n3. Print X\n4. Quit program");
			System.out.print("\nPlease select and option: ");
			int userChoice = scan.nextInt();

			switch (userChoice) {
			case 1:
				printBox();
				break;
			case 2:
				printDiamond();
				break;
			case 3:
				printX();
				break;
			case 4:
				System.out.println("\nGood Bye!");
				i = -1;
				break;
			default:
				System.out.println("\ninvalid choice... try again");
				break;

			}

		}
		scan.close();
	}

	// method for printing the box shape (size*size)
	public static void printBox() {
		System.out.println();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				System.out.print('X');
			}
			System.out.println("");

		}
	}

	// method for printing diamond (size*size+1)
	public static void printDiamond() {
		System.out.println();

		// dividing the diamond into four quadrants in order to increment each
		// side of the diamond separately
		// top of the diamond includes the +1 row since the rows are odd, but the
		// columns are even so left to right is split down the middle
		int topLeft = ((size + 1) / 2) - 1;
		int topRight = (size + 1) / 2;
		int bottomLeft = 1;
		int bottomRight = size - 1;

		// creates top triangle of diamond
		// starts at point and goes to the widest point
		for (int r = 0; r < ((size + 1) / 2); r++) {
			for (int c = 0; c <= size + 1; c++) {
				// creates top left portion
				if (c == topLeft) {
					System.out.print("X");
					topLeft--;
				// creates top right portion
				// need the break in order to go to the next print line
				} else if (c == topRight) {
					System.out.print("X");
					topRight++;
					break;
				}

				else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
		// bottom of triangle
		// one row smaller than the top
		// X's are printed one place toward the middle than the widest point of the diamond.
		for (int r = 0; r < ((size + 1) / 2) - 1; r++) {
			for (int c = 0; c <= size; c++) {
				if (c == bottomLeft) {
					System.out.print("X");

				} else if (c == bottomRight) {
					System.out.print("X");

				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
			bottomLeft++;
			bottomRight--;
		}

	}

	// method for printing X shape (size*size)
	public static void printX() {
		System.out.println();
		// iterates through each row from top of X to bottom
		for (int r = 0; r < size; r++) {
			// iterates through every column in the current row
			// if the row and column num are the same (starting at 0) an X is printed
			// if the column num is equal to the row num subtracted from
			// the last column "index" or position an X is printed .
			// Otherwise a blank space is printed.
			for (int c = 0; c < (size); c++) {
				if (r == c || c == ((size - 1) - r)) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
			}
			// returns to the next line after each row
			System.out.println();

		}

	}

}
