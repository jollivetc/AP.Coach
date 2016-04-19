package fr.apside.approjects.controller;

import fr.apside.approjects.GenericControllerITest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SessionResourceITest extends GenericControllerITest {

    @Test
    public void shouldReturnListOfSessions() throws Exception {
        mockMvc.perform(get("/sessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
    }

    @Test
    public void shouldReturnOneSessionWithCoachesAndAttendees() throws Exception{
        mockMvc.perform(get("/sessions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", equalTo(1)))
                .andExpect(jsonPath("coaches", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("attendees", hasSize(greaterThanOrEqualTo(1))));


    }
}
