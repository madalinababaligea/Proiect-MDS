package clase;

import clase.Sesiune;

public class Sesiune {
	private String username;
	private String pass;
	//private String disc;
	private static Sesiune instance;
	private int id;
	private Sesiune() {}
	public static Sesiune getInstance() {
		if(instance==null)
			instance=new Sesiune();
		return instance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void clear() {
		instance=null;
		id=-1;
		username="";
		pass="";
	}

}
