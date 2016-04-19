package fr.apside.approjects.controller;


import fr.apside.approjects.GenericControllerITest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonResourceITest extends GenericControllerITest {

    private static final String JSON_FOR_POST = "{ \"firstName\": \"Christophe\",\"lastName\": \"Jollivet\",\"email\": \"jollivet@apside.fr\",\"agency\": {\"id\": 1,\"name\": \"Apside TOP\"}}";
    private static final String JSON_FOR_PUT = "{ \"id\": 1, \"firstName\": \"Christophe\",\"lastName\": \"Jollivet\",\"email\": \"jollivet@apside.fr\",\"agency\": {\"id\": 1,\"name\": \"Apside TOP\"}}";

    @Test
    public void shouldReturnListOfPersons() throws Exception {
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
    }

    @Test
    public void shouldReturnAPersonFromId() throws Exception{
        mockMvc.perform(get("/persons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("email", equalToIgnoringCase("john.doe@apside.fr")))
                .andExpect(jsonPath("agency.name", equalToIgnoringCase("Apside TOP")));
    }

    @Test
    public void shouldDeletePersonFromId() throws Exception{
        mockMvc.perform(delete("/persons/5"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldCreatePerson() throws Exception{
        mockMvc.perform(post("/persons/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(JSON_FOR_POST))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", not(isEmptyOrNullString())));
    }

    @Test
    public void shouldUpdatePerson() throws Exception{
        mockMvc.perform(put("/persons/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON_FOR_PUT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName", equalToIgnoringCase("Christophe")));

    }

    @Test
    public void shouldThrow404IfPersonIsUnknown() throws Exception {
        mockMvc.perform((get("/persons/1111111111")))
                .andExpect(status().isNotFound());

    }

}