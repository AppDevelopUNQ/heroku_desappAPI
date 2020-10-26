package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.donation;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationDAO extends CrudRepository<Donation, Long> {
}
