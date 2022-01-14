
public class DropBlock extends Thread{
    @Override
    public void run() {

        while(Tetris.checkIfGameOver() == false){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            for (int i = Tetris.playfield.length - 1; i >= 0; i--) {
                for (int j = 0; j < Tetris.playfield[i].length; j++) {
                    if(Tetris.playfield[i][j] == 2){
                        Tetris.playfield[i + 1][j] = 3;
                        Tetris.playfield[i][j] = 0;
                    }

                }
            }
            for (int i = 0; i < Tetris.playfield.length - 1; i++) {
                for (int j = 0; j < Tetris.playfield[i].length; j++) {
                    if(Tetris.playfield[i][j] == 3){
                        Tetris.playfield[i][j] = 2;
                    }
                }
            }

            Tetris.myDraw.clear();
            Tetris.drawPlayfield();
            Tetris.makeBlockSolid();
            if(Tetris.checkIfRowsFull() >= 0){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                Tetris.dropRow(Tetris.checkIfRowsFull());
            }

        }
    }
}
