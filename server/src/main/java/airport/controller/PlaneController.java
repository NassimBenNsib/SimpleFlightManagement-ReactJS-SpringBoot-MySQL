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

import airport.models.Plane;
import airport.service.PlaneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class PlaneController {
	
	@Autowired
    private PlaneService planeService;
	
	
	
	
	@GetMapping("/planes")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	 public List<Plane> list() {
		System.out.println();
		 return planeService.list();
	 }
	
	
	
	@GetMapping("/planes/id/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Plane getPlaneById(@PathVariable(value = "id") Long PilotId){
				return planeService.findById(PilotId);
	}
	
	
	@PostMapping("/planes")
	public long createPlane(@Validated @RequestBody Plane plane) {
		return planeService.save(plane);
	}
	
	
	@DeleteMapping("/planes/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deletePlane(@PathVariable(value = "id") Long PlaneId) {
		try {
			planeService.delete(PlaneId);
			return "plane supprimée";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	
	@DeleteMapping("/planes/all")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deletePlans() {
		try {
			planeService.deleteAll();
			return "plans supprimées";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	  
	  @PutMapping("/planes/{id}")
	  //@PreAuthorize("hasRole('ADMIN')")
	  public  ResponseEntity<Object> updatePlane(@PathVariable("id") long id, @RequestBody Plane plane) {
	 
	 
	    if (planeService.findById(id)!=null)  
	    {
	    	plane.setId(id);
	    	 return new ResponseEntity<>(planeService.save(plane), HttpStatus.OK);

	    }
	    else 
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  
	  }
	  
	  

}
