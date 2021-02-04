package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

//pojo
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Birthday")
    private Date birthDay;
    @Column(name = "RegistrationDate")
    private Date registrationDate;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;

    @Column(name = "PhotoPath")
    private String photoPath;

    public String getBirthDay() {
        return String.format("%tF",birthDay);
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GenderCode")
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
