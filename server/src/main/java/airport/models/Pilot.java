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
@Table(name = "pilot")	
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;
	private int age;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "pilot",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private  Set<Vol> vols=new HashSet<>();
	
	
	public Pilot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pilot(long id, String firstName, String lastName, String email, int phoneNumber, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}


	public long getId() {
		return id;
	}
	public void setId_pilote(long id_pilote) {
		this.id = id_pilote;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Vol> getVols() {
		return vols;
	}
	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
	
	


}
