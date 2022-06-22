package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Long> {
}
