package wolfish.physics;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RocketControllerTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void calculateRocket() {

        //given
        RocketController controller = new RocketController();
        controller.velocityField = mock(TextField.class);
        doReturn("71").when(controller.velocityField).getText();
        controller.angleField = mock(TextField.class);
        doReturn("35").when(controller.angleField).getText();
        controller.secondsField = mock(TextField.class);
        doReturn("3").when(controller.secondsField).getText();
        controller.rocketCanvas = mock(RocketCanvas.class);
        controller.position = mock(Label.class);
        ActionEvent event = mock(ActionEvent.class);
        controller.flightTime = mock(Label.class);

        //when
        controller.calculateRocket(null);

        //then
        verify(controller.position).setText("(174.48, 8.31)");
        verify(controller.rocketCanvas).drawRocket(any(Rocket.class));


    }
}