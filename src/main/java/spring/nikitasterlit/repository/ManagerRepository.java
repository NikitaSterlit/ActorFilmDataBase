package spring.nikitasterlit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.nikitasterlit.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, Long> {

}
