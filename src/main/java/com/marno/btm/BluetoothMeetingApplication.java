package com.marno.btm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.marno.btm.mapper","com.marno.btm.controller","com.marno.btm.service"})
public class BluetoothMeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluetoothMeetingApplication.class, args);
	}

}
