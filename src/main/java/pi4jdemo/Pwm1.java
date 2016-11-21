package pi4jdemo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.RaspiPin;

/***
 * // All Raspberry Pi models support a hardware PWM pin on GPIO_01. 69 //
 * Raspberry Pi models A+, B+, 2B, 3B also support hardware PWM pins: GPIO_23,
 * GPIO_24, GPIO_26
 * 
 * @author ligso
 *
 */
public class Pwm1 {
	public static void main(String[] args) throws Exception {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26);
		pin.setMode(PinMode.PWM_OUTPUT);
		for (int i = 0; i < 100; i++) {
			pin.setPwm(i);
			Thread.sleep(100);
		}
		gpio.shutdown();
	}
}
