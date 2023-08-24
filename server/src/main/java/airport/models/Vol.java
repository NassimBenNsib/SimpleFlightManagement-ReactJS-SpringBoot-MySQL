package airport.models;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "vol")
public class Vol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int volnumber;
	private double price;
	
	private LocalDateTime departuretime;
	private LocalDateTime arrivaltime;

	private String departure;
	private String destination;
	private String Voltype;
	private String status;


	
	@ManyToOne
	@JoinColumn(name = "id_pilote")
	private Pilot pilot;
	
	@ManyToOne
	@JoinColumn(name = "id_plane")
	private Plane plane;
	
	





	public Vol(long id, int volnumber, double price, LocalDateTime departuretime, LocalDateTime arrivaltime,
			String departure, String destination, String voltype, String status, Long pilotid, Long planetid) {
		super();
		this.id = id;
		this.volnumber = volnumber;
		this.price = price;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
		this.departure = departure;
		this.destination = destination;
		Voltype = voltype;
		this.status = status;
		this.pilot=new Pilot(pilotid, "", "", "", 0, 0);
		this.plane=new Plane(planetid, "", "", "", 0);
	}


	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id_vol) {
		this.id = id_vol;
	}



	public int getVolnumber() {
		return volnumber;
	}


	public void setVolnumber(int volnumber) {
		this.volnumber = volnumber;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDateTime getDeparturetime() {
		return departuretime;
	}


	public void setDeparturetime(LocalDateTime departuretime) {
		this.departuretime = departuretime;
	}


	public LocalDateTime getArrivaltime() {
		return arrivaltime;
	}


	public void setArrivaltime(LocalDateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getVoltype() {
		return Voltype;
	}


	public void setVoltype(String voltype) {
		Voltype = voltype;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Pilot getPilot() {
		return pilot;
	}


	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}


	public Plane getPlane() {
		return plane;
	}


	public void setPlane(Plane plane) {
		this.plane = plane;
	}





	
	
	

}
