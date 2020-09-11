package main.java.Game;

public class CombineX extends Combine {
    public boolean combine(int[][] Grid, int posX, int posY, int Key) {
        try {
            if (Grid[posX][posY]>=2 && Grid[posX][posY]==Grid[posX+Key][posY] && Key!=0) {
                if (Grid[posX][posY]>=2 && Grid[posX][posY]==Grid[posX+Key][posY] && Key!=0) {
                    if(Key == 1){
                        combineNumbers(Grid,posX,posY,Key,0);
                        return true;
                    } else if(Key == 2) {
                        if(isThereAGap(Grid,posX,posY,Key-1,0))
                            return false;
                        else {
                            combineNumbers(Grid,posX,posY,Key,0);
                            return true;
                        }
                    }else if(Key == 3) {
                        if(isThereAGap(Grid,posX,posY,Key-1,0) && isThereAGap(Grid,posX,posY,Key-2,0))
                            return false;
                        else {
                            combineNumbers(Grid,posX,posY,Key,0);
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
