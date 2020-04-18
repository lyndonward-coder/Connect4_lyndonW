//import the Scanner class used for user input
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        //make instances
        Human Lyndon = new Human("Lyndon", "\uD83D\uDD35");
        Computer c = new Computer("\uD83D\uDD34");
        Scanner sc = new Scanner(System.in);
        Board b = new Board();


        //game loop - alternate moves
        while (!b.checkWin(c.token) && !b.checkWinV(c.token) &&!b.checkWinD(c.token) && !b.checkWin(Lyndon.token) && !b.checkWinV(Lyndon.token) && !b.checkWinD(Lyndon.token)) {

            //set up vars
            boolean legalRow = false;
            boolean legalCol = false;
//            int moveRow = -1;
            int moveCol = -1;

            //human move: validate input and move
            while(!legalCol) {

                System.out.println("Enter col to move:");

                //hasNextInt will return true if user input is an int
                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt()-1;
                    legalCol = true;

                    if(moveCol > 8) {
                        System.out.println("Enter a legal col!");
                        legalCol = false;
                        sc.next();
                    }

                    if(moveCol < 8 && !b.colHasRoom(moveCol)){
                        System.out.println("Column is Full");
                        legalCol = false;
                        sc.next();
                    }
                }else {
                    System.out.println("Enter a legal col!");
                    sc.next();  //very important, resets the input from the "bad" one
                }

                if (legalCol) {
                    b.makeMove(moveCol, Lyndon.token);
                }
            }

            //computer move
            int[] cMove = c.determineMove();
            b.makeMove(cMove[0], c.token);

            //all done moving, display and repeat
            b.printBoard();

        }
        if (b.checkWin(c.token) || b.checkWinV(c.token) || b.checkWinD(c.token)) {
            System.out.print("Game Over! You Lost! Play Again!");

        }else{
            System.out.print("Game Over! You Win! Play Again!");
        }
    }
}