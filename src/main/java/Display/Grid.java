package Display;

import Game.Logic;

public class Grid {


    public void draw(Logic logic, Session session){
        for(int i=0; i<4; i++){
            for(int j=0;j<4; j++){
                switch (logic.chekGrid(j,i)){
                    case 2:
                        Draw.textureQuad(Draw.QuickLoad("2"), session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 4:
                        Draw.textureQuad(Draw.QuickLoad("4"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 8:
                        Draw.textureQuad(Draw.QuickLoad("8"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 16:
                        Draw.textureQuad(Draw.QuickLoad("16"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 32:
                        Draw.textureQuad(Draw.QuickLoad("32"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 64:
                        Draw.textureQuad(Draw.QuickLoad("64"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 128:
                        Draw.textureQuad(Draw.QuickLoad("128"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 256:
                        Draw.textureQuad(Draw.QuickLoad("256"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 512:
                        Draw.textureQuad(Draw.QuickLoad("512"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 1024:
                        Draw.textureQuad(Draw.QuickLoad("1024"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;
                    case 2048:
                        Draw.textureQuad(Draw.QuickLoad("2048"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                        break;

                        default:
                            Draw.textureQuad(Draw.QuickLoad("null"),session.getTileWidth()*i,session.getTileHieght()*j,session.getTileWidth(),session.getTileHieght());
                }
            }
        }
    }
}
