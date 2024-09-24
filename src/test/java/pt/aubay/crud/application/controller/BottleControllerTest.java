package pt.aubay.crud.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pt.aubay.crud.application.mapper.BottleMapper;
import pt.aubay.crud.application.model.BottleDTO;
import pt.aubay.crud.domain.model.Bottle;
import pt.aubay.crud.domain.repository.BottleRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class BottleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Autowired
  private BottleRepository repository;

  @Autowired
  private BottleMapper bottleMapper;

  @Test
  void testGet() throws Exception {
    this.mockMvc
        .perform(get(""))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void testGetById() throws Exception {
    Bottle plastic = Bottle.builder().height(10.0).volume(1.0).material("plastic").build();
    bottleMapper.toDTO(repository.save(plastic));
    this.mockMvc
        .perform(get("/" + plastic.getId()))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void testPost() throws Exception {
    BottleDTO plastic = BottleDTO.builder().height(10.0).volume(1.0).material("plastic").build();
    this.mockMvc
        .perform(post("")
            .content(mapper.writeValueAsBytes(plastic)).contentType(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isCreated())
        .andExpect(jsonPath("$.material").value("plastic"));
  }

  @Test
  void testPut() throws Exception {
    Bottle plastic = Bottle.builder().height(10.0).volume(1.0).material("plastic").build();
    BottleDTO dto = bottleMapper.toDTO(repository.save(plastic));
    dto.setMaterial("aluminum");

    this.mockMvc
        .perform(put("/" + dto.getId())
            .content(mapper.writeValueAsBytes(dto)).contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.material").value("aluminum"));
  }

}