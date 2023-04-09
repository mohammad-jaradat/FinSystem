package com.qou.edu.finsys.repositories;

import com.qou.edu.finsys.entities.Role;
import com.qou.edu.finsys.entities.UniversityInfo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityInfoRepository extends JpaRepository<UniversityInfo, Long> {

    UniversityInfo findByUnivAName(String univAName);

    @Override
    void delete(UniversityInfo universityInfo);

}
