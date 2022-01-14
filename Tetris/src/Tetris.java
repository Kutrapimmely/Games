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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Tetris {

    public static int playfield[][];
    public static CodeDraw myDraw;
    public static int currentBlock;
    public static int currentRotate;
    public static int currentBlockPosition[][];

    public static void drawPlayfield() {
        myDraw.setColor(Color.BLUE);
        for (int i = 1; i < playfield.length; i++) {
            for (int j = 0; j < playfield[i].length; j++) {
                if (playfield[i][j] == 1) {
                    myDraw.setColor(Color.BLUE);
                    myDraw.fillSquare(j * 40, i * 40, 40);
                } else if (playfield[i][j] == 2) {
                    myDraw.setColor(Color.RED);
                    myDraw.fillSquare(j * 40, i * 40, 40);
                }
            }
        }

        myDraw.setColor(Color.BLACK);
        for (int i = 0; i < playfield.length - 1; i++) {
            myDraw.drawLine(0, i * 40, 400, i * 40);

        }
        for (int i = 0; i < playfield[0].length; i++) {
            myDraw.drawLine(i * 40, 0, i * 40, 800);
        }

        myDraw.show();
    }

    public static boolean checkIfBlockReachedBottom() {

        int x = 0;
        int y = 0;
        LinkedList<Integer> list = getPositionFromCurrentBlock();

        while(!(list.isEmpty())){
            y = list.pop();
            x = list.pop();
            if(x == playfield.length - 2 || playfield[x + 1][y] == 1){
                return true;
            }
        }

        return false;
    }
    public static LinkedList<Integer> getPositionFromCurrentBlock(){
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < playfield.length; i++) {
            for (int j = 0; j < playfield[i].length; j++) {
                if(playfield[i][j] == 2){
                    list.push(i);
                    list.push(j);
                }
            }
        }
        return list;
    }

    public static void rotateBlock(int inputAsASCII) {

    }

    public static int genNextBlock() {
        return (int) (Math.random() * 7);
    }

    public static void putBlockIntoPlayField() {
        currentBlock = genNextBlock();

        switch (currentBlock) {
            case 0:                                                     //----
                playfield[0][4] = 2;
                playfield[0][5] = 2;
                playfield[0][6] = 2;
                playfield[0][7] = 2;
                break;
            case 1:
                playfield[1][3] = 2;                 //-
                playfield[1][4] = 2;                 //---
                playfield[1][5] = 2;
                playfield[0][3] = 2;
                break;
            case 2:
                playfield[1][3] = 2;                 //  -
                playfield[1][4] = 2;                 //---
                playfield[1][5] = 2;
                playfield[0][5] = 2;
                break;
            case 3:
                playfield[1][3] = 2;                 //--
                playfield[1][4] = 2;                 //--
                playfield[0][3] = 2;
                playfield[0][4] = 2;
                break;
            case 4:
                playfield[1][3] = 2;                 // --
                playfield[1][4] = 2;                 //--
                playfield[0][4] = 2;
                playfield[0][5] = 2;
                break;
            case 5:
                playfield[1][4] = 2;                 //--
                playfield[1][5] = 2;                 // --
                playfield[0][3] = 2;
                playfield[0][4] = 2;
                break;
            case 6:
                playfield[1][3] = 2;                 // -
                playfield[1][4] = 2;                 //---
                playfield[0][5] = 2;
                playfield[0][4] = 2;
                break;
        }
    }

    public static int checkIfRowsFull() {

        for (int i = 0; i < playfield.length; i++) {
            int help = 0;
            for (int j = 0; j < playfield[i].length; j++) {
                if (playfield[i][j] == 1) {
                    help++;
                }
            }
            if (help == 10) {
                return i;
            }
        }
        return -1;
    }
    public static void makeBlockSolid(){

        if(checkIfBlockReachedBottom() == true){
            int x = 0;
            int y = 0;
            LinkedList<Integer> list = getPositionFromCurrentBlock();

            while(!(list.isEmpty())){
                y = list.pop();
                x = list.pop();
                playfield[x][y] = 1;
            }
            Tetris.putBlockIntoPlayField();
        }
    }

    public static void dropRow(int row) {
        playfield[row] = new int[10];
        int temp[];
        for (int i = row; i < playfield.length - 2; i++) {
            temp = playfield[i + 1].clone();
            playfield[i] = temp;
        }
    }

    public static boolean checkIfGameOver() {
        if (IntStream.of(playfield[1]).anyMatch(x -> x == 1)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        playfield = new int[21][10];
        myDraw = new CodeDraw(400, 800);
        playfield[1][0] = 2;
        playfield[1][1] = 2;
        playfield[1][2] = 2;
        playfield[1][3] = 2;


        playfield[0][0] = 1;
        playfield[19][4] = 1;
        playfield[19][5] = 1;
        playfield[19][6] = 1;
        playfield[19][7] = 1;
        playfield[19][8] = 1;
        playfield[19][9] = 1;

        drawPlayfield();
        DropBlock dropBlock = new DropBlock();

        dropBlock.start();

    }

}
