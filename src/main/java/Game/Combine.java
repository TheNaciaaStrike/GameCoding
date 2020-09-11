package main.java.Game;

public class Combine {
    public boolean combine(int[][] grid, int i, int j, int key){
        System.out.println("Empty combine logic");
        return true;
    }
    protected void combineNumbers(int[][] Grid, int posX, int posY, int KeyX, int KeyY){
        Grid[posX+KeyX][posY+KeyY] += Grid[posX][posY];
        Grid[posX][posY] = 0;
    }
    protected boolean isThereAGap(int[][] Grid, int posX, int posY, int KeyX, int KeyY){
        if(Grid[posX][posY]!=Grid[posX+KeyX][posY+KeyY] && Grid[posX+KeyX][posY+KeyY]!=0)
            return true;
        else
            return false;
    }
}
