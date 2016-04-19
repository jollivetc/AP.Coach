package fr.apside.approjects.controller;

import fr.apside.approjects.dao.TrainingRepository;
import fr.apside.approjects.model.Training;
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
public class TrainingResourceTest {

    @InjectMocks
    private TrainingResource trainingResource;

    @Mock
    private TrainingRepository mockTrainingRepository;


    @Test
    public void shouldCallRepositoryAndReturnAllTrainings() {
        Iterable<Training> trainingIterable = new HashSet<Training>();
        when(mockTrainingRepository.findAll()).thenReturn(trainingIterable);

        Iterable<Training> resultIterable = trainingResource.findAll();

        assertThat(resultIterable).isEqualTo(trainingIterable);
        verify(mockTrainingRepository, times(1)).findAll();
    }
}
