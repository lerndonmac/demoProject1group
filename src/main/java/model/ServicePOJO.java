package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ServicePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Cost")
    private double cost;
    @Column(name = "DurationInSeconds")
    private int durationInSeconds;
    @Column(name = "Discount")
    private double discount;
    @Column(name = "Description")
    private String description;
    @Column(name = "MainImagePath")
    private String mainImagePath;
    @OneToMany(mappedBy = "serviceId")
    private Set<ClientServicePOJO> clientServiceS;
}
