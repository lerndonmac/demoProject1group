package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "clientservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientServicePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientID")
    private Clients clientId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ServiceID")
    private ServicePOJO serviceId;
    @Column(name = "StartTime")
    private Date startTime;
    @Column(name = "Comment")
    private String comment;


    @Override
    public String toString(){
        return "";
    }
}
