package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.wallet;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletDAO extends CrudRepository<Wallet, Long> {
}
