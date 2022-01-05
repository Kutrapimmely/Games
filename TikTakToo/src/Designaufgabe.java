import codedraw.CodeDraw;
import java.util.Scanner;
/*
    Designaufgabe - Verzweigungen, Schleifen und CodeDraw
*/

// Classic TikTakToo! Input in console. Numpad is playing area.
public class Designaufgabe {
    public static void main(String[] args) {
        String text1 = "Hello";
        String text2 = "World";
        String result;
        result = result + text1;

        int spielfeld[][] = new int[3][3];
        int counts = 0;
        int playerInput = 0;
        CodeDraw cd = new CodeDraw(300, 300);
        cd.setLineWidth(3);
        drawArea(cd);
        do{
            playerInput = getPlayerInput(spielfeld, counts);
            insertPlayerInputIntoArray(spielfeld, playerInput, counts);
            drawPlayerInput(cd, counts, playerInput);
            if(checkIfPlayerWon(spielfeld)){
                break;
            }
            counts++;
        }while(counts < 9);
        if(counts == 9){
            System.out.println("Nobody won!");
        }else{
            System.out.println("Player " + (counts % 2 + 1) + " won!");
        }
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        cd.dispose(true);
    }
    public static boolean checkIfPlayerWon(int spielfeld[][]){
        if(spielfeld[0][0] != 0 && spielfeld[0][0] == spielfeld[0][1] && spielfeld[0][1] == spielfeld[0][2] || spielfeld[1][0] != 0 && spielfeld[1][0] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[1][2] || spielfeld[2][0] != 0 && spielfeld[2][0] == spielfeld[2][1] && spielfeld[2][1] == spielfeld[2][2] || spielfeld[0][0] != 0 && spielfeld[0][0] == spielfeld[1][0] && spielfeld[1][0] == spielfeld[2][0] || spielfeld[0][1] != 0 && spielfeld[0][1] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][1] || spielfeld[0][2] != 0 && spielfeld[0][2] == spielfeld[1][2] && spielfeld[1][2] == spielfeld[2][2] || spielfeld[0][0] != 0 && spielfeld[0][0] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][2] || spielfeld[0][2] != 0 && spielfeld[0][2] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][0]){
            return true;
        }
        return false;
    }
    public static void drawPlayerInput(CodeDraw cd, int counts, int playerInput){
        switch (playerInput){
            case 1:
                if(counts % 2 == 0){
                    cd.drawCircle(50, 250, 35);
                }else{
                    cd.drawLine(15, 215, 85, 285);
                    cd.drawLine(85, 215, 15, 285);
                }
                break;
            case 2:
                if(counts % 2 == 0){
                    cd.drawCircle(150, 250, 35);
                }else{
                    cd.drawLine(115, 215, 185, 285);
                    cd.drawLine(185, 215, 115, 285);
                }
                break;
            case 3:
                if(counts % 2 == 0){
                    cd.drawCircle(250, 250, 35);
                }else{
                    cd.drawLine(215, 215, 285, 285);
                    cd.drawLine(285, 215, 215, 285);
                }
                break;
            case 4:
                if(counts % 2 == 0){
                    cd.drawCircle(50, 150, 35);
                }else{
                    cd.drawLine(15, 115, 85, 185);
                    cd.drawLine(85, 115, 15, 185);
                }
                break;
            case 5:
                if(counts % 2 == 0){
                    cd.drawCircle(150, 150, 35);
                }else{
                    cd.drawLine(115, 115, 185, 185);
                    cd.drawLine(185, 115, 115, 185);
                }
                break;
            case 6:
                if(counts % 2 == 0){
                    cd.drawCircle(250, 150, 35);
                }else{
                    cd.drawLine(215, 115, 285, 185);
                    cd.drawLine(285, 115, 215, 185);
                }
                break;
            case 7:
                if(counts % 2 == 0){
                    cd.drawCircle(50, 50, 35);
                }else{
                    cd.drawLine(15, 15, 85, 85);
                    cd.drawLine(85, 15, 15, 85);
                }
                break;
            case 8:
                if(counts % 2 == 0){
                    cd.drawCircle(150, 50, 35);
                }else{
                    cd.drawLine(115, 15, 185, 85);
                    cd.drawLine(185, 15, 115, 85);
                }
                break;
            case 9:
                if(counts % 2 == 0){
                    cd.drawCircle(250, 50, 35);
                }else{
                    cd.drawLine(215, 15, 285, 85);
                    cd.drawLine(285, 15, 215, 85);
                }
                break;
        }
        cd.show();
    }
    public static void drawArea(CodeDraw cd){
        cd.drawLine(0, 100, 300, 100);
        cd.drawLine(0, 200, 300, 200);
        cd.drawLine(100, 0, 100, 300);
        cd.drawLine(200, 0, 200, 300);
        cd.show();
    }
    public static int getPlayerInput(int spielfeld[][], int counts){
        System.out.println("Player " + (counts % 2 + 1) + ":");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                int retVal = sc.nextInt();
                if(checkIfPlayerInputIsCorrect(spielfeld, retVal)){
                    return retVal;
                }else{
                    System.out.println("Wrong input!");
                }
            }else{
                System.out.println("Wrong input!");
                sc.next();
            }
        }
        return 0;
    }
    public static void insertPlayerInputIntoArray(int spielfeld[][], int playerInput, int counts){
        switch (playerInput){
            case 1:
                spielfeld[2][0] = counts % 2 + 1;
                break;
            case 2:
                spielfeld[2][1] = counts % 2 + 1;
                break;
            case 3:
                spielfeld[2][2] = counts % 2 + 1;
                break;
            case 4:
                spielfeld[1][0] = counts % 2 + 1;
                break;
            case 5:
                spielfeld[1][1] = counts % 2 + 1;
                break;
            case 6:
                spielfeld[1][2] = counts % 2 + 1;
                break;
            case 7:
                spielfeld[0][0] = counts % 2 + 1;
                break;
            case 8:
                spielfeld[0][1] = counts % 2 + 1;
                break;
            case 9:
                spielfeld[0][2] = counts % 2 + 1;
                break;
        }
    }
    public static boolean checkIfPlayerInputIsCorrect(int spielfeld[][], int playerInput){
        if(playerInput <= 9 && playerInput >= 1){
            switch (playerInput){
                case 1:
                    if(spielfeld[2][0] == 0){
                        return true;
                    }
                    break;
                case 2:
                    if(spielfeld[2][1] == 0){
                        return true;
                    }
                    break;
                case 3:
                    if(spielfeld[2][2] == 0){
                        return true;
                    }
                    break;
                case 4:
                    if(spielfeld[1][0] == 0){
                        return true;
                    }
                    break;
                case 5:
                    if(spielfeld[1][1] == 0){
                        return true;
                    }
                    break;
                case 6:
                    if(spielfeld[1][2] == 0){
                        return true;
                    }
                    break;
                case 7:
                    if(spielfeld[0][0] == 0){
                        return true;
                    }
                    break;
                case 8:
                    if(spielfeld[0][1] == 0){
                        return true;
                    }
                    break;
                case 9:
                    if(spielfeld[0][2] == 0){
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}