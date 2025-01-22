import java.util.Scanner;

// Instructions
// Simulate a movie theater that helps users to book and reserve seats.
// reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
// cancel seats
// retrieve initial seating charting

public class MovieTheatre {
    String[][] theatreSeats = new String[6][6];

    public MovieTheatre() {
        for (int row = 0; row < theatreSeats.length; row++) {
            for (int col = 0; col < theatreSeats[0].length; col++) {
                theatreSeats[row][col] = "A"; // A = Available
            }
        }
    }

    public void displaySeats() {
        for (int row = 0; row < theatreSeats.length; row++) {
            for (int col = 0; col < theatreSeats[0].length; col++) {
                if (col == 2) {
                    System.out.print(theatreSeats[row][col] + " | ");
                } else {
                    System.out.print(theatreSeats[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public void claimSeat(int row, int col) {
        if (theatreSeats[row - 1][col - 1].equals("R")) { // R = Reserved
            System.out.println();
            System.out.println("This seat has already been reserved. Available seats are listed as 'A'.");
        } else {
            theatreSeats[row - 1][col - 1] = "R"; // Reserved
            System.out.println("Seat Reserved ('R').");
        }
    }

    // Start of program
    public static void main(String[] args) {
        MovieTheatre seatSelector = new MovieTheatre();
        System.out.println();
        System.out.println("Welcome to the movie theatre seat selector");
        System.out.println();

        while (true) {
            seatSelector.displaySeats();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.println("View the seating chart above and select a row number followed by a column number to reserve your seat.");

            try {
                System.out.println("Enter the row number (1-6): ");
                int row = scanner.nextInt();
                System.out.println("Enter the column number (1-6): ");
                int col = scanner.nextInt();

                seatSelector.claimSeat(row, col);
                System.out.println();
                seatSelector.displaySeats();
                System.out.println();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You have entered an invalid row or column number. Please try again");
            }

            System.out.println("Do you want to reserve another seat? (Y/N): ");
            String answer = scanner.next();
            System.out.println();
            if (answer.equals("N")) {
                System.out.println();
                break;
            }
        }
        System.out.println("Thank you. Have a good day!");
    }
}
