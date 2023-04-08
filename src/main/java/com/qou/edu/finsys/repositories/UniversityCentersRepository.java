package com.qou.edu.finsys.repositories;

import com.qou.edu.finsys.entities.UniversityCenters;
import com.qou.edu.finsys.entities.UniversityInfo;
import com.qou.edu.finsys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityCentersRepository extends JpaRepository<UniversityCenters, Long> {

    UniversityCenters findByCenterAName(String centerAName);

    @Override
    void delete(UniversityCenters universityCenters);

}
