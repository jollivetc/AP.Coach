package fr.apside.approjects.controller;


import fr.apside.approjects.NotFoundException;
import fr.apside.approjects.dao.SessionRepository;
import fr.apside.approjects.model.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SessionResourceTest {


    @InjectMocks
    private SessionResource sessionResource;

    @Mock
    private SessionRepository mockSessionRepository;

    @Test
    public void shouldCallRepositoryAndReturnAllSessions(){
        Iterable<Session> mockResult = new HashSet<Session>();
        when(mockSessionRepository.findAllWithAttendees()).thenReturn(mockResult);

        Iterable<Session> result = sessionResource.findAll();

        assertThat(result).isEqualTo(mockResult);
        verify(mockSessionRepository, times(1)).findAllWithAttendees();
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionWhenRepositoryReturnsNull() throws NotFoundException {

        when(mockSessionRepository.loadFullDetails(1L)).thenReturn(null);
        try {
            sessionResource.findById("1");
        }finally{
            verify(mockSessionRepository, times(1)).loadFullDetails(1L);
        }
    }

    @Test
    public void shouldCallRepositoryAndReturnProvidedSession() throws NotFoundException{
        Session session = new Session();
        when(mockSessionRepository.loadFullDetails(1L)).thenReturn(session);

        Session result = sessionResource.findById("1");

        assertThat(result).isEqualTo(session);
        verify(mockSessionRepository, times(1)).loadFullDetails(1L);
    }

}