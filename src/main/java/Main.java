import Display.*;
import Game.Logic;
import org.lwjgl.opengl.Display;

public class Main {

    public Main() {
        Logic logic= new Logic();
        logic.start();
        Session session =  new Session();
        session.Start();
        Grid grid = new Grid();
        while (!Display.isCloseRequested()) {
            grid.draw(logic,session);
            logic.update();
            session.loop();
            if(logic.getGameState()==-1)
                break;
        }
        Display.destroy();
    }

    public static void main(String[] args) {
        new Main();
    }
}
