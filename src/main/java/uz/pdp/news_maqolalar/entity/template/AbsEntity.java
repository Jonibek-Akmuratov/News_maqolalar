package uz.pdp.news_maqolalar.entity.template;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.pdp.news_maqolalar.entity.User;
import uz.pdp.news_maqolalar.entity.enums.Permission;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createAt;


    @UpdateTimestamp
    private Timestamp updateAt;

    @JoinColumn(updatable = false)
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @JoinColumn(updatable = false)
    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;


}
