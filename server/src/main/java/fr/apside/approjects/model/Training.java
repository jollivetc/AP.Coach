package fr.apside.approjects.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedEntityGraph(name = "Training.sessions", attributeNodes = @NamedAttributeNode("sessions"))
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Training {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "trainings")
    private List<Agency> agencies;
    @OneToMany(mappedBy = "training")
    private List<Session> sessions;
    private String name;
    private URL repositoryUrl;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Level level;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(URL repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) &&
                Objects.equals(agencies, training.agencies) &&
                Objects.equals(sessions, training.sessions) &&
                Objects.equals(name, training.name) &&
                Objects.equals(repositoryUrl, training.repositoryUrl) &&
                Objects.equals(description, training.description) &&
                level == training.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agencies, sessions, name, repositoryUrl, description, level);
    }
}
