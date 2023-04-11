package com.qou.edu.finsys.gl.repositories;

import com.qou.edu.finsys.gl.entities.UniversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface UniversityInfoRepository extends JpaRepository<UniversityInfo, Long> {

    Optional<UniversityInfo> findByUnivAName(String univAName);
    Optional<UniversityInfo> findByUnivEName(String univEName);

    @Override
    void delete(UniversityInfo universityInfo);

}
