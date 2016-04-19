package fr.apside.approjects.controller;

import fr.apside.approjects.NotFoundException;
import fr.apside.approjects.dao.SessionRepository;
import fr.apside.approjects.model.GenericError;
import fr.apside.approjects.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sessions")
public class SessionResource {

    private static final Logger LOG = LoggerFactory.getLogger(SessionResource.class);

    @Autowired
    private SessionRepository sessionRepository;


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public GenericError handleExceptionNotFoundException(Exception ex) {
        LOG.info("Error ", ex);
        return new GenericError("Unknown Session");
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="hello")
    public @ResponseBody String sayHello(){
        return "Hello Breizhcamp";
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "false")
    public @ResponseBody Iterable<Session> findAll() {
        LOG.info("getting all sessions");
        return sessionRepository.findAllWithAttendees();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="coming")
    @Transactional(value = "false")
    public @ResponseBody Iterable<Session> findComingSessions(){
        LOG.info("looking for coming sessions");
        return sessionRepository.findComingSessions();
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    @Transactional(value = "false")
    public @ResponseBody Session findById(@PathVariable("id") String id) throws NotFoundException {
        LOG.info("getting session with id {}", id);
        Session one = sessionRepository.loadFullDetails(Long.parseLong(id));
        if(one == null){
            throw new NotFoundException("no session for id " + id);
        }
        return one;
    }




    @RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "true")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Session create(@RequestBody Session session){
        LOG.info("createing new session");
        return sessionRepository.save(session);
    }

    @RequestMapping(method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    @Transactional(value = "true")
    public @ResponseBody Session update(@RequestBody Session session){
        LOG.info("createing new session");
        return sessionRepository.save(session);
    }
}

