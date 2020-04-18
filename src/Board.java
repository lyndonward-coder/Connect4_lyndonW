public class Board {

    int size = 8;
     public String[][] grid = new String[size][size];  //make 8x8 2D array of strings
     String boardpiece = "⚪";

    //constructor initializes the whole
    // grid with 0's when created
    public Board() {

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {

                grid[row][col] = boardpiece;

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
        if(grid[i][col].equals(boardpiece)) {
            grid[i][col] = token;
            return true;
        }
    }
        return false;
    }

    public boolean colHasRoom(int col) {
        if(grid[0][col].equals(boardpiece)) {
            return true;
        }
        return false;
    }

    //win check routine with basic "algorithm" for now
    //any move at 0,0 ends game
    public boolean checkWin(String token) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 4; j++) {
                if (grid[i][j].equals(token) && grid[i][j + 1].equals(token) && grid[i][j + 2].equals(token) && grid[i][j + 3].equals(token)) {
                    return true;
                }


            }

        }
        return false;
    }

    public boolean checkWinV(String token) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 7; j++) {
                if (grid[i][j].equals(token) && grid[i+1][j].equals(token) && grid[i+2][j].equals(token) && grid[i+3][j].equals(token)) {
                    return true;
                }


            }

        }
        return false;
    }

    public boolean checkWinD(String token) {
        // Top left down right.
        for (int i = 0; i < 5; i++) {
                if (grid[i][i].equals(token) &&
                        grid[i + 1][i + 1].equals(token) &&
                        grid[i + 2][i + 2].equals(token) &&
                        grid[i + 3][i + 3].equals(token)) {
                    return true;
                }

        }

        // Top right down left.
        for (int i = 0; i < 5; i++) {
            for (int j = 7; j > 2; j--) {
                if (grid[i][j].equals(token) &&
                        grid[i + 1][j - 1].equals(token) &&
                        grid[i + 2][j - 2].equals(token) &&
                        grid[i + 3][j - 3].equals(token)) {
                    return true;
                }
            }
        }

        // Bottom left up right.
        for (int i = 7; i > 5; i--) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j].equals(token) &&
                        grid[i - 1][j + 1].equals(token) &&
                        grid[i - 2][j + 2].equals(token) &&
                        grid[i - 3][j + 3].equals(token)) {
                    return true;
                }
            }
        }

        // Bottom right up left.
        for (int i = 7; i > 5; i--) {
            for (int j = 7; j > 2; j--) {
                if (grid[i][j].equals(token) &&
                        grid[i - 1][j - 1].equals(token) &&
                        grid[i - 2][j - 2].equals(token) &&
                        grid[i - 3][j - 3].equals(token)) {
                    return true;
                }
            }
        }

        return false;
    }





}