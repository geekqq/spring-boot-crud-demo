package stoni.me.studentcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private Date dateOfBirth;
}
