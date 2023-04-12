package edu.qou.financial.gl.repositories;

import edu.qou.financial.gl.entities.UniversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UniversityInfoRepository extends JpaRepository<UniversityInfo, Long> {

    Optional<UniversityInfo> findByUnivAName(String univAName);
    Optional<UniversityInfo> findByUnivEName(String univEName);

    @Override
    void delete(UniversityInfo universityInfo);

}
