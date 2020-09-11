package Display;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

public class Draw {

    public static void quad (float x , float y, float height, float width){
        glBegin(GL_QUADS);
        color(1,1,1);
        glVertex2f(x,y);//top left
        glVertex2f(x + width,y);//bottom left
        glVertex2f(x + width,y + height);//bottom right
        glVertex2f(x,y + height);//bottom right
        glEnd();
    }

    public static void colorQuad(float x , float y, float height, float width ,double red, double green, double blue){
        glBegin(GL_QUADS);
        color(red,green,blue);
        glVertex2f(x,y);//top left
        glVertex2f(x + width,y);//bottom left
        glVertex2f(x + width,y + height);//bottom right
        glVertex2f(x,y + height);//bottom right
        glEnd();
    }

    public static void textureQuad(Texture tex, float x, float y,float width, float height){
        tex.bind();
        glTranslatef(x,y,0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);//top left
        glTexCoord2f(1,0);
        glVertex2f(width,0);//bottom left
        glTexCoord2f(1,1);
        glVertex2f(width,height);//bottom right
        glTexCoord2f(0,1);
        glVertex2f(0,height);//bottom right
        glEnd();
        glLoadIdentity();
    }

    public static Texture LoadTexture(String path, String fileType) {
        Texture tex= null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex= TextureLoader.getTexture(fileType, in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tex;
    }

    public static Texture QuickLoad(String name) {
        Texture tex= null;
        tex= LoadTexture("res/"+ name +".png","PNG");
        return tex;
    }

    private static void color(double red, double green, double blue){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glColor3d(red,green,blue);
    }
}
