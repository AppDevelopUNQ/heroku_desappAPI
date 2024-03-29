package ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;

import java.util.List;

public interface LocalityService {

    List<Locality> getLocalitiesDetails();

    Locality getById(Integer id) throws InvalidException;

    int save(LocalityBodyPost locality) throws InvalidOrNullFieldException;

    void delete(Integer id) throws InvalidException;

    Locality updateLocality(Integer localityId, LocalityBodyPost locality) throws InvalidException, InvalidOrNullFieldException;
}
