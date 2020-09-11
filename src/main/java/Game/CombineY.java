package main.java.Game;

public class CombineY extends Combine {
    public boolean combine(int[][] Grid, int posX, int posY, int Key){
        try {
            if (Grid[posX][posY]>=2 && Grid[posX][posY]==Grid[posX][posY+Key] && Key!=0) {
                if (Grid[posX][posY]>=2 && Grid[posX][posY]==Grid[posX][posY+Key] && Key!=0) {
                    if(Key == 1){
                        combineNumbers(Grid,posX,posY,0,Key);
                        return true;
                    } else if(Key == 2) {
                        if(isThereAGap(Grid,posX,posY,0,Key-1))
                            return true;
                        else {
                            combineNumbers(Grid,posX,posY,0,Key);
                            return true;
                        }
                    }else if(Key == 3) {
                        if(isThereAGap(Grid,posX,posY,0,Key-1) && isThereAGap(Grid,posX,posY,0,Key-2))
                            return true;
                        else {
                            combineNumbers(Grid,posX,posY,0,Key);
                            return true;
                        }
                    }else
                        return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        return false;

    }
}
