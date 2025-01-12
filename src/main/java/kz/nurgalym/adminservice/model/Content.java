package kz.nurgalym.adminservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "content")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", insertable = false, updatable = false)
    private ContentBody announcement;

    @Column(name = "announcement_id")
    private Long announcementId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_message_id", insertable = false, updatable = false)
    private ContentBody mainMessage;

    @Column(name = "main_message_id")
    private Long mainMessageId;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    private List<ContentBody> forClients;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
