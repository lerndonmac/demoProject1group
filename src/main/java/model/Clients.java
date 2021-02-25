package model;

import DAO.DAO;
import DAO.Service.ClientsService;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

    private int countOfEntering;

    @Transient
    private Date dateOfLastEntering;

    public Date getDateOfLastEntering() {
        return dateOfLastEntering;
    }

    public String getBirthDay() {
        return String.format("%tF",birthDay);
    }
    public Date getDateBirthday(){
        return birthDay;
    }

    public int getCountOfEntering() {
        Set<ClientServicePOJO> clientsServices = clientServiceS;
        return clientsServices.size();
    }

    @ManyToOne
    @JoinColumn(name = "GenderCode")
    @NonNull
    private Gender gender;

    @OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
    private Set<ClientServicePOJO> clientServiceS;

    @ManyToMany(mappedBy = "clientsId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TagsPOJO> tags;


    @Transient
    private Date lastDate;



    @Override
    public String toString() {
        return "{" +
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
