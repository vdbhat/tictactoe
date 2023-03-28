import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
      // Initialize the board using a 2D Array
       char[][] game_board = {{' ', ' ', ' '},
                              {' ', ' ', ' '}, 
                              {' ', ' ', ' '}};
      // Initialize scanner object to pass in user input, as well as first instance of the game board
      Scanner scanner = new Scanner(System.in);
      printBoard(game_board);
      // Loop to get both player and cpu turns while checking if any win conditions are met
      while (true) {
         player_turn(game_board, scanner);
         if (game_over_conditions(game_board)){
            break;
         }
         cpu_turn(game_board);
         if (game_over_conditions(game_board)){
            break;
         }
      }
      // Close the scanner upon exiting the game
      scanner.close();
   }

   private static boolean game_over_conditions(char[][] game_board) {
      // Check win conditions for both player and cpu
      if (check_player_and_cpu(game_board, 'X')){
         System.out.println("Player X won!");
         return true;
      } else if (check_player_and_cpu(game_board, 'O')){
         System.out.println("Computer won.");
         return true;
      }
      // Check for ties
      for (int i = 0; i < game_board.length; i++){
         for (int j = 0; j < game_board.length; j++){
            if (game_board[i][j] == ' '){
               return false;
            }
         }
      }
      System.out.println("The game ended in a tie!");
      return true;
   }

   // Helper function to check for wins for both player and cpu, for all 8 different win conditions
   private static boolean check_player_and_cpu(char[][] game_board, char symbol) {
      if (Arrays.equals(game_board[0], new char[] {symbol, symbol, symbol})){
         return true;
      } else if (Arrays.equals(game_board[1], new char[] {symbol, symbol, symbol})){
         return true;
      } else if (Arrays.equals(game_board[2], new char[] {symbol, symbol, symbol})){
         return true;
      } else if ((game_board[0][0] == symbol) && (game_board[1][0] == symbol) && (game_board[2][0] == symbol)){
         return true;
      } else if ((game_board[0][1] == symbol) && (game_board[1][1] == symbol) && (game_board[2][1] == symbol)){
         return true;
      } else if ((game_board[0][2] == symbol) && (game_board[1][2] == symbol) && (game_board[2][2] == symbol)){
         return true;
      } else if ((game_board[0][0] == symbol) && (game_board[1][1] == symbol) && (game_board[2][2] == symbol)){
         return true;
      } else if ((game_board[0][2] == symbol) && (game_board[1][1] == symbol) && (game_board[2][0] == symbol)){
         return true;
      } else{
         return false;
      }
   }

   private static void cpu_turn(char[][] game_board) {
      // Make the cpu choose a random position until the position chosen is a valid space
      Random random_num = new Random();
      int cpu_move;
      while (true) {
         cpu_move = random_num.nextInt(10);
         if (valid_move(game_board, cpu_move)) {
            break;
         }
      }
      place_move(game_board, Integer.toString(cpu_move), 'O');
      System.out.println("Computer chose space " + Integer.toString(cpu_move) + ".");
      printBoard(game_board);
   }

   // Helper function to check if a chosen space is a valid tile on the board
   private static boolean valid_move(char[][] game_board, int position) {
      switch(position) {
         case 1:
            return game_board[0][0] == ' ';
         case 2:
            return game_board[0][1] == ' ';
         case 3:
            return game_board[0][2] == ' ';
         case 4:
            return game_board[1][0] == ' ';
         case 5:
            return game_board[1][1] == ' ';
         case 6:
            return game_board[1][2] == ' ';
         case 7:
            return game_board[2][0] == ' ';
         case 8:
            return game_board[2][1] == ' ';
         case 9:
            return game_board[2][2] == ' ';
         default:
             return false;
         }
   }

   private static void player_turn(char[][] game_board, Scanner scanner) {
      String player_move;
      // Loop until player has chosen a valid spot on the board
      while (true) {
         System.out.println("Please select your move on the board (1-9): ");
         player_move = scanner.nextLine();
         // Make sure the user input in a number so no errors occur
         if (!check_for_num(player_move)){
            System.out.println("Please select a valid spot on the board.");
            continue;
         }
         if (valid_move(game_board, Integer.parseInt(player_move))) { 
            break;
         } else {
            System.out.println("Please select a valid spot on the board.");
         }
      }
      place_move(game_board, player_move, 'X');
      printBoard(game_board);
   }

   // Helper function to see if the user input is a number 1-9
   private static boolean check_for_num(String player_move) {
      switch(player_move) {
         case "1":
            return true;
         case "2":
            return true;
         case "3":
            return true;
         case "4":
            return true;
         case "5":
            return true;
         case "6":
            return true;
         case "7":
            return true;
         case "8":
            return true;
         case "9":
            return true;
         default:
            return false;
      }
   }

   // Assigns a space in the 2D Array to a symbol based on whether user or cpu is playing
   private static void place_move(char[][] game_board, String position, char symbol) {
      switch(position) {
         case "1":
            game_board[0][0] = symbol;
            break;
         case "2":
            game_board[0][1] = symbol;
            break;
         case "3":
            game_board[0][2] = symbol;
            break;
         case "4":
            game_board[1][0] = symbol;
            break;
         case "5":
            game_board[1][1] = symbol;
            break;
         case "6":
            game_board[1][2] = symbol;
            break;
         case "7":
            game_board[2][0] = symbol;
            break;
         case "8":
            game_board[2][1] = symbol;
            break;
         case "9":
            game_board[2][2] = symbol;
            break;
         default:
            System.out.println("Please select a valid spot on the board. (1-9)");
      }
   }

   // Prints board with grid pattern
    public static void printBoard(char[][] game_board) {
       System.out.println(game_board[0][0] + "|" + game_board[0][1] + "|" + game_board[0][2]);
       System.out.println("-+-+-");
       System.out.println(game_board[1][0] + "|" + game_board[1][1] + "|" + game_board[1][2]);
       System.out.println("-+-+-");
       System.out.println(game_board[2][0] + "|" + game_board[2][1] + "|" + game_board[2][2]);
      }
}
