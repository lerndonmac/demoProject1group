package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

//pojo
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "client")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FirstName")
    @NonNull
    private String firstName;
    @Column(name = "LastName")
    @NonNull
    private String lastName;
    @Column(name = "Patronymic")
    @NonNull
    private String patronymic;
    @Column(name = "Birthday")
    @NonNull
    private Date birthDay;
    @Column(name = "RegistrationDate")
    @NonNull
    private Date registrationDate;
    @Column(name = "Email")
    @NonNull
    private String email;
    @Column(name = "Phone")
    @NonNull
    private String phone;

    @Column(name = "PhotoPath")
    @NonNull
    private String photoPath;

    public String getBirthDay() {
        return String.format("%tF",birthDay);
    }
    public Date getDateBirthday(){
        return birthDay;
    }

    @ManyToOne
    @JoinColumn(name = "GenderCode")
    @NonNull
    private Gender gender;

    @OneToMany(mappedBy = "clientId")
    private Set<ClientServicePOJO> clientServiceS;

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", firstName='" + firstName  +
                ", lastName='" + lastName +
                ", patronymic='" + patronymic +
                ", birthDay=" + birthDay +
                ", registrationDate=" + registrationDate +
                ", email='" + email +
                ", phone='" + phone +
                ", gender=" + gender +
                ", photoPath='" + photoPath +
                '}';
    }
}
