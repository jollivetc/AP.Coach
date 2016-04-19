package fr.apside.approjects.controller;

import fr.apside.approjects.NotFoundException;
import fr.apside.approjects.dao.PersonRepository;
import fr.apside.approjects.model.GenericError;
import fr.apside.approjects.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("persons")
public class PersonResource {
    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    @Autowired
    private PersonRepository personRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public GenericError handleExceptionNotFoundException(NotFoundException ex) {
        LOG.warn("Error ", ex);
        return new GenericError(ex.getMessage());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "false")
    public Iterable<Person> findAll() {
        LOG.info("getting all persons");
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    @Transactional(value = "false")
    public Person findById(@PathVariable("id") String id) throws NotFoundException {
        LOG.info("getting person by id {}", id);
        Person person = personRepository.findOne((Long) Long.parseLong(id));
        if (person == null) {
            throw new NotFoundException("No person for id " + id);
        }
        return person;
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "true")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        LOG.info("creating a new Person");
        //FIXME check unique email
        return personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    @Transactional(value="true")
    public Person update (@RequestBody Person person, @PathVariable("id") String id){
        LOG.info("update person with id {}", person.getId());
        return personRepository.save(person);
    }

    @RequestMapping(method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    @Transactional(value = "true")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        LOG.info("deleting person with id {}", id);
        personRepository.delete(Long.parseLong(id));
    }

}


