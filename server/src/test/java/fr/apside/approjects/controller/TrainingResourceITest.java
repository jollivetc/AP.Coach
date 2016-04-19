package fr.apside.approjects.controller;

import fr.apside.approjects.GenericControllerITest;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TrainingResourceITest extends GenericControllerITest {

    @Test
    public void shouldReturnListOfTraining() throws Exception {
        mockMvc.perform(get("/trainings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldReturnATrainingById() throws Exception{
        mockMvc.perform(get("/trainings/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", equalToIgnoringCase("angular js")))
                .andExpect(jsonPath("sessions", hasSize(2)));

    }

}