package be.bstorm.tf_java_2024_demospringmvc.repositories;

import be.bstorm.tf_java_2024_demospringmvc.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query("SELECT count(a) > 0 from Animal a where a.name ilike :name")
    boolean existsByName(@Param("name") String name);
}
