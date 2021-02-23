package Wolfish.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

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
        context.setFill(Color.DEEPPINK);
        context.translate(0, getHeight());
        context.setStroke(Color.CORAL);
        context.moveTo(rocket.getX(0),rocket.getY(0));


        for (double time = 0; time < rocket.getFlightTime(); time+=0.5)
        {
            double x = rocket.getX(time);
            double y = rocket.getY(time);

            context.fillOval(x, -y, 10, 10);

            context.lineTo(x+5, -y);
            context.stroke();
        }

        context.lineTo(rocket.getX(rocket.getFlightTime())+5, -rocket.getY(rocket.getFlightTime()));
        context.stroke();

        context.translate(0, -getHeight());
    }
}
