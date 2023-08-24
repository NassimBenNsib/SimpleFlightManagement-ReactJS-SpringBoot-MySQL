package airport.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import airport.models.*;

public interface VolRepository extends JpaRepository<Vol, Long>{
   
	public List<Vol> findByPilotId(Long id);

 

}