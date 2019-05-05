package spring.nikitasterlit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.nikitasterlit.model.LableCompany;

@Repository
public interface LableCompanyRepository extends JpaRepository<LableCompany, Long> {
}
