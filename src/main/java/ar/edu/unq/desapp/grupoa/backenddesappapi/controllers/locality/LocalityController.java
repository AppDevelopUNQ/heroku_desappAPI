package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody.LocalityBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.locality.LocalityService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locality")
@CrossOrigin(origins = "*")
public class LocalityController {

    private @Autowired LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all localities",response = Locality.class, responseContainer = "List"),
    })
    public ResponseEntity<List>  listLocalities() {
        return new ResponseEntity<> (localityService.getLocalitiesDetails(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a locality",response = Locality.class),
    })
    public ResponseEntity<Locality> getLocality(@PathVariable Integer id) throws InvalidException {
        return new ResponseEntity<>(localityService.getById(id), HttpStatus.OK);
    }

    //ADD_ONE
    @PostMapping(value = "/", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> addLocality(@RequestBody LocalityBodyPost locality) throws InvalidOrNullFieldException {
        return new ResponseEntity<>(localityService.save(locality), HttpStatus.OK);
    }

    //Configurar datos de una localidad
    @PutMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a locality",response = Locality.class),
    })
    public ResponseEntity<Locality> update(@PathVariable Integer id, @RequestBody LocalityBodyPost locality) throws InvalidException, InvalidOrNullFieldException {
        return new ResponseEntity<>(localityService.updateLocality(id, locality), HttpStatus.OK);
    }

    //DELETE_ONE
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity deleteLocality(@PathVariable Integer id) throws InvalidException {
        localityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
