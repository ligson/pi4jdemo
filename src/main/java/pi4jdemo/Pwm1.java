package pi4jdemo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class Pwm1 {
	public static void main(String[] args) throws Exception{
		GpioController gpio = GpioFactory.getInstance();
		GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_29);
		for(int i = 0;i<100;i++){
			pin.setPwm(i);
			Thread.sleep(100);
		}
		gpio.shutdown();
	}
}
