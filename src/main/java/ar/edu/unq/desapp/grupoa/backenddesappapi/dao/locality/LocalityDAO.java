package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalityDAO extends CrudRepository<Locality, Long> {
}
