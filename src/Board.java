public class Board {

    int size = 8;
    String[][] grid = new String[size][size];  //make 8x8 2D array of strings


    //constructor initializes the whole
    // grid with 0's when created
    public Board() {

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {

                grid[row][col] = "_";

            }
        }

    }

    //printBoard will output a board to the console
    public void printBoard() {
        System.out.println("Updated board:");
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {

                System.out.print(grid[row][col] + " ");

            }
            System.out.print("\n");
        }


    }

//    makes a move on the board - changes a position to "token value"
    public boolean makeMove( int col, String token) {
    for(int i = size-1; i>=0; i--){
        if(grid[i][col].equals("_")) {
            grid[i][col] = token;
            return true;
        }
    }
        return false;
    }


    //win check routine with basic "algorithm" for now
    //any move at 0,0 ends game
    public boolean checkWin() {

        if(grid[0][0] != "_") {
            return true;
        }

        return false;

    }

    public boolean determineWin(String token){
        int count = 0;
        for(int i = 8; i<=0; i--){
            for(int a = 8; i<=0; i--)
            if(grid[i][a] == token){
                count += 1;
            }else if(grid[i][a] != token){
                count = 0;
            }
            if(count == 4){
                return true;
            }
        }
        return false;

    }



}