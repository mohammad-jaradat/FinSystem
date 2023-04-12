package edu.qou.financial;

import edu.qou.financial.gl.entities.UniversityInfo;
import edu.qou.financial.gl.repositories.UniversityInfoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@TestPropertySource("classpath:test.properties")
public class UniversityInfoRepositoryTest {

    @Autowired
    UniversityInfoRepository repository;

    @Test
    @Order(1)
    void injectedComponentsAreNotNull() {
        Assert.notNull(repository, "UniversityInfoRepository is null");
    }

    @Test
    @Order(2)
    void testAddUniversityInfo() {
        UniversityInfo universityInfo = new UniversityInfo(1L, "جامعة القدس المفتوحة", "Alquds Open University",
                "02-2423160", "02-2429861", "02-2421748", "02-2421748", "http://www.qou.edu",
                "plan_quality@qou.edu", "test pres name", "path to logo://", null);
        universityInfo = repository.save(universityInfo);
        Assert.notNull(universityInfo, "universityInfo is null.");
        Assert.isTrue(universityInfo.getUnivId() == 1L, "universityInfo bad id.");
    }

    @Test
    @Order(3)
    void testFindAll() {
        List<UniversityInfo> universityInfos = repository.findAll();
        Assert.isTrue(universityInfos.size() == 1, "UniversityInfo size is wrong.");
        Assert.isTrue(universityInfos.get(0).getUnivId() == 1L, "UniversityInfo bad id.");
    }

    @Test
    @Order(4)
    void testFindByAName() {
        UniversityInfo universityInfo = repository.findByUnivAName("جامعة القدس المفتوحة").get();
        Assert.isTrue(universityInfo.getUnivId() == 1L, "UniversityInfo bad name.");
    }

    @Test
    @Order(5)
    void testFindByEName() {
        UniversityInfo universityInfo = repository.findByUnivEName("Alquds Open University").get();
        Assert.isTrue(universityInfo.getUnivId() == 1L, "UniversityInfo bad name.");
    }

    @Test
    @Order(6)
    void testFindById() {
        UniversityInfo universityInfo = repository.findById(1L).get();
        Assert.notNull(universityInfo, "universityInfo not found.");
        Assert.isTrue(universityInfo.getUnivId() == 1L, "universityInfo bad id.");
    }
}