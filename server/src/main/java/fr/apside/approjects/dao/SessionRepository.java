package fr.apside.approjects.dao;

import fr.apside.approjects.model.Session;
import fr.apside.approjects.model.Training;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends CrudRepository<Session, Long> {


    @Query(value = "SELECT s from Session s LEFT join fetch s.attendees LEFT join fetch s.coaches where s.id = :sessionId")
    Session loadFullDetails(@Param("sessionId")Long id);

    @Query(value = "SELECT s from Session s LEFT join fetch s.attendees")
    Iterable<Session> findAllWithAttendees();

    @Query(value = "SELECT s from Session s LEFT join fetch s.attendees where s.date >= current_date ")
    Iterable<Session> findComingSessions();
}
