package edu.qou.financial.gl.repositories;

import edu.qou.financial.gl.entities.UniversityCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityCenterRepository extends JpaRepository<UniversityCenter, Long> {

    UniversityCenter findByCenterAName(String centerAName);

    @Override
    void delete(UniversityCenter universityCenter);

}
