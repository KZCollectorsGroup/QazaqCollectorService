package kz.nurgalym.adminservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Entity
@Table(name = "apeals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppealStatus appealStatus;

    @Column(name = "text")
    private String text;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
