package clase;

public class Zone {
	private int zonaA;
	private int zonaB;
	private int zonaC;
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
	public Zone(int zonaA, int zonaB, int zonaC) {
		this.zonaA=zonaA;
		this.zonaB=zonaB;
		this.zonaC=zonaC;
	}
}
