package kz.nurgalym.adminservice.dto;

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
public class ContentDto {

    private Long id;
    private Long announcementId;
    private Long mainMessageId;
    private List<ContentBodyDto> forClients;
    private Date createdDate;
    private Date updatedDate;
}
