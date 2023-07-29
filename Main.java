import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        //Scanner S = new Scanner(System.in);
        char[][] Board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printBoard(Board);
        while (true) {
            playUser(Board);
            if (isWinner(Board)) {
                break;
            }
            playComputer(Board);
            if (isWinner(Board)){
                break;
            }

        }
    }

    public static void printBoard(char[][] Board) {
        for (int r = 0; r < Board.length; r++) {
            for (int c = 0; c < Board[0].length; c++) {
                System.out.print(Board[r][c]);
            }
            System.out.println();
        }
    }

    public static void playUser(char[][] Board) {
        System.out.println("Where would you like to play ? Choose from 1 - 9");
        Scanner S = new Scanner(System.in);
        int playInt = S.nextInt();

        while (isValid(Board, playInt)==false) { // اذا ميثود التحقق ليس ترو " يعني الاندكست فيه عنصر قبل ليس فارغ "
            System.out.println(playInt + " is not valid move!");
            playInt = S.nextInt();
            isValid(Board, playInt);

        }
        placeSymbol(Board, playInt, " User ");
    }

    public static void playComputer(char[][] Board) {
        Random random = new Random(); // يختار الارقام عشوائي
        int playInt = random.nextInt(9) + 1;
        while (isValid(Board, playInt)==false) { // false
            playInt = random.nextInt(9) + 1;
            isValid(Board, playInt);
        }
        System.out.println("Computer chose " + playInt);
        placeSymbol(Board, playInt, " Computer ");
    }

    public static void placeSymbol(char[][] Board, int pos, String user) {
        char ch = ' ';
        if (user == " User ") {
            ch = 'X';
            //UserPos.add(pos);
        } else {
            ch = 'O';
            //ComputerPos.add(pos);
        }

        switch (pos) {
            case 1:
                Board[0][0] = ch;
                printBoard(Board);
                break;
            case 2:
                Board[0][2] = ch;
                printBoard(Board);
                break;
            case 3:
                Board[0][4] = ch;
                printBoard(Board);
                break;
            case 4:
                Board[2][0] = ch;
                printBoard(Board);
                break;
            case 5:
                Board[2][2] = ch;
                printBoard(Board);
                break;
            case 6:
                Board[2][4] = ch;
                printBoard(Board);
                break;
            case 7:
                Board[4][0] = ch;
                printBoard(Board);
                break;
            case 8:
                Board[4][2] = ch;
                printBoard(Board);
                break;
            case 9:
                Board[4][4] = ch;
                printBoard(Board);
                break;
            default:
                break;
        }
    }

    public static boolean isValid(char[][] Board, int playInt) { // يتحقق اذا فارغه او لا
        switch (playInt) {
            case 1:
                if (Board[0][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (Board[0][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (Board[0][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (Board[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (Board[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (Board[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (Board[4][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (Board[4][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (Board[4][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;

        }
    }

    public static boolean isWinner(char[][] Board) {
        if (Board[0][0] == 'X' && Board[0][2] == 'X' && Board[0][4] == 'X') {
            System.out.println("You Win! ");
            return true;
        }
        if (Board[0][0] == 'O' && Board[0][2] == 'O' && Board[0][4] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[2][0] == 'X' && Board[2][2] == 'X' && Board[2][4] == 'X') {
            System.out.println("You Win! ");
            return true;
        }
        if (Board[2][0] == 'O' && Board[2][2] == 'O' && Board[2][4] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[4][0] == 'X' && Board[4][2] == 'X' && Board[4][4] == 'X') {
            System.out.println("You Win! ");
            return true;
        }
        if (Board[4][0] == 'O' && Board[4][2] == 'O' && Board[4][4] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][0] == 'X' && Board[2][0] == 'X' && Board[4][0] == 'X') {
            System.out.println("You Win! ");
            return true;
        }
        if (Board[0][0] == 'O' && Board[2][0] == 'O' && Board[4][0] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][2] == 'X' && Board[2][2] == 'X' && Board[4][2] == 'X') {
            System.out.println("You Win! ");
            return true;
        }
        if (Board[0][2] == 'O' && Board[2][2] == 'O' && Board[4][2] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][4] == 'X' && Board[2][4] == 'X' && Board[4][4] == 'X') {
            System.out.println("You Win!");
            return true;
        }
        if (Board[0][4] == 'O' && Board[2][4] == 'O' && Board[4][4] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][0] == 'X' && Board[2][2] == 'X' && Board[4][4] == 'X') {
            System.out.println("You Win!");
            return true;
        }
        if (Board[0][0] == 'O' && Board[2][2] == 'O' && Board[4][4] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][4] == 'X' && Board[2][2] == 'X' && Board[4][0] == 'X') {
            System.out.println("You Win!");
            return true;
        }
        if (Board[0][4] == 'O' && Board[2][2] == 'O' && Board[4][0] == 'O') {
            System.out.println("Ohh, Sory Computer Win!");
            return true;
        }
        if (Board[0][0] != ' ' && Board[0][2] != ' ' && Board[0][4] != ' ' &&
                Board[2][0] != ' ' && Board[2][2] != ' ' && Board[2][4] != ' ' &&
                Board[4][0] != ' ' && Board[4][2] != ' ' && Board[4][4] != ' ') {
            System.out.println("Nobady Won ): ");
            return true;
        }
        return false;
    }
}

