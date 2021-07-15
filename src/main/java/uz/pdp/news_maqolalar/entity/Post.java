package uz.pdp.news_maqolalar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.news_maqolalar.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends AbsEntity {

    @Column(columnDefinition = "text", nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String text;

    @Column(columnDefinition = "text", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "attachment_ID")
    private Attachment attachment;

}
