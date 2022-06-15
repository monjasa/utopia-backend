package org.monjasa.utopia.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity extends PersistableEntity {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected Instant createdAt;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    protected Instant lastModifiedAt;

}
