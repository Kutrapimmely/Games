/*
    Aufgabe 1) Zweidimensionale Arrays und Gameplay - Mastermind
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.textformat.HorizontalAlign;
import codedraw.textformat.TextFormat;
import codedraw.textformat.VerticalAlign;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Tetris {

    public static int playfield[][];
    public static CodeDraw myDraw;
    public static int currentBlockPosition[][];

    public static void drawPlayfield(){
        myDraw.setColor(Color.BLUE);
        for (int i = 1; i < playfield.length; i++) {
            for (int j = 1; j < playfield[i].length; j++) {
                if(playfield[i][j] == 1){
                    myDraw.setColor(Color.BLUE);
                    myDraw.fillSquare(j * 40, i * 40, 40);
                }
                else if(playfield[i][j] == 2){
                    myDraw.setColor(Color.RED);
                    myDraw.fillSquare(j * 40, i * 40, 40);
                }
            }
        }

        myDraw.setColor(Color.BLACK);
        for (int i = 0; i < playfield.length - 1; i++) {
            myDraw.drawLine(0,i * 40, 400, i * 40);

        }
        for (int i = 0; i < playfield[0].length; i++) {
            myDraw.drawLine(i * 40,0, i * 40, 800);
        }

        myDraw.show();
    }

    public static boolean checkIfBlockReachedBottom(){
        if(currentBlockPosition[0][0] == 0 || playfield[currentBlockPosition[0][0] - 1][currentBlockPosition[0][1]] == 1){
            return true;
        }
        if(currentBlockPosition[1][0] == 0 || playfield[currentBlockPosition[1][0] - 1][currentBlockPosition[1][1]] == 1){
            return true;
        }
        if(currentBlockPosition[2][0] == 0 || playfield[currentBlockPosition[2][0] - 1][currentBlockPosition[2][1]] == 1){
            return true;
        }
        if(currentBlockPosition[3][0] == 0 || playfield[currentBlockPosition[3][0] - 1][currentBlockPosition[3][1]] == 1){
            return true;
        }
        return false;
    }

    public static int genNextBlock(){
        return (int)Math.random() % 7;
    }
    public static void putBlockIntoPlayField(){
        switch(genNextBlock()){
            case 0:                                                     //----
                playfield[playfield.length - 1][4] = 2;
                playfield[playfield.length - 1][5] = 2;
                playfield[playfield.length - 1][6] = 2;
                playfield[playfield.length - 1][7] = 2;
                break;
            case 1:
                playfield[playfield.length - 2][3] = 2;                 //-
                playfield[playfield.length - 2][4] = 2;                 //---
                playfield[playfield.length - 2][5] = 2;
                playfield[playfield.length - 1][3] = 2;
                break;
            case 2:
                playfield[playfield.length - 2][3] = 2;                 //  -
                playfield[playfield.length - 2][4] = 2;                 //---
                playfield[playfield.length - 2][5] = 2;
                playfield[playfield.length - 1][5] = 2;
                break;
            case 3:
                playfield[playfield.length - 2][3] = 2;                 //--
                playfield[playfield.length - 2][4] = 2;                 //--
                playfield[playfield.length - 1][3] = 2;
                playfield[playfield.length - 1][4] = 2;
                break;
            case 4:
                playfield[playfield.length - 2][3] = 2;                 // --
                playfield[playfield.length - 2][4] = 2;                 //--
                playfield[playfield.length - 1][4] = 2;
                playfield[playfield.length - 1][5] = 2;
                break;
            case 5:
                playfield[playfield.length - 2][4] = 2;                 //--
                playfield[playfield.length - 2][5] = 2;                 // --
                playfield[playfield.length - 1][3] = 2;
                playfield[playfield.length - 1][4] = 2;
                break;
            case 6:
                playfield[playfield.length - 2][3] = 2;                 // -
                playfield[playfield.length - 2][4] = 2;                 //---
                playfield[playfield.length - 1][5] = 2;
                playfield[playfield.length - 1][4] = 2;
                break;
        }
    }

    public static int checkIfRowsFull(){

        for (int i = 0; i < playfield.length; i++) {
            int help = 0;
            for (int j = 0; j < playfield[i].length; j++) {
                if(playfield[i][j] == 1){
                    help++;
                }
            }
            if(help == 10){
                return i;
            }
        }
        return -1;
    }

    public static void dropRow(int row){
        playfield[row] = new int[10];
        int temp[];
        for (int i = row; i < playfield.length - 2; i++) {
            temp = playfield[i + 1].clone();
            playfield[i] = temp;
        }
    }

    public static boolean checkIfGameOver(){
        if( IntStream.of(playfield[playfield.length- 1]).anyMatch(x -> x == 1)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        playfield = new int[21][10];
        myDraw = new CodeDraw(400, 800);
        playfield[0][0] = 1;
        playfield[19][1] = 1;
        playfield[19][2] = 1;
        playfield[19][3] = 1;
        drawPlayfield();

    }

}



