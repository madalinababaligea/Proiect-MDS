package clase;

public class Feed {
	
	String feedback;
	int id;
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 public Feed(String feedback, int id)
	 {
		 this.feedback=feedback;
		 this.id=id;
	 }
}
