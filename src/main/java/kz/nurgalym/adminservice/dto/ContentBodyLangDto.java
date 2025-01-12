package kz.nurgalym.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentBodyLangDto {

    private Long id;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;
}
