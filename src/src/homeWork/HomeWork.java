package src.homeWork;
import java.util.Scanner;

class TicTacToe {
    static char[][] table;

    public TicTacToe() {
        table = new char[3][3];
        rateTable();
    }

    public void rateTable() {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                table[i][j] = ' ';
            }

        }
    }

    public static void DisplayOurTable() {
        System.out.println("-------------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " | ");

            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    public static void whereToPutMark(int row, int colum, char mark){

        if(row >= 0 && row <= 2 && colum >= 0 && colum <= 2){
            table[row][colum] = mark;
        }
        else {
            System.out.println("Wrong position");
        }
    }
    static boolean checkingColumWinner(){

        for (int j=0; j<=2; j++){
            if (table[0][j] !=' ' && table[0][j] == table[1][j] && table[1][j]==table[2][j]){
                return true;
            }
        }
        return false;
    }
    static boolean checkingRawWinner(){

        for(int i = 0; i <= 2; i++){
            if (table[i][0] !=' ' && table[i][0] == table[i][1] && table[i][1] == table[i][2]){
                return true;
            }
        }
        return false;
    }
    static boolean winner(){

        if(table[0][0] !=' ' && table [0][0] == table[1][1] && table[1][1]==table[2][2] ||
                table[0][2] !=' ' && table[0][2] ==table[1][1] && table[1][1] ==table[2][0]){
            return true;
        }
        else {
            return false;
        }
    }
}

class Players{
    String name;
    char mark;
    public Players(String name, char mark){
        this.name= name;
        this.mark = mark;
    }
    public void moving() {
        Scanner scan = new Scanner(System.in);
        int colums;
        int rows;
        do {
            System.out.println("Enter symbol for rows and colum");
            rows = scan.nextInt();
            colums = scan.nextInt();

        } while (!ourMovingIsRight(rows, colums));

        TicTacToe.whereToPutMark(rows, colums, mark);


    }
    public boolean ourMovingIsRight(int row, int colum){
        if (row >= 0 && row <= 2 && colum >=0 && colum <= 2){
            if(TicTacToe.table[row][colum] == ' '){
                return true;
            }
        }
        return false;
    }
}

public class HomeWork {
    public static void main(String[] args) {

        TicTacToe ttt = new TicTacToe();

        Players player1 = new Players("Aaa", 'x');
        Players player2 = new Players("Bbb", 'o');

        Players currentPlayer;
        currentPlayer = player1;
        while (true) {
            System.out.println(currentPlayer.name + " has turn");
            currentPlayer.moving();
            TicTacToe.DisplayOurTable();

            if (TicTacToe.checkingColumWinner() || TicTacToe.checkingRawWinner() || TicTacToe.winner()) {
                System.out.println(currentPlayer.name + " won the game");
                break;
            } else {
                if(currentPlayer == player1) {
                    currentPlayer = player2;
                }
                else {
                    currentPlayer = player1;
                }
            }
        }
        
    }
}