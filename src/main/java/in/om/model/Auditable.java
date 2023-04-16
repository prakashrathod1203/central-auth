package in.om.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

	@ApiModelProperty(hidden = true)
	@CreatedBy
    @Column(name = "created_by", updatable = false)
    private U createdBy;

	@ApiModelProperty(hidden = true)
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

	@ApiModelProperty(hidden = true)
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;

	@ApiModelProperty(hidden = true)
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    
}
