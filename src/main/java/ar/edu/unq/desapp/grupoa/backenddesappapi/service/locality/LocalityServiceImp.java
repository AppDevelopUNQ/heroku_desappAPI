package ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityServiceImp implements LocalityService {

    private @Autowired LocalityDAO localityDAO;

    @Override
    public List<Locality> getLocalitiesDetails() {
        return (List<Locality>) localityDAO.findAll();
    }

    @Override
    public Locality getById(Integer id) throws InvalidIdException {
        Long value = Long.valueOf(id);
        this.validateId(value);
        return localityDAO.findById(value).orElse(new Locality());
    }

    private void validateId(Long value) throws InvalidIdException {
        if (!localityDAO.existsById(value)){
            throw new InvalidIdException(value);
        }
    }

    @Override
    public int save(LocalityBodyPost body) throws InvalidOrNullFieldException {
        Locality newLocality = new Locality();
        this.validateBody(body);
        return localityDAO.save(newLocality.setBody(body)).getId().intValue();
    }

    private void validateBody(LocalityBodyPost body) throws InvalidOrNullFieldException {
        this.validateName(body.getName());
        this.validateProvince(body.getProvince());
        this.validatePopulation(body.getPopulation());
    }

    private void validatePopulation(Integer population) throws InvalidOrNullFieldException {
        if(population == null || population == 0) {
            throw new InvalidOrNullFieldException("population");
        }
    }

    private void validateProvince(String province) throws InvalidOrNullFieldException {
        if(province == null || province.equals("")) {
            throw new InvalidOrNullFieldException("province");
        }
    }

    private void validateName(String name) throws InvalidOrNullFieldException {
        if(name == null || name.equals("")) {
            throw new InvalidOrNullFieldException("name");
        }
    }

    @Override
    public void delete(Integer id) throws InvalidIdException {
        Long value = Long.valueOf(id);
        validateId(value);
        localityDAO.deleteById(value);
    }
}
