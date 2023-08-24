package airport.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airport.models.Plane;
import airport.repositories.PlaneRepository;
@Service
@Transactional
public class PlaneService {
	
	@Autowired
	PlaneRepository repository;
	
	
	public List<Plane> list(){
		return repository.findAll(Sort.by("label").ascending());
	}
	
	public Plane findById(long id) {
		try{
			return repository.findById(id).get();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public long save( Plane plane) {
		 return repository.save(plane).getId();
	}
	
	
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}


}
