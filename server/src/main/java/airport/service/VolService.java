package airport.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airport.models.Pilot;
import airport.models.Plane;
import airport.models.Vol;

import airport.repositories.VolRepository;
@Service
@Transactional
public class VolService {
	
	@Autowired
	VolRepository repository;
	
	
	public List<Vol> list(){
		return repository.findAll(Sort.by("volnumber").ascending());
	}
	
	public Vol findById(long id) {
		try{
			return repository.findById(id).get();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<Vol> findByPilote(long id) {
		try{
			return repository.findByPilotId(id);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public long save( Vol vol,Long pilotId,Long planeId) {
		vol.setPilot(new Pilot(pilotId, null, null, null, 0, 0));
		vol.setPlane(new Plane(planeId, null, null, null, 0));
		return repository.save(vol).getId();
	}
	
	public long update( Vol vol,Long pilotId,Long volId,Long planeId) {
		 vol.setId(volId);
		 vol.setPilot(new Pilot(pilotId, null, null, null, 0, 0));
		 vol.setPlane(new Plane(planeId, null, null, null, 0));
		 return repository.save(vol).getId();
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}


}
