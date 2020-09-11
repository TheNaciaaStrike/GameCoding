package Display;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;


public class Session {
    private static final int displayWidth = 512 , displayHieght = 512;
    private static String title = "2048";
    private static float tileWidth=128, tileHieght=128;

    public static void Start(){
        Display.setTitle(title);
        try{
            Display.setDisplayMode(new DisplayMode(displayWidth,displayHieght));
            Display.create();
        } catch (LWJGLException e){
            System.out.println("LWJGL Exeption");
        }
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,displayWidth,displayHieght,0,1,-1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void loop(){

        Display.update();
        Display.sync(60);
    }

    public static float getTileWidth() {
        return tileWidth;
    }

    public static float getTileHieght() {
        return tileHieght;
    }
}
