package edu.qou.financial;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.qou.financial.gl.dtos.UniversityInfoDTO;
import edu.qou.financial.gl.entities.UniversityInfo;
import edu.qou.financial.gl.services.UniversityInfoService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource("classpath:test.properties")
public class UniversityInfoControllerTest {

    @MockBean
    UniversityInfoService universityInfoService;

    @Autowired
    MockMvc mockMvc;

    ModelMapper mapper;

    private static String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    @DisplayName("GET /api/admin/universities - Found")
    void universityInfoGetFoundTest() throws Exception {
        // Set up our mocked universityInfoService
        UniversityInfoDTO mockUniversityInfoDTO = new UniversityInfoDTO(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", null);
        doReturn(Optional.of(mockUniversityInfoDTO)).when(universityInfoService).getUniversityInfoBYId(1L);

        // Execute The GET request
        mockMvc.perform(get("/api/admin/universities/{universityId}"))
                // Validate the response code and content
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                // Validate the header
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/api/admin/universities/1"))
                // Validate the returned fields
                .andExpect(jsonPath("$.univId", is(1)))
                .andExpect(jsonPath("$.univAName", is("جامعة القدس المفتوحة")))
                .andExpect(jsonPath("$.univEName", is("Alquds Open University")))
                .andExpect(jsonPath("$.univWebsite", is("http://www.qou.edu")))
                .andExpect(jsonPath("$.univEmail", is("plan_quality@qou.edu")))
        ;
    }

    @Test
    @Order(2)
    @DisplayName("GET /api/admin/universities - NotFound")
    void universityInfoGetNotFoundTest() throws Exception {
        // Set up our mocked universityService
        doReturn(Optional.empty()).when(universityInfoService).getUniversityInfoBYId(1L);

        // Execute the GET request
        mockMvc.perform(get("/api/admin/universities/{universityId}", 1))

                // Validate that we get a 404 Not Found response code
                .andExpect(status().isNotFound());

    }

    @Test
    @Order(3)
    @DisplayName("POST /api/admin/universities - Success")
    void UniversityInfoPostSuccessTest() throws Exception {
        // Set up our mocked universityInfoService
        UniversityInfoDTO postUniversityInfoDTO = new UniversityInfoDTO(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", new HashSet<>());
        UniversityInfo universityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", null);
        UniversityInfoDTO mockUniversityInfoDTO = mapper.map(universityInfo, UniversityInfoDTO.class);

        doReturn(mockUniversityInfoDTO).when(universityInfoService).addUniversityInfo(any());

        // Execute The POST request
        mockMvc.perform(post("/api/admin/universities")
                        .contentType(APPLICATION_JSON)
                        .content(asJsonString(postUniversityInfoDTO)))

                // Validate the response code and content
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))

                // Validate the header
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/api/admin/universities/1"))

                // Validate the returned fields
                .andExpect(jsonPath("$.univId", is(1)))
                .andExpect(jsonPath("$.univAName", is("جامعة القدس المفتوحة")))
                .andExpect(jsonPath("$.univEName", is("Alquds Open University")))
                .andExpect(jsonPath("$.univWebsite", is("http://www.qou.edu")))
                .andExpect(jsonPath("$.univEmail", is("plan_quality@qou.edu")));
    }

    @Test
    @Order(4)
    @DisplayName("PUT /api/admin/universities - Success")
    void universityInfoPutSuccessTest() throws Exception {
        // Set up our mocked universityInfoService
        UniversityInfoDTO putUniversityInfoDTO = new UniversityInfoDTO(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "00-0000000", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "updatedEmail@qou.edu", "test pres name", "path to logo://", new HashSet<>());
        UniversityInfo universityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", null);
        UniversityInfoDTO mockUniversityInfoDTO = mapper.map(universityInfo, UniversityInfoDTO.class);


        doReturn(Optional.of(mockUniversityInfoDTO)).when(universityInfoService).getUniversityInfoBYId(1L);
        doReturn(mockUniversityInfoDTO).when(universityInfoService).updateUniversityInfo(1L, any());

        // Execute The PUT request
        mockMvc.perform(put("/api/admin/universities/{universityId}", 1)
                        .contentType(APPLICATION_JSON)
                        .header(HttpHeaders.IF_MATCH, 1)
                        .content(asJsonString(putUniversityInfoDTO)))

                // Validate the response code and content
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))

                // Validate the header
                .andExpect(header().string(HttpHeaders.ETAG, "\"2\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/api/admin/universities/1"))

                // Validate the returned fields
                .andExpect(jsonPath("$.univId", is(1)))
                .andExpect(jsonPath("$.univAName", is("جامعة القدس المفتوحة")))
                .andExpect(jsonPath("$.univEName", is("Alquds Open University")))
                .andExpect(jsonPath("$.univTel1", is("00-0000000")))
                .andExpect(jsonPath("$.univWebsite", is("http://www.qou.edu")))
                .andExpect(jsonPath("$.univEmail", is("updatedEmail@qou.edu")));

    }

    @Test
    @Order(5)
    @DisplayName("PUT /api/admin/universities - Not Found")
    void universityInfoPutNotFoundTest() throws Exception {

        // Set up our mocked universityInfoService
        UniversityInfoDTO putUniversityInfoDTO = new UniversityInfoDTO(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "00-0000000", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "updatedEmail@qou.edu", "test pres name", "path to logo://", new HashSet<>());

        doReturn(Optional.empty()).when(universityInfoService).getUniversityInfoBYId(1L);

        // Execute The PUT request
        mockMvc.perform(put("/api/admin/universities/{universityId}", 1)
                        .contentType(APPLICATION_JSON)
                        .header(HttpHeaders.IF_MATCH, 1)
                        .content(asJsonString(putUniversityInfoDTO)))

                // Validate the response code and content
                .andExpect(status().isNotFound());

    }

    @Test
    @Order(6)
    @DisplayName("DELETE /api/admin/universities - Success")
    void universityInfoDeleteSuccessTest() throws Exception {
        // Set up our mocked universityInfoService
        UniversityInfoDTO mockUniversityInfoDTO = new UniversityInfoDTO(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "00-0000000", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", new HashSet<>());

        doReturn(Optional.of(mockUniversityInfoDTO)).when(universityInfoService).getUniversityInfoBYId(1L);
        doReturn(mockUniversityInfoDTO).when(universityInfoService).deleteUniversityInfo(any());

        // Execute DELETE request
        mockMvc.perform(delete("/api/admin/universities/{universityId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("University with Id " + 1 + " deleted successfully."));
    }

    @Test
    @Order(7)
    @DisplayName("DELETE /api/admin/universities - Not Found")
    void universityInfoDeleteNotFoundTest() throws Exception {
        // Set up our mocked universityInfoService
        doReturn(Optional.empty()).when(universityInfoService).getUniversityInfoBYId(1L);

        // Execute the DELETE request
        mockMvc.perform(delete("/api/admin/universities/{universityId}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(8)
    @DisplayName("DELETE /api/admin/universities - Failure")
    void universityInfoDeleteFailureTest() throws Exception {
        // Set up our mocked universityInfoService
        UniversityInfo universityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", null);
        UniversityInfoDTO mockUniversityInfoDTO = mapper.map(universityInfo, UniversityInfoDTO.class);

        doReturn(Optional.of(mockUniversityInfoDTO)).when(universityInfoService).getUniversityInfoBYId(1L);
        doReturn(Boolean.FALSE).when(universityInfoService).deleteUniversityInfo(1L);

        // Execute the DELETE request
        mockMvc.perform(delete("/api/admin/universities/{universityId}", 1))

                // Validate the response code and content
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("update failed."));
    }
}
