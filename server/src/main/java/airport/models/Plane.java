package airport.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "plane")	
public class Plane {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String label;
	private String plannumber;
	private String model;
	private int capacity;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "plane",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private  Set<Vol> vols=new HashSet<>();
	
	
	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Plane(long id, String label, String plannumber, String model, int capacity) {
		super();
		this.id = id;
		this.label = label;
		this.plannumber = plannumber;
		this.model = model;
		this.capacity = capacity;
	}




	public long getId() {
		return id;
	}
	

	
	public String getLabel() {
		return label;
	}




	public void setLabel(String label) {
		this.label = label;
	}




	public String getPlannumber() {
		return plannumber;
	}




	public void setPlannumber(String plannumber) {
		this.plannumber = plannumber;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public int getCapacity() {
		return capacity;
	}




	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}




	public void setId(long id) {
		this.id = id;
	}




	public Set<Vol> getVols() {
		return vols;
	}
	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
	
	


}
