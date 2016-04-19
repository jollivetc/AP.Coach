package fr.apside.approjects.controller;


import fr.apside.approjects.NotFoundException;
import fr.apside.approjects.dao.AgencyRepository;
import fr.apside.approjects.model.Agency;
import fr.apside.approjects.model.GenericError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("agencies")
public class AgencyResource {

    private static final Logger LOG = LoggerFactory.getLogger(Agency.class);

    @Autowired
    private AgencyRepository agencyRepository;


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public GenericError handleExceptionNotFoundException(NotFoundException ex) {
        LOG.warn("Error ", ex);
        return new GenericError(ex.getMessage());
    }
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(value = "false")
    public Iterable<Agency> findAll(){
        LOG.info("getting all agencies");
        return agencyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id}")
    @Transactional(value = "false")
    public Agency findById(@PathVariable("id") String id) throws NotFoundException {
        LOG.info("getting agency for id {}", id);
        Agency agency = agencyRepository.findOne(Long.parseLong(id, 10));
        if (agency == null) {
            throw new NotFoundException("No Agency for id " + id);
        }
        return agency;
    }




}
