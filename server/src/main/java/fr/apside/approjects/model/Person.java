package fr.apside.approjects.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    private Agency agency;

    @ManyToMany(mappedBy = "coaches")
    private Set<Session> sessionsAsCoach;

    @ManyToMany(mappedBy = "attendees")
    private Set<Session> sessionsAsAttendee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Set<Session> getSessionsAsCoach() {
        return sessionsAsCoach;
    }

    public void setSessionsAsCoach(Set<Session> sessionsAsCoach) {
        this.sessionsAsCoach = sessionsAsCoach;
    }

    public Set<Session> getSessionsAsAttendee() {
        return sessionsAsAttendee;
    }

    public void setSessionsAsAttendee(Set<Session> sessionsAsAttendee) {
        this.sessionsAsAttendee = sessionsAsAttendee;
    }
}
