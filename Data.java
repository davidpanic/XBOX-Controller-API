package me.psrcek.xboxControllerApi;

public class Data {
	//BUTTONS
	public boolean A 		= false;
	public boolean B 		= false;
	public boolean X 		= false;
	public boolean Y 		= false;
	
	public boolean LB 		= false;
	public boolean RB 		= false;
	
	public boolean BACK 	= false;
	public boolean START 	= false;
	
	public boolean HOME 	= false;
	
	public boolean LS 		= false;
	public boolean RS 		= false;
	
	//AXIS
	public byte LSX = 0;
	public byte LSY = 0;
	
	public byte LT = -128;
	public byte RT = -128;
	
	public byte RSX = 0;
	public byte RSY = 0;
	
	public byte DPADX = 0;
	public byte DPADY = 0;
	
	public int readBytes = 0;
	
	@Override
	public String toString() {
		return     "A: " + A
				+ " B: " + B
				+ " X: " + X
				+ " Y: " + Y
				+ " LB: " + LB
				+ " RB: " + RB
				+ " BACK: " + BACK
				+ " START: " + START
				+ " HOME: " + HOME
				+ " LS: " + LS
				+ " RS: " + RS
				+ " LSX: " + LSX
				+ " LSY: " + LSY
				+ " LT: " + LT
				+ " RT: " + RT
				+ " RSX: " + RSX
				+ " RSY: " + RSY
				+ " DPADX: " + DPADX
				+ " DPADY: " + DPADY;
	}
}
