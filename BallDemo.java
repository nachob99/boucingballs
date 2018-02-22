import java.awt.Color;
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
    private BouncingBall[] misBolas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);

    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        misBolas = new BouncingBall[numeroBolas];
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        Random aleatorio = new Random();
        // crate and show the balls
        for(int i = 0; i < numeroBolas; i++){
            int radio = aleatorio.nextInt(20) + 5;
            
            int color1 = aleatorio.nextInt(200);
            int color2 = aleatorio.nextInt(200);
            int color3 = aleatorio.nextInt(200);
            
            int posX = aleatorio.nextInt(300);
            
            Color color = new Color(color1,color2,color3);
            BouncingBall ball = new BouncingBall(posX,50, radio, color, ground, myCanvas);
            ball.draw();
            misBolas[i]=ball;
        }

        // make them bounce

        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < numeroBolas; i++){
                misBolas[i].move();
                if(misBolas[i].getXPosition() >= 550){
                    finished = true;
                }
            }
            // stop once ball has travelled a certain distance on x axis
            
        }

    }
}
