package airport.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airport.models.Pilot;
import airport.repositories.PiloteRepository;
@Service
@Transactional
public class PilotService {
	
	@Autowired
	PiloteRepository repository;
	
	
	public List<Pilot> list(){
		return repository.findAll(Sort.by("firstName").ascending());
	}
	
	public Pilot findById(long id) {
		try{
			return repository.findById(id).get();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public long save( Pilot pilot) {
		 return repository.save(pilot).getId();
	}
	
	
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}


}
