package clase;

public class Zone {
	private int zonaA;
	private int zonaB;
	private int zonaC;
	private int zonaD;
	public int getZonaA() {
		return zonaA;
	}
	public void setZonaA(int zonaA) {
		this.zonaA = zonaA;
	}
	public int getZonaB() {
		return zonaB;
	}
	public void setZonaB(int zonaB) {
		this.zonaB = zonaB;
	}
	public int getZonaC() {
		return zonaC;
	}
	public void setZonaC(int zonaC) {
		this.zonaC = zonaC;
	}
	public int getZonaD() {
		return zonaD;
	}
	public void setZonaD(int zonaD) {
		this.zonaD = zonaD;
	}
	
	public Zone(int zonaA, int zonaB, int zonaC, int zonaD) {
		this.zonaA=zonaA;
		this.zonaB=zonaB;
		this.zonaC=zonaC;
		this.zonaA=zonaD;
	}
}
