package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Setter@Getter
@Table(name = "gender")
public class Gender {
    @Id
    @Column(name = "Code")
    private char genderCode;
    @Column(name = "Name")
    private String genderName;

    @Override
    public String toString(){
        return genderName ;
    }

}
