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
public class MessageDto {

    private Long id;
    private String messageText;
    private Date createdDate;
    private Date updatedDate;
    private String accountName;
    private Long appealId;
}
