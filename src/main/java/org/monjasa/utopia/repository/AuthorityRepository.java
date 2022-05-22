package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.permission.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query("select authority from Authority authority " +
            "join authority.positions position " +
            "where position.id = :positionId")
    List<Authority> findAllByEmployeePositionId(Long positionId);

}
