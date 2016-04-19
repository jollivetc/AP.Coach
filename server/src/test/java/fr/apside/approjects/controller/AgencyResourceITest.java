package fr.apside.approjects.controller;


import fr.apside.approjects.GenericControllerITest;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AgencyResourceITest extends GenericControllerITest {

    @Test
    public void shouldReturnListOfAgencies() throws Exception {
        mockMvc.perform(get("/agencies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldReturnAnAgencyWithoutContacts() throws Exception {
        mockMvc.perform(get("/agencies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", equalToIgnoringWhiteSpace("Apside TOP")))
                .andExpect(jsonPath("contacts", isEmptyOrNullString()));
    }

    @Test
    public void shouldReturn404WhenAgencyIsUnknown() throws Exception {
        mockMvc.perform(get("/agencies/10000"))
                .andExpect(status().isNotFound());
    }

}