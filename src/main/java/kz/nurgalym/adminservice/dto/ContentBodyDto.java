package kz.nurgalym.adminservice.dto;

import jakarta.persistence.*;
import kz.nurgalym.adminservice.model.Content;
import kz.nurgalym.adminservice.model.ContentBody;
import kz.nurgalym.adminservice.model.ContentBodyLang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentBodyDto {

    private Long id;
    private Long kzId;
    private Long ruId;
    private Long contentId;
    private Date createdDate;
    private Date updatedDate;
}
