package fr.apside.approjects.dao;

import fr.apside.approjects.model.Training;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Long>{

    @EntityGraph(value = "Training.sessions", type = EntityGraph.EntityGraphType.LOAD)
    Training getById(Long id);
}
