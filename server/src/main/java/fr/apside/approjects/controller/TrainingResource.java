package fr.apside.approjects.controller;

import fr.apside.approjects.dao.TrainingRepository;
import fr.apside.approjects.model.GenericError;
import fr.apside.approjects.model.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trainings")
public class TrainingResource {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingResource.class);

    @Autowired
    private TrainingRepository trainingRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public GenericError handleExceptionNotFoundException(EmptyResultDataAccessException ex) {
        LOG.warn("Error ", ex);
        return new GenericError("Unknown Training");
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "false")
    public Iterable<Training> findAll(){
        LOG.info("getting all trainings");
        return trainingRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    public  Training findById(@PathVariable("id") String id){
        LOG.info("getting training with id {}", id);
        return trainingRepository.getById(Long.parseLong(id));
    }
}
