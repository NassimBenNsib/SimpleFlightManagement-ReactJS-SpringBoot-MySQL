package airport.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airport.models.Pilot;
import airport.service.PilotService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class PiloteController {
	
	@Autowired
    private PilotService pilotService;
	
	
	
	
	@GetMapping("/pilots")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	 public List<Pilot> list() {
		System.out.println();
		 return pilotService.list();
	 }
	
	
	
	@GetMapping("/pilots/id/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Pilot getPilotById(@PathVariable(value = "id") Long PilotId){
				return pilotService.findById(PilotId);
	}
	
	
	@PostMapping("/pilots")
	public long createPilot(@Validated @RequestBody Pilot pilot) {
		return pilotService.save(pilot);
	}
	
	
	@DeleteMapping("/pilots/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deletePilot(@PathVariable(value = "id") Long PilotId) {
		try {
			pilotService.delete(PilotId);
			return "pilot supprimée";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	
	@DeleteMapping("/pilots/all")
	@PreAuthorize("hasRole('ADMIN')")
	public String deletePilots() {
		try {
			pilotService.deleteAll();
			return "pilots supprimées";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	  
	  @PutMapping("/pilots/{id}")
	  //@PreAuthorize("hasRole('ADMIN')")
	  public  ResponseEntity<Object> updatePilot(@PathVariable("id") long id, @RequestBody Pilot pilot) {
	 
	 
	    if (pilotService.findById(id)!=null)  
	    {
	    	pilot.setId_pilote(id);
	    	 return new ResponseEntity<>(pilotService.save(pilot), HttpStatus.OK);

	    }
	    else 
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  
	  }
	  
	  

}
