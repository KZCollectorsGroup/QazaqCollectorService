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
public class UserDto {

    private Long id;
    private String iin;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String type;
    private boolean active;
    private boolean archive;
    private Date createdDate;
    private Date updatedDate;
}
