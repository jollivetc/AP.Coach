package fr.apside.approjects.controller;


import fr.apside.approjects.NotFoundException;
import fr.apside.approjects.dao.AgencyRepository;
import fr.apside.approjects.model.Agency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AgencyResourceTest {

    @InjectMocks
    private AgencyResource agencyResource;

    @Mock
    private AgencyRepository mockAgencyRepository;


    @Test
    public void shouldCallRepositoryForList(){
        Iterable<Agency> agencyList = new ArrayList<Agency>();
        Mockito.when(mockAgencyRepository.findAll()).thenReturn(agencyList);

        Iterable<Agency> agencies = agencyResource.findAll();

        assertThat(agencies).isEqualTo(agencyList);
        verify(mockAgencyRepository, times(1)).findAll();
    }

    @Test
    public void shouldCallRepositoryFindOneForOneAgency() throws NotFoundException {
        Agency agency = new Agency();
        Mockito.when(mockAgencyRepository.findOne(1L)).thenReturn(agency);

        Agency agencyByID = agencyResource.findById("1");

        assertThat(agencyByID).isEqualTo(agency);
    }




}