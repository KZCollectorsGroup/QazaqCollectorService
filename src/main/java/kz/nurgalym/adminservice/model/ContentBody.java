package kz.nurgalym.adminservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Entity
@Table(name = "content_body")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class ContentBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kz_lang_id", insertable = false, updatable = false)
    private ContentBodyLang kz;

    @Column(name = "kz_lang_id", nullable = false) // Внешний ключ на Content
    private Long kzId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ru_lang_id", insertable = false, updatable = false)
    private ContentBodyLang ru;

    @Column(name = "ru_lang_id", nullable = false) // Внешний ключ на Content
    private Long ruId;

    @ManyToOne
    @JoinColumn(name = "content_id", insertable = false, updatable = false) // Внешний ключ на Content
    private Content content;

    @Column(name = "content_id") // Внешний ключ на Content
    private Long contentId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
