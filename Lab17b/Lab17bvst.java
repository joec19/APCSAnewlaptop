// Lab17bvst.java
// The student, starting version of the Lab17b assignment.

/**
 * 15/04/2016 - modified by Bill Montana to include applet window resizing and to "fix" the curly braces
 */

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Lab17bvst extends Applet
{
    final int TOP_RIGHT = 0;
    final int TOP_LEFT = 1;
    final int BOTTOM_RIGHT = 2;
    final int BOTTOM_LEFT = 3;
    final int CENTER = 4;
    public void paint (Graphics g) {
        super.resize(800, 600);             // sets the applet window size
        drawSquares(g,800,600,200,150,CENTER);
    }

    public void drawSquares(Graphics g, int maxX, int maxY, int length, int width, int locFlag)
    {
        Random rand = new Random();
        if(width>=1)
        {
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            g.fillRect(maxX, maxY, length, width);
            switch(locFlag){
                case CENTER :
                drawSquares(g,maxX-length/2,maxY-width/2,length/2,width/2,TOP_LEFT);
                drawSquares(g,maxX+length,maxY-width/2,length/2,width/2,TOP_RIGHT);
                drawSquares(g,maxX+length,maxY+width,length/2,width/2,BOTTOM_RIGHT);
                drawSquares(g,maxX-length/2,maxY+width,length/2,width/2,BOTTOM_LEFT);
                break;

                case TOP_LEFT :
                drawSquares(g,maxX-length/2,maxY-width/2,length/2,width/2,TOP_LEFT);
                drawSquares(g,maxX+length,maxY-width/2,length/2,width/2,TOP_RIGHT);
                drawSquares(g,maxX-length/2,maxY+width,length/2,width/2,BOTTOM_LEFT);
                break;

                case TOP_RIGHT :
                drawSquares(g,maxX+length,maxY+width,length/2,width/2,BOTTOM_RIGHT);
                drawSquares(g,maxX-length/2,maxY-width/2,length/2,width/2,TOP_LEFT);
                drawSquares(g,maxX+length,maxY-width/2,length/2,width/2,TOP_RIGHT);
                break;

                case BOTTOM_LEFT :
                drawSquares(g,maxX-length/2,maxY+width,length/2,width/2,BOTTOM_LEFT);
                drawSquares(g,maxX-length/2,maxY-width/2,length/2,width/2,TOP_LEFT);
                drawSquares(g,maxX+length,maxY+width,length/2,width/2,BOTTOM_RIGHT);
                break;

                case BOTTOM_RIGHT :
                drawSquares(g,maxX-length/2,maxY+width,length/2,width/2,BOTTOM_LEFT);
                drawSquares(g,maxX+length,maxY+width,length/2,width/2,BOTTOM_RIGHT);
                drawSquares(g,maxX+length,maxY-width/2,length/2,width/2,TOP_RIGHT);
                break;
            }
        }
    }

    public void delay(long n) {
        n *= 1000;
        long startDelay = System.nanoTime();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.nanoTime();
    }
}

