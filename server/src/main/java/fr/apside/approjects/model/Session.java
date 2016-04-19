package fr.apside.approjects.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Session {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    @JoinTable(name="Session_Attendee",
            joinColumns=@JoinColumn(name="Session_ID", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="Attendee_ID", referencedColumnName="id"))
    private List<Person> attendees;
    @ManyToMany
    @JoinTable(name="Session_Coach",
            joinColumns=@JoinColumn(name="Session_ID", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="Coach_ID", referencedColumnName="id"))
    private Set<Person> coaches;
    @ManyToOne
    private Training training;
    private Date date;
    private String location;

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }

    public Set<Person> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Person> coaches) {
        this.coaches = coaches;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(attendees, session.attendees) &&
                Objects.equals(coaches, session.coaches) &&
                Objects.equals(training, session.training) &&
                Objects.equals(date, session.date) &&
                Objects.equals(location, session.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attendees, coaches, training, date, location);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", attendees=" + attendees +
                ", coaches=" + coaches +
                ", training=" + training +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }
}
