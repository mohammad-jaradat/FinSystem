package com.qou.edu.finsys.gl.repositories;

import com.qou.edu.finsys.gl.entities.UniversityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UniversityCenterRepository extends JpaRepository<UniversityCenter, Long> {

    UniversityCenter findByCenterAName(String centerAName);

    @Override
    void delete(UniversityCenter universityCenter);

}
