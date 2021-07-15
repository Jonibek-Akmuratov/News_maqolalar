package uz.pdp.news_maqolalar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.news_maqolalar.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attachment")
@Entity
public class Attachment extends AbsEntity {


    private String orginalname;

    private String name;

    private Long size;

    private String contentType;
}