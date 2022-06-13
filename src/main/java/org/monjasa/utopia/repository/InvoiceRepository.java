package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.invoice.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Optional<Invoice> findByEventReservationUuid(String uuid);

    @EntityGraph(attributePaths = "payments")
    Optional<Invoice> findFetchingPaymentsByNumber(String number);

}
