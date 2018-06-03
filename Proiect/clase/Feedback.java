package clase;

public class Feedback {
	private String feedback;
	private int idClient;
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public Feedback(String feedback, int idClient) {
		this.feedback=feedback;
		this.idClient=idClient;
	}
}
