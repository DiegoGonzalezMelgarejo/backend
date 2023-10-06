package com.backend.infrastructure.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.backend.util.Utilities.buildGetPriceByDateNoContentRequest;
import static com.backend.util.Utilities.buildGetPriceByDateRequest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String URL= "/price";

    private ObjectMapper objectMapper= new ObjectMapper();
    @SneakyThrows
    @Test
    void findPriceByBrandProductAndDate_ValidRequest(){
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(buildGetPriceByDateRequest())))
                .andExpect(status().isOk());

    }
    @SneakyThrows
    @Test
    void findPriceByBrandProductAndDate_ValidRequestNoContent(){
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(buildGetPriceByDateNoContentRequest())))
                .andExpect(status().isNoContent());

    }
    @SneakyThrows
    @Test
    void findPriceByBrandProductAndDate_NoValidDateNull(){
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(buildGetPriceByDateNoContentRequest().toBuilder().date(null).build())))
                .andExpect(status().is4xxClientError());
    }
    @SneakyThrows
    @Test
    void findPriceByBrandProductAndDate_NoValidBrandNull(){
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(buildGetPriceByDateNoContentRequest().toBuilder().idBrand(null).build())))
                .andExpect(status().is4xxClientError());
    }
    @SneakyThrows
    @Test
    void findPriceByBrandProductAndDate_NoValidProductNull(){
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(buildGetPriceByDateNoContentRequest().toBuilder().idProduct(null).build())))
                .andExpect(status().is4xxClientError());
    }
    private  String objectToJson(Object object) throws JsonProcessingException {
        return objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(object);
    }
}
