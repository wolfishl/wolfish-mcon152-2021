package Wolfish.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
Draws the rocket flight to the canvas.
 */
public class RocketCanvas extends Canvas {

    /*
    Draws the path of the rocket from time=0 to the Rocket's flight time with 1 second intervals.
    @param rocket
     */
    public void drawRocket(Rocket rocket){
        GraphicsContext context = getGraphicsContext2D();

        context.setFill(Color.PAPAYAWHIP);
        context.fillRect(0, 0, getWidth(), getHeight());

        context.setFill(Color.AQUAMARINE);
        context.translate(0, getHeight());
        for (double time = 0; time < rocket.getFlightTime(); time+=0.5)
        {
            double x = rocket.getX(time);
            double y = rocket.getY(time);

            context.fillOval(x, -y, 10, 10);
        }

        context.restore();
    }
}
