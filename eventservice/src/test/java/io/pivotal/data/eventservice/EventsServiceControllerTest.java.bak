package io.pivotal.data.eventservice;

import io.pivotal.data.eventservice.controllers.EventMetricsController;
import io.pivotal.data.eventservice.services.EventsService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cq on 17/9/15.
 */
public class EventsServiceControllerTest {

    @InjectMocks
    EventMetricsController controller;

    @Mock
    EventsService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void testTotalEvents() throws Exception {

        when(service.totalOfEvents()).thenReturn(300L);

        MvcResult response = mockMvc.perform(get("/events/total")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(response.getResponse().getContentAsString(), containsString("300"));
    }
}
