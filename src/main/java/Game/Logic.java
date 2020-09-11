package Game;

import main.java.Game.Combine;
import main.java.Game.CombineX;
import main.java.Game.CombineY;
import main.java.Game.RandomNumberGenerator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Logic extends RandomNumberGenerator {
    private int[][] Grid = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
    };
    private int startNumber = 2;
    private int GameState=0;
    private int endNumber=2048;

    private Combine combX = new CombineX();
    private Combine combY = new CombineY();


    public void start() {
        int x, y;
        int counter = 0;
        while (counter!=2){
            x=generateNewCoordinate(0,3);
            y=generateNewCoordinate(0,3);
            if(Grid[x][y]==0){
                Grid[x][y]= startNumber;
                counter++;
            }
        }
        GameState=1;
    }



    private void generateNewNumber() {
        int x, y;
        int luck = generateNewCoordinate(0, 10);
        while (true) {
            x = generateNewCoordinate(0, 3);
            y = generateNewCoordinate(0, 3);
            if (Grid[x][y] == 0) {
                if (luck > 7)
                    Grid[x][y] = startNumber + 2;
                else
                    Grid[x][y] = startNumber;
                break;
            }
        }
    }

    public int chekGrid(int xCoordinate, int yCoordinate) {
        return Grid[xCoordinate][yCoordinate];
    }

    public int getGameState() {
        return GameState;
    }

    public void update() {
        keyboardUpdate();
        if (everythingIsGone()) {
            System.out.println("It Seams that you boroke the 4 wall and have no more numbers all I have to say is good job and the game is over");
            Display.destroy();
        }
        if (fullCheker()) {
            System.out.println("Game Over");
            GameState=-1;
        }
        if (didYouWin()){
            System.out.println("You Win");
            Display.destroy();
        }


    }

    private boolean didYouWin() {
        for(int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if(Grid[i][j]==endNumber)
                    return true;
            }
        }
        return false;
    }

    private boolean fullCheker() {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Grid[i][j] > 0)
                    counter++;
            }
        }
        if (counter == 16)
            return true;
        return false;
    }

    private boolean everythingIsGone() {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Grid[i][j] == 0)
                    counter++;
            }
        }
        if (counter == 16)
            return true;
        return false;
    }

    private void keyboardUpdate() {
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_DOWN && Keyboard.getEventKeyState()) {
                combineCheck(-2);
                moveChekker(-2);
                generateNewNumber();
            } else if (Keyboard.getEventKey() == Keyboard.KEY_UP && Keyboard.getEventKeyState()) {
                combineCheck(2);
                moveChekker(2);
                generateNewNumber();
            } else if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                combineCheck(1);
                moveChekker(1);
                generateNewNumber();
            } else if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                combineCheck(-1);
                moveChekker(-1);
                generateNewNumber();
            }
        }
    }

    private void moveChekker(int direction) {
        if (direction == 1) { // <
            for (int i = 3; i >= 0; i--)
                for (int j = 0; j < 4; j++){
                    int iterator = 1;
                    while (Grid[i][j] == 0 && j + iterator <=3) {
                        Grid[i][j] = Grid[i][j+iterator];
                        Grid[i][j+iterator] = 0;
                        iterator++;
                    }
                }
        } else if (direction == -1) {// >
            for (int i = 0; i < 4; i++)
                for (int j = 3; j >= 0; j--){
                    int iterator = 1;
                    while (Grid[i][j] == 0 && j - iterator >=0) {
                        Grid[i][j] = Grid[i][j-iterator];
                        Grid[i][j-iterator] = 0;
                        iterator++;
                    }
            }
        } else if (direction == 2) {// /\
            for (int i = 0; i <= 3; i++)
                for (int j = 0; j < 4; j++) {
                    int iterator = 1;
                    while (Grid[i][j] == 0 && i+iterator <=3) {
                        Grid[i][j] = Grid[i + iterator][j];
                        Grid[i + iterator][j] = 0;
                        iterator++;
                    }
                }
        } else if (direction == -2) {// \/
            for (int i = 3; i >= 0; i--)
                for (int j = 0; j < 4; j++) {
                    int iterator = 1;
                    while (Grid[i][j] == 0 && i-iterator >=0) {
                        Grid[i][j] = Grid[i - iterator][j];
                        Grid[i - iterator][j] = 0;
                        iterator++;
                    }
                }
        }
    }
    //Combine chekker :P
    private void combineCheck(int direction) {
        if(direction == -1){ //Combine Right <
            for(int i = 0; i<=3; i++)
                for(int j = 0; j<=3; j++)
                    for (int Key = 0; Key <= 3; Key++)
                        if(combY.combine(Grid,i, j, Key))
                            j++;
        }
        else if(direction == 1){ //Conbime Left >
            for(int i=0; i<=3; i++)
                for (int j=3;j>=0;j--)
                    for (int Key = 3; Key >= 0; Key--)
                        if(combY.combine(Grid,i, j, Key))
                            j--;
        }
        else if (direction == 2) { //Combine Up
            for (int j=3; j>=0; j--)
                for (int i=0; i<=3; i++)
                    for (int Key=3; Key>=0; Key--)
                        if (combX.combine(Grid,j, i, Key))
                            i--;
        }
        else if (direction == -2){ //Combine Down
            for(int j=0; j<=3; j++){
                for(int i=0; i<=3; i++){
                    for (int Key=0; Key<=3-j; Key++)
                        if(combX.combine(Grid,j, i, Key))
                            i++;
                }
            }
        }
    }
}
