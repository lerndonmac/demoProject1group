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
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private char genderCode;
    @Column(name = "Name")
    private String genderName;

    public Gender(String genderName) {
        this.genderName = genderName;
    }

    @Override
    public String toString(){
        return genderName ;
    }

}
