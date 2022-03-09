package hu.alkfejl.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter @Setter
public class Contact implements Serializable {

    private int id;
    private String name;
    private String email;
    private List<Phone> phones;
    private String address;
    private LocalDate dateOfBirth;
    private String company;
    private String position;
}
