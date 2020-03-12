//import the Scanner class used for user input
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        //make instances
        Human Lyndon = new Human("Lyndon", "X");
        Computer c = new Computer("Z");
        Scanner sc =  new Scanner(System.in);
        Board b = new Board();


        //game loop - alternate moves
        while(!b.checkWin()) {

            //set up vars
            boolean legalRow = false;
            boolean legalCol = false;
//            int moveRow = -1;
            int moveCol = -1;

            //human move: validate input and move
            while(!legalCol) {

                //row move
//                System.out.println("Enter row to move:");
//                //hasNextInt will return true if user input is an int
//                if(sc.hasNextInt()) {
//                    moveRow = sc.nextInt();
//                    legalRow = true;
//                }
//                else {
//                    System.out.println("Enter a legal row!");
//                    sc.next();  //very important, resets the input from the "bad" one
//                }

                //col move
                System.out.println("Enter col to move:");
                //hasNextInt will return true if user input is an int
                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt();
                    legalCol = true;
                }
                else {
                    System.out.println("Enter a legal col!");
                    sc.next();  //very important, resets the input from the "bad" one
                }

                if(legalCol) {
                    b.makeMove(moveCol,Lyndon.token);
                }
            }

            //computer move
            int[] cMove = c.determineMove();
            b.makeMove(cMove[0],c.token);

            //all done moving, display and repeat
            b.printBoard();

        }

        System.out.print("End of Game");

    }

}