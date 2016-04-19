package fr.apside.approjects.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedEntityGraph(name = "Agency.contacts", attributeNodes = @NamedAttributeNode("contacts"))
public class Agency {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "agency")
    private List<Person> contacts;

    @ManyToMany
    @JoinTable(name="Training_Agency",
            joinColumns=@JoinColumn(name="Agency_ID", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="Training_ID", referencedColumnName="id"))
    private List<Training> trainings;

    public Agency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public void setContacts(List<Person> contacts) {
        this.contacts = contacts;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
