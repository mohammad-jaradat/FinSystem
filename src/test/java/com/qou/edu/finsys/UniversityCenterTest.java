package com.qou.edu.finsys;

import com.qou.edu.finsys.gl.entities.UniversityCenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityCenterTest {
        @Test
        @DisplayName("Within University Center Creation")
        void createUniversityCenterTest() {
            UniversityCenter universityCenter = new UniversityCenter();
            assertNotNull(universityCenter);
        }

        @Test
        @DisplayName("Within Constructor Throws")
        void universityCenterSetterTest() {
            assertDoesNotThrow(() -> {
                UniversityCenter universityCenter = new UniversityCenter();
                universityCenter.setCenterNo(1L);
                universityCenter.setCenterAName("فرع رام الله");
                universityCenter.setCenterEName("Ramallah Branch");
                universityCenter.setCenterTel1("02-2423160");
                universityCenter.setCenterTel2("02-2429861");
                universityCenter.setCenterFax1("02-2421748");
                universityCenter.setCenterFax2("02-2421748");
                universityCenter.setCenterAddress("رام الله - عين مصباح");
                universityCenter.setCenterEmail("ramallah_branch@qou.edu");
                universityCenter.setIsActive(Boolean.TRUE);
                universityCenter.setCreatedBy("test_user");
                universityCenter.setCreatedDate(new Date());
            });
        }

        @Test
        @DisplayName("Within Getter Methods")
        void universityCenterGetterTest() {
            UniversityCenter universityCenter = new UniversityCenter(1L,"فرع رام الله","Ramallah Branch",
                    "02-2423160", "02-2429861", "02-2421748","02-2421748","رام الله - عين مصباح",
                    "ramallah_branch@qou.edu",Boolean.TRUE,"test_user",new Date(),null);

            assertEquals("UniversityCenter(centerNo=1, centerAName=فرع رام الله, centerEName=Ramallah Branch, " +
                    "centerTel1=02-2423160, centerTel2=02-2429861, centerFax1=02-2421748, centerFax2=02-2421748, centerAddress=رام الله - عين مصباح, " +
                    "centerEmail=ramallah_branch@qou.edu, isActive=true, createdBy=test_user, createdDate=" +
                    new Date()+", universityCenters=null)", universityCenter.toString());
        }
    }