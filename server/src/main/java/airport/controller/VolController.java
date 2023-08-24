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

import airport.models.Vol;
import airport.service.VolService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class VolController {
	
	@Autowired
    private VolService volService; 
	
	
	
	
	@GetMapping("/vols")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	 public List<Vol> list() {
		System.out.println();
		 
		return volService.list();
	 }
	
	
	
	@GetMapping("/vols/pilote/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	 public List<Vol> findAllByPilote(@PathVariable(value = "id") Long id) {
		 return (List<Vol>) volService.findByPilote(id);
		 
	 }
	
	
	
	
	
	
	@GetMapping("/vols/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Vol getVolById(@PathVariable(value = "id") Long volId){
				return volService.findById(volId);
	}
	
	@PostMapping("/vols/{idp}/{idplane}")
	//@PreAuthorize("hasRole('ADMIN')")
	public long createVol(@Validated @RequestBody Vol vol,@PathVariable(value = "idp") Long piloteId,@PathVariable(value = "idplane") Long planeId) {
		
		return volService.save(vol,piloteId,planeId);
	}
	@DeleteMapping("/vols/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deleteVol(@PathVariable(value = "id") Long volId) {
		try {
			volService.delete(volId);
			return "vol supprimée";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	
	@DeleteMapping("/vols/all")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deleteVols() {
		try {
			volService.deleteAll();
			return "vols supprimées";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}
	  
	  @PutMapping("/vols/{idp}/idplane/{idvol}")
	  @PreAuthorize("hasRole('ADMIN')")
	  public  ResponseEntity<Object> updateVol(@PathVariable("idp") long idp,@RequestBody Vol vol,@PathVariable("idvol") long id,@PathVariable(value = "idplane") Long planeId) {
	 
	 
	    if (volService.findById(id)!=null)  
	    {
	    	
	    	
	    	 return new ResponseEntity<>(volService.update(vol,idp,id,planeId), HttpStatus.OK);

	    }
	    else 
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  
	  }
	  

}
