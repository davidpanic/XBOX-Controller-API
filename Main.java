package me.psrcek.xboxControllerApi.test;

import java.io.FileNotFoundException;

import me.psrcek.xboxControllerApi.ControllerPoller;
import me.psrcek.xboxControllerApi.Data;
import me.psrcek.xboxControllerApi.DataChangeListener;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		ControllerPoller poller = new ControllerPoller("/dev/input/js0");
		poller.start();
		
		poller.addDataChangeListener(new DataChangeListener() {
			public void onDataChange(Data d) {
				
				System.out.println(d.toString());
				
			}
		});
	}
}
