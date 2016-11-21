package pi4jdemo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class Wendu {
	public static void main(String[] args) throws Exception {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput pin = gpio
				.provisionDigitalOutputPin(RaspiPin.GPIO_24);
		pin.low();
		Thread.sleep(18);
		pin.high();
		Thread.sleep(40);
		GpioPinDigitalInput pin2 = gpio
				.provisionDigitalInputPin(RaspiPin.GPIO_24);
		int count = 0;
		while(pin2.getState().isHigh()){
			Thread.sleep(1);
			count++;
			if(count==255){
				break;
			}
		}
		if(count==255){
			System.out.println("read fail.");
			return;
		}
		String result = "";
		for(int i = 0;i<40;i++){
			result+=(pin2.getState().isHigh()?"1":"0");
		}
		System.out.println("result:"+result);

	}
}
