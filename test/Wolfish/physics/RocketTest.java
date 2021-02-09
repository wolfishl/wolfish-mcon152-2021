package Wolfish.physics;

import org.junit.Assert;
import org.junit.Test;


public class RocketTest {

    @Test
    public void getX(){
        //given -set up variables
        Rocket rocket = new Rocket(71, 35);

        //when - what we r testing
        double x = rocket.getX(3);

        //then - test results
        Assert.assertEquals(174.47, x, 0.01);
    }

    @Test
    public void getY(){
        //given
        Rocket rocket = new Rocket(71, 35);

        //when - what we r testing
        double y = rocket.getY(3);

        //then - test results
        Assert.assertEquals(78.07, y, 0.01);
    }

    @Test
    public void getFlightTime(){
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double time = rocket.getFlightTime();

        //then
        Assert.assertEquals(8.3110, time, 0.01);
    }

}
