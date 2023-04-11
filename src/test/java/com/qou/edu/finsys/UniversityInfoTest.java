package com.qou.edu.finsys;

import com.qou.edu.finsys.gl.entities.UniversityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityInfoTest {
        @Test
        @DisplayName("Within University Creation")
        void createUniversityTest() {
            UniversityInfo universityInfo = new UniversityInfo();
            assertNotNull(universityInfo);
        }

        @Test
        @DisplayName("Within Constructor Throws")
        void universityInfoSetterTest() {
            assertDoesNotThrow(() -> {
                UniversityInfo universityInfo = new UniversityInfo();
                universityInfo.setUnivId(1L);
                universityInfo.setUnivAName("جامعة القدس المفتوحة");
                universityInfo.setUnivEName("Alquds Open University");
                universityInfo.setUnivTel1("02-2423160");
                universityInfo.setUnivTel2("02-2429861");
                universityInfo.setUnivFax1("02-2421748");
                universityInfo.setUnivFax2("02-2421748");
                universityInfo.setUnivWebsite("http://www.qou.edu");
                universityInfo.setUnivEmail("plan_quality@qou.edu");
                universityInfo.setUnivPresName("test pres name");
                universityInfo.setUnivLogo("path to logo://");
            });
        }

        @Test
        @DisplayName("Within Getter Methods")
        void universityInfoGetterTest() {
            UniversityInfo universityInfo = new UniversityInfo(1L,"جامعة القدس المفتوحة","Alquds Open University",
                    "02-2423160", "02-2429861", "02-2421748","02-2421748","http://www.qou.edu",
                    "plan_quality@qou.edu","test pres name","path to logo://");

            assertEquals("UniversityInfo(univId=1, univAName=جامعة القدس المفتوحة, univEName=Alquds Open University, " +
                    "univTel1=02-2423160, univTel2=02-2429861, univFax1=02-2421748, univFax2=02-2421748, univWebsite=http://www.qou.edu, " +
                    "univEmail=plan_quality@qou.edu, univPresName=test pres name, univLogo=path to logo://)", universityInfo.toString());
        }
    }