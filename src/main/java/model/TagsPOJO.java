package model;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@NoArgsConstructor
@Getter@Setter
public class TagsPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Color")
    private String color;


    @ManyToMany
    @JoinTable(
            name = "tagofclient",
            joinColumns = @JoinColumn(name = "TagID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ClientID", referencedColumnName = "ID")
    )
    private Set<Clients> clientsId;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
