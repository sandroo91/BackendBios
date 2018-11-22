package bios.springframework.spring5webapp.Controllers;

import bios.springframework.spring5webapp.controllers.ZaalController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class ZaalControllerTest {

    private MockMvc mockMvc;

    private ZaalController zaalController;

    @Before
    public void setup(){
        zaalController = new ZaalController();
        mockMvc = MockMvcBuilders.standaloneSetup(zaalController).build();
    }

    @Test
    public void testZaal()throws Exception{
        mockMvc.perform(get("/localhost:8080/Zaal/getById"))
                .andExpect(status().isOk())
                .andExpect(view().name("Zaal"));
    }


}
