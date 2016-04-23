package me.psrcek.xboxControllerApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPoller extends Thread {
	private File inFile;
	private FileInputStream inStream;
	
	private boolean shouldRun = false;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<DataChangeListener>();
	
	public ControllerPoller(String deviceLoc) throws FileNotFoundException {
		inFile = new File(deviceLoc);
		inStream = new FileInputStream(inFile);
	}
	
	@Override
	public void run() {
		shouldRun = true;
		Data data;
		
		while (shouldRun) {
			try {
				byte[] bytes = new byte[152];
				inStream = new FileInputStream(inFile);
				int readBytes = inStream.read(bytes);
				
				data = null;
				data = new Data();
				
				data.readBytes = readBytes;
				
				if (bytes[4]  == 1) data.A 		= true;
				if (bytes[12] == 1) data.B 		= true;
				if (bytes[20] == 1) data.X 		= true;
				if (bytes[28] == 1) data.Y 		= true;
				if (bytes[36] == 1) data.LB 	= true;
				if (bytes[44] == 1) data.RB 	= true;
				if (bytes[52] == 1) data.BACK 	= true;
				if (bytes[60] == 1) data.START 	= true;
				if (bytes[68] == 1) data.HOME 	= true;
				if (bytes[76] == 1) data.LS 	= true;
				if (bytes[84] == 1) data.RS 	= true;
				
				data.LSX 	= bytes[93];
				data.LSY 	= bytes[101];
				data.LT 	= bytes[109];
				data.RSX 	= bytes[117];
				data.RSY 	= bytes[125];
				data.RT 	= bytes[133];
				data.DPADX 	= bytes[141];
				data.DPADY 	= bytes[149];
				
				for (DataChangeListener d : dataChangeListeners) {
					d.onDataChange(data);
				}
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startPolling() {
		this.start();
	}
	
	public void stopPolling() {
		shouldRun = false;
	}
	
	public int addDataChangeListener(DataChangeListener dcl) {
		dataChangeListeners.add(dcl);
		return dataChangeListeners.lastIndexOf(dcl);
	}
	
	public void removeDataChangeListener(int index) {
		dataChangeListeners.remove(index);
	}
}
