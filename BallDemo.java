import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> misBolas;
    private Random aleatorio;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        misBolas = new ArrayList<>();
        aleatorio = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        for (int i = 0; i < numeroBolas; i++) {
            int tamano = aleatorio.nextInt(50) + 5;
            int color1 = aleatorio.nextInt(220);
            int color2 = aleatorio.nextInt(220);
            int color3 = aleatorio.nextInt(220);
            
            int posX = aleatorio.nextInt(300);
            int posY = aleatorio.nextInt(250);
            Color color = new Color(color1, color2, color3);
            BouncingBall ball = new BouncingBall(posX, posY, tamano, color, ground, myCanvas);
            ball.draw();
            misBolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (int i = 0; i < misBolas.size(); i++) {
                misBolas.get(i).move();
                if (misBolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}