import java.awt.Color;

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

        // crate and show the balls
        for(int i = 0; i < numeroBolas; i++){
            BouncingBall ball = new BouncingBall(50 + (10*1),50, 16, Color.BLUE, ground, myCanvas);
            ball.draw();
            misBolas[i]=ball;
        }

        // make them bounce
        /**
        boolean finished =  false;
        while(!finished) {
        myCanvas.wait(50);           // small delay
        ball.move();
        ball2.move();
        // stop once ball has travelled a certain distance on x axis
        if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
        finished = true;
        }
        }
         */
    }
}
