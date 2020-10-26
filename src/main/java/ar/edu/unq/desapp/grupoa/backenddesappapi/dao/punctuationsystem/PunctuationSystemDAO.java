package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.punctuationsystem;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunctuationSystemDAO extends CrudRepository<PunctuationSystem, Long> {
}
