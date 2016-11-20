package pi4jdemo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Demo1 {
	public static void main(String[] args) throws Exception{
		GpioController controller = GpioFactory.getInstance();
		GpioPinDigitalOutput pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED", PinState.HIGH);
		// set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);
        Thread.sleep(5000);
        pin.low();
        Thread.sleep(5000);
        pin.high();
        Thread.sleep(5000);
        controller.shutdown();
	}
}
