package com.example.demo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.demo.models.Capital;
import com.example.demo.repositories.CapitalRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CapitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CapitalRepository mockRepository;

    @BeforeEach
    public void init() {

        Capital c1 = new Capital("Buenos Aires", 1L);
        Capital c2 = new Capital("Santiago", 2L);
        Capital c3 = new Capital("Lima", 3L);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(c1, c2, c3));
    }

    @Test
    public void wrongURLShouldNotBeFound() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fdsfsfs").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    //Pga MockBean läggs inte Ankara in i databasen
    @Test
    public void addCapitalTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/add?name=Ankara").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Ankara is Saved")));
    }

    @Test
    public void getByIdTest1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/getById?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Buenos Aires\"}"));
    }

    /*

    //Har man ett Mockat repo på ovanstående sätt kommer man inte längre åt sit vanliga repo
    //Denna metod funkar om det mockade repot och Setup:en tas bort (förutsatt att staden med id=2 fortfarande är Oslo), inte annars
    @Test
    public void getByIdTest2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/getById?id=2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Oslo\"}"));
    }

     */

    @Test
    public void findAllTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Buenos Aires\"}," +
                        "{\"id\":2,\"name\":\"Santiago\"},{\"id\":3,\"name\":\"Lima\"}]"));
    }



}