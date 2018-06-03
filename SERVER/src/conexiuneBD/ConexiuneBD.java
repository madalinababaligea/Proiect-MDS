package conexiuneBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clase.Client;
import clase.Feedback;
import clase.Sesiune;

//aici sunt prelucrari pentru diferite cereri

public class ConexiuneBD {
	private Connection con;

	private final String DB_URL="jdbc:oracle:thin:@193.226.51.37:1521:o11g";
	private final String DB_USER="grupa42";
	private final String DB_PASSWORD="grupa42";
	private final String driverName = "oracle.jdbc.driver.OracleDriver"; 
	
	public  ConexiuneBD() {
        try {
        	// System.out.println("Conexiune BD1");
             Class.forName(driverName);
            // System.out.println("Conexiune BD2");
             con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // System.out.println("Conexiune BD3");
        } catch (SQLException ex) {
              ex.printStackTrace();
        }catch (ClassNotFoundException ex) {
            // log an exception. for example:
           ex.printStackTrace();
        }
    }
	
	public String selectUser(String username,String parola,Sesiune ses) {
		try(PreparedStatement ps=con.prepareStatement("SELECT * FROM clienti WHERE username=? AND password=?");
			PreparedStatement psS=con.prepareStatement("SELECT * FROM manageri WHERE username=? AND password=?");){
			//System.out.println("verifica user "+username);
			ps.setString(1, username);
			ps.setString(2, parola);
			psS.setString(1, username);
			psS.setString(2, parola);
			ResultSet rs=ps.executeQuery();
			ResultSet rsS=psS.executeQuery();
			if(rs.next()) {
				System.out.println("a ajuns in primul if");
				int id=rs.getInt("client_id");
				System.out.println("Id client");
				ses.getInstance().setId(id);
				ses.getInstance().setUsername(username);
				ses.getInstance().setPass(parola);
				return "Client";
			}
			else
			if(rsS.next()) {
				System.out.println("a ajuns in if 2");
				int id=rsS.getInt("manager_id");
				System.out.println("Id manager");
				ses.getInstance().setId(id);
				ses.getInstance().setUsername(username);
				ses.getInstance().setPass(parola);
				return "Manager";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Nu a intrat in if");
		return null;
	}
	public boolean addClient(Client c) {
		try(PreparedStatement ps=con.prepareStatement("SELECT * FROM clienti WHERE username=?")) {
			String username=c.getUsername();
			String nume=c.getNume();
			String prenume=c.getPrenume();
			String password=c.getPassword();
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return false; //clientul exista deja si nu poate fi adaugat
			PreparedStatement psU=con.prepareStatement("INSERT INTO clienti VALUES(?,?,?,?,?)");
			PreparedStatement psMax=con.prepareStatement("SELECT max(client_id) FROM clienti");
			ResultSet rsMax=psMax.executeQuery();
			int id=-1;
			boolean gasit=false;
			if(rsMax.next())
			{
				id=rsMax.getInt("client_id")+1;
				gasit=true;
			}
			if(gasit==false)
				id=1;
			psU.setInt(1, id);
			psU.setString(2, nume);
			psU.setString(3, prenume);
			psU.setString(4, username);
			psU.setString(5, password);
			int rows=psU.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean editeazaClient(Client c,Sesiune ses) {
		try(PreparedStatement ps=con.prepareStatement("UPDATE clienti SET username=?, nume=?, password=?, prenume=? WHERE id_client=?")) {
			int id=ses.getInstance().getId();
			ps.setInt(5, id);
			String username=c.getUsername();
			String nume=c.getNume();
			String prenume=c.getPrenume();
			String password=c.getPassword();
			ps.setString(1, username);
			ps.setString(2, nume);
			ps.setString(3, password);
			ps.setString(4, prenume);
			int rows=ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	public int locuriLibere(String data) {
		try (PreparedStatement ps=con.prepareStatement("SELECT count(nr_persoane) FROM rezervari WHERE data=?")){
			ps.setString(1, data);
			ResultSet rs=ps.executeQuery();
			int locuri=-1;
			if(rs.next())
				locuri=rs.getInt(1);
			
			return 500-locuri;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public boolean adaugaRezervare(String data, String zonaAleasa, String nrPers,Sesiune ses) {
		try (PreparedStatement ps=con.prepareStatement("INSERT INTO rezervari VALUES (?,?,?,?,?,?,?,?)");
			PreparedStatement psMax=con.prepareStatement("SELECT max(rezervare_id) FROM rezervari")){
			ResultSet rsMax=psMax.executeQuery();
			int id=-1;
			int nrPer=Integer.parseInt(nrPers);
			if(rsMax.next())
				id=rsMax.getInt(1)+1;
			if(id==-1)
				id=1;
			ps.setInt(1, id);
			DateFormat format=new SimpleDateFormat("yyyy-mm-dd");
			Date date=format.parse(data);
			java.sql.Date sql=new java.sql.Date(date.getTime());
			ps.setDate(2, sql);
			if(zonaAleasa.equals("zona a")) {
				ps.setInt(3, 1);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
			}
			else
				if(zonaAleasa.equals("zona b")){
					ps.setInt(3, 1);
					ps.setInt(4, 1);
					ps.setInt(5, 0);
					ps.setInt(6, 0);
				}
				else
					if(zonaAleasa.equals("zona c")) {
						ps.setInt(3, 1);
						ps.setInt(4, 1);
						ps.setInt(5, 1);
						ps.setInt(6, 0);
					}
					else if (zonaAleasa.equals("zona d")) {
						ps.setInt(3, 1);
						ps.setInt(4, 1);
						ps.setInt(5, 1);
						ps.setInt(6, 1);
					}
			ps.setInt(7, nrPer);
			int idC=ses.getInstance().getId();
			ps.setInt(8, idC);
			int row=ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void adaugaFeedback(String feedback, Sesiune ses) {
		try (PreparedStatement ps=con.prepareStatement("INSERT INTO feedback VALUES(?,?,?)");
			 PreparedStatement psMax=con.prepareStatement("SELECT max(feedback_id) FROM feedback")){
			int idC=ses.getInstance().getId();
			ResultSet rsMax=psMax.executeQuery();
			int id=-1;
			if(rsMax.next())
				id=rsMax.getInt(1)+1;
			if(id==-1)
				id=1;
			ps.setInt(1, id);
			ps.setString(2, feedback);
			ps.setInt(3, idC);
			int rows=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Feedback> veziFeedback(){
		ArrayList<Feedback> lista=new ArrayList<>();
		try(PreparedStatement ps=con.prepareStatement("SELECT * FROM feedback");
			ResultSet rs=ps.executeQuery()){
			int idClient=-1;
			String feed=new String();
			while(rs.next()) {
				feed=rs.getString(2);
				idClient=rs.getInt(3);
				lista.add(new Feedback(feed,idClient));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close() {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}