package airport.repositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airport.models.*;

public interface PiloteRepository extends JpaRepository<Pilot, Long>{
   
   
 

}