package clase;

public class Utilizator {
	private String nume;
	private String prenume;
	private String username;
	private String password;
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Utilizator(String nume, String prenume, String username, String password)
	{
		this.nume=nume;
		this.prenume=prenume;
		this.username=username;
		this.password=password;
	}
}
