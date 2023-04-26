package edu.qou.financial;

import edu.qou.financial.common.AppConstants;
import edu.qou.financial.gl.dtos.UniversityInfoDTO;
import edu.qou.financial.gl.entities.UniversityInfo;
import edu.qou.financial.gl.repositories.UniversityInfoRepository;
import edu.qou.financial.gl.services.UniversityInfoService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource("classpath:test.properties")
public class UniversityInfoServiceTest {
    /***
     * The service that we want to test
     */
    @Autowired
    UniversityInfoService universityInfoService;
    /***
     * A mock version of UniversityInfoRepository which will use in this test
     */
    @MockBean
    UniversityInfoRepository universityInfoRepository;

    @Autowired
    ModelMapper modelMapper;

    Integer pageNumber = Integer.getInteger(AppConstants.PAGE_NUMBER);
    Integer pageSize = Integer.getInteger(AppConstants.PAGE_SIZE);
    String sortBy = AppConstants.SORT_USERS_BY;
    String sortOrder = AppConstants.SORT_DIR;

    @Nested
    @DisplayName("Get university Info Test")
    public class GetEmployeeTest {

        @Nested
        @DisplayName("Given That universityInfo exists")
        public class Exists {

            UniversityInfo mockUniversityInfo;
            UniversityInfoDTO mockUniversityInfoDTO;

            @BeforeEach
            void setup() {
                mockUniversityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                        "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                        "plan_quality@qou.edu", "test pres name", "path to logo://", null);
                mockUniversityInfoDTO = modelMapper.map(mockUniversityInfo, UniversityInfoDTO.class);
            }

            @Test
            @DisplayName("Then the universityInfo record should return")
            void getUniversityInfoSuccessTest() {
                // Setup our mock

                doReturn(Optional.of(mockUniversityInfoDTO)).when(universityInfoRepository).findById(1L);

                // execute the service call
                Optional<UniversityInfoDTO> optionalUniversityInfoDTO = Optional.of(universityInfoService.getUniversityInfoBYId(1L));

                // assert the response
                assertTrue(optionalUniversityInfoDTO.isPresent(), "university info was not found");
                assertSame(mockUniversityInfoDTO, optionalUniversityInfoDTO.get(), "UniversityInfoDTO should be the same");
            }
        }

        @Nested
        @DisplayName("Given That universityInfo not exists")
        public class NotExists {

            UniversityInfo mockUniversityInfo;
            UniversityInfoDTO mockUniversityInfoDTO;

            @BeforeEach
            void setup() {
                mockUniversityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                        "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                        "plan_quality@qou.edu", "test pres name", "path to logo://", null);
                mockUniversityInfoDTO = modelMapper.map(mockUniversityInfo, UniversityInfoDTO.class);
            }

            @Test
            @DisplayName("Then return empty")
            void getUniversityInfoNotFoundTest() {
                // Setup our mock
                doReturn(Optional.empty()).when(universityInfoRepository).findById(any());

                // execute the service call
                Optional<UniversityInfoDTO> optionalUniversityInfo = Optional.of(universityInfoService.getUniversityInfoBYId(1L));

                // assert the response
                assertFalse(optionalUniversityInfo.isPresent(), "UniversityInfo was found, when it shouldn't be");
            }
        }

        @Nested
        @DisplayName("Given That many universitiesInfo are exists")
        public class AllExists {

            List<UniversityInfoDTO> mockUniversityInfoDTOList = new ArrayList<>();

            @BeforeEach
            void setup() {
                UniversityInfo universityInfo1 = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                        "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                        "plan_quality@qou.edu", "test pres name", "path to logo://", new HashSet<>());
                UniversityInfo universityInfo2 = new UniversityInfo(2L, "جامعةاخرى", "other University",
                        "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.oth.edu",
                        "plan_quality@oth.edu", "test pres name", "path to logo://", new HashSet<>());
                mockUniversityInfoDTOList.add(modelMapper.map(universityInfo1, UniversityInfoDTO.class));
                mockUniversityInfoDTOList.add(modelMapper.map(universityInfo2, UniversityInfoDTO.class));
            }

            @Test
            @DisplayName("Then return a list of universities")
            void getUniversityInfoListSuccessTest() throws TimeoutException {
                // Setup our mock
                doReturn(mockUniversityInfoDTOList).when(universityInfoRepository).findAll();

                // execute the service call
                List<UniversityInfoDTO> universityInfoDTOList = universityInfoService.getAllUniversitiesInfo(pageNumber, pageSize, sortBy, sortOrder).getContent();

                // assert the response
                assertFalse(universityInfoDTOList.isEmpty(), "UniversityInfoDTO list was empty, when shouldn't");
                assertSame(mockUniversityInfoDTOList, universityInfoDTOList, "UniversityInfoDTO should be the same");
                Assertions.assertTrue(() -> universityInfoDTOList.size() > 1);
            }
        }


        @Nested
        @DisplayName("Given That no universities are exists")
        public class AllNotExists {

            List<UniversityInfoDTO> mockUniversityInfoDTOList;

            @BeforeEach
            void setup() {
                mockUniversityInfoDTOList = new ArrayList<>();
            }

            @Test
            @DisplayName("Then return empty")
            void getUniversitiesListNotFoundTest() throws TimeoutException {
                // Setup our mock
                doReturn(mockUniversityInfoDTOList).when(universityInfoRepository).findAll();

                // execute the service call
                List<UniversityInfoDTO> universityInfoDTOS = universityInfoService.getAllUniversitiesInfo(pageNumber, pageSize, sortBy, sortOrder).getContent();

                // assert the response
                assertTrue(universityInfoDTOS.isEmpty(), "universityInfoDTOS list should be empty");
            }
        }

    }


    @Nested
    @DisplayName("Add New UniversityInfo Test")
    public class AddUniversityInfoTest {

        @Nested
        @DisplayName("Given the valid data")
        public class SuccessAdd {

            UniversityInfo universityInfo;
            UniversityInfoDTO mockUniversityInfoDTO;
            UniversityInfoDTO universityInfoDTO;

            @BeforeEach
            void setup() {
                universityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                        "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                        "plan_quality@qou.edu", "test pres name", "path to logo://", null);

                universityInfoDTO = modelMapper.map(universityInfo, UniversityInfoDTO.class);
                mockUniversityInfoDTO = universityInfoDTO;

            }

            @Test
            @DisplayName("Then UniversityInfo successfully inserted and return added entity")
            void addUniversityInfoSuccess() {
                // Setup our mock
                doReturn(mockUniversityInfoDTO).when(universityInfoRepository).save(any());

                // execute the service call
                UniversityInfoDTO returnUniversityInfoDTO = universityInfoService.addUniversityInfo(universityInfoDTO);

                // assert the response
                assertNotNull(returnUniversityInfoDTO, "university should be not null");
                assertEquals(1, returnUniversityInfoDTO.getUnivId().intValue(), "The ID for a new University should be 1");
            }
        }

        @Nested
        @DisplayName("Given the InValid data")
        public class Failed {

            UniversityInfoDTO mockUniversityInfoDTO;

            @BeforeEach
            void setup() {
            }

            @Test
            @DisplayName("Then Insert Failed")
            void AddUniversityInfoFailureTest() {
                doReturn(mockUniversityInfoDTO).when(universityInfoRepository).save(any());
                // assert return
                assertNull(universityInfoService.addUniversityInfo(mockUniversityInfoDTO), " service must return null");

            }
        }

    }

}
