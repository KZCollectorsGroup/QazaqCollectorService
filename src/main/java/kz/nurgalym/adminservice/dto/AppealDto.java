package kz.nurgalym.adminservice.dto;

import kz.nurgalym.adminservice.model.AppealStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppealDto {

    private Long id;
    private AppealStatus appealStatus;
    private String text;
    private Date createdDate;
    private Date updatedDate;
}
