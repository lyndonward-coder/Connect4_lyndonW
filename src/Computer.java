public class Computer extends Player {

    public Computer(String token) {
        super("Bit Bucket", token);
    }

    //very basic random move algorithm for now
    public int[] determineMove() {
            int col = (int) (Math.random() * 8);

            int[] move = {col};

            return move;

        }

    }


