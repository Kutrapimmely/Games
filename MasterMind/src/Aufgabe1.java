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
import java.lang.management.PlatformLoggingMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe1 {
    // global constants
    private static final int NUMBER_OF_TURNS = 10;
    private static final int CODE_LENGTH = 4;
    private static final int NUMBER_OF_COLUMNS = CODE_LENGTH * 2 + 1;
    private static final Color[] COLORS = new Color[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.DARK_GRAY, Color.RED, Color.PINK, Color.YELLOW};

    // global variables
    private static int[][] playField = null;
    private static int[][] tips = null;
    private static int turn = 0;
    private static int pin = 0;
    private static int[] solution = null;

    // initializes all global variables for the game
    private static void initGame() {
        playField = new int[NUMBER_OF_TURNS][CODE_LENGTH];
        tips = new int[NUMBER_OF_TURNS][CODE_LENGTH]; // 1 == red; 2 == white
        turn = 0;
        pin = 0;
        solution = generateCode();
    }

    // generates array with length CODE_LENGTH and random numbers from 1 to COLORS.length
    private static int[] generateCode() {
        int arr[] = new int[CODE_LENGTH];
        for (int i = 0; arr[arr.length - 1] == 0; i++) {
            int counter = 0;
            int color = (int) (Math.random() * 9) + 1;
            for (int j = 0; j < arr.length; j++) {
                if (color == arr[j]) {
                    counter++;
                }
            }
            if (counter == 0) {
                arr[i] = color;
            } else {
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    // calculates red and white tip pins
    private static void updateTips() {

        int counter = 0;
        for (int i = 0; i < playField[turn].length; i++) {
            for (int j = 0; j < solution.length; j++) {
                if (i == j && playField[turn][i] == solution[j]) {
                    tips[turn][counter] = 1;
                    counter++;
                }
            }
        }

        int counter2 = 0;
        for (int i = 0; i < playField[turn].length; i++) {
            for (int j = 0; j < solution.length; j++) {
                if (playField[turn][i] == solution[j]) {
                    counter2++;
                    if (counter2 > counter) {
                        tips[turn][counter2 - 1] = 2;
                    }
                }
            }
        }
    }

    // draws game to screen
    private static void drawGame(CodeDraw myDrawObj) {
        myDrawObj.setColor(Color.GRAY);
        myDrawObj.fillRectangle(0, 0, 800, 800);

        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            for (int j = 0; j < CODE_LENGTH; j++) {
                if (playField[i][j] == 0) {
                    myDrawObj.setColor(Color.WHITE);
                } else {
                    myDrawObj.setColor(COLORS[playField[i][j] - 1]);
                }
                myDrawObj.fillCircle(45 + 45 * j * 2, 760 - 40 * i * 2, 40);
            }
        }

        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            for (int j = 0; j < CODE_LENGTH; j++) {
                if (tips[i][j] == 1) {
                    myDrawObj.setColor(Color.RED);
                    myDrawObj.fillCircle(480 + j * 80, 760 - 40 * i * 2, 20);
                }
                if (tips[i][j] == 2) {
                    myDrawObj.setColor(Color.WHITE);
                    myDrawObj.fillCircle(480 + j * 80, 760 - 40 * i * 2, 20);
                }
            }
        }

        for (int i = 0; i < COLORS.length; i++) {
            myDrawObj.setColor(COLORS[i]);
            myDrawObj.fillSquare(800, 80 * i, 80);
        }
        myDrawObj.drawImage(800, 720, "src/back_button.png");

        myDrawObj.show();
    }


    private static void processGameStep(CodeDraw myDrawObj, MouseEvent me) {
        int[] clickPos = new int[2];
        clickPos[0] = me.getX();
        clickPos[1] = me.getY();

        int width = myDrawObj.getWidth();
        int height = myDrawObj.getHeight();
        boolean gameCleared = false;
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode


        if (clickPos[0] >= 800) {
            if(clickPos[1] >= 0 && clickPos[1] < 80){
                if(checkIfContains(playField, 1) == true){
                    playField[turn][pin] = 1;
                    pin++;
                }
            }
            if(clickPos[1] >= 80 && clickPos[1] < 160){
                if(checkIfContains(playField, 2) == true){
                    playField[turn][pin] = 2;
                    pin++;
                }
            }
            if(clickPos[1] >= 160 && clickPos[1] < 240){
                if(checkIfContains(playField, 3) == true){
                    playField[turn][pin] = 3;
                    pin++;
                }
            }
            if(clickPos[1] >= 240 && clickPos[1] < 320){
                if(checkIfContains(playField, 4) == true){
                    playField[turn][pin] = 4;
                    pin++;
                }
            }
            if(clickPos[1] >= 320 && clickPos[1] < 400){
                if(checkIfContains(playField, 5) == true){
                    playField[turn][pin] = 5;
                    pin++;
                }
            }
            if(clickPos[1] >= 400 && clickPos[1] < 480){
                if(checkIfContains(playField, 6) == true){
                    playField[turn][pin] = 6;
                    pin++;
                }
            }
            if(clickPos[1] >= 480 && clickPos[1] < 560){
                if(checkIfContains(playField, 7) == true){
                    playField[turn][pin] = 7;
                    pin++;
                }
            }
            if(clickPos[1] >= 560 && clickPos[1] < 640){
                if(checkIfContains(playField, 8) == true){
                    playField[turn][pin] = 8;
                    pin++;
                }
            }
            if(clickPos[1] >= 640 && clickPos[1] < 720){
                if(checkIfContains(playField, 9) == true){
                    playField[turn][pin] = 9;
                    pin++;
                }
            }
            if(clickPos[1] >= 720 && clickPos[1] < 800){
                if(pin > 0){
                    playField[turn][--pin] = 0;
                }
            }

            if(pin == 4){
                updateTips();
                drawGame(myDrawObj);
                if(checkIfWonLostOrContinue() == 2){
                    myDrawObj.setColor(Color.GRAY);
                    myDrawObj.fillRectangle(250, 350, 300, 100);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawRectangle(250, 350, 300, 100);
                    myDrawObj.setColor(Color.RED);
                    myDrawObj.drawText(300, 375, "You LOST!");
                    myDrawObj.show(5000);
                    gameCleared = true;
                    clearBoard(myDrawObj);
                }
                if(checkIfWonLostOrContinue() == 1){
                    myDrawObj.setColor(Color.GRAY);
                    myDrawObj.fillRectangle(250, 350, 300, 100);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawRectangle(250, 350, 300, 100);
                    myDrawObj.setColor(Color.GREEN);
                    myDrawObj.drawText(300, 375, "You WON!");
                    myDrawObj.show(5000);
                    gameCleared = true;
                    clearBoard(myDrawObj);
                }
                if(gameCleared == false){
                    pin = 0;
                    turn++;
                }
            }else{
                drawGame(myDrawObj);
            }
        }
    }

    private static int checkIfWonLostOrContinue(){
        if(Arrays.equals(playField[turn], solution)){
            return 1;
        }
        if(turn == NUMBER_OF_TURNS - 1 && pin == 4){
            return 2;
        }
        return 0;
    }

    // clears game board
    private static void clearBoard(CodeDraw myDrawObj) {
        for(int i = turn; i >= 0; i--){
            playField[i] = new int[CODE_LENGTH];
            tips[i] = new int[CODE_LENGTH];
            drawGame(myDrawObj);
            myDrawObj.show(500);
        }
        initGame();

    }
    private static boolean checkIfContains(int arr[][], int color){ // returns true if color is not in the array
        int counter = 0;
        for (int i = 0; i < arr[turn].length; i++) {
            if(arr[turn][i] == color){
                counter++;
            }
        }

        if(counter > 0){
            return false;
        }
        return true;

    }



    public static void main(String[] args) {

        int height = 800;
        int width = height + height / (COLORS.length + 1);

        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setTitle("MasterMind Game");

        initGame();

        //for testing to print the solution


        drawGame(myDrawObj);

        myDrawObj.onMouseClick(Aufgabe1::processGameStep);

    }

}



