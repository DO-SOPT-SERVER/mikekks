package secondSeminar.secondSeminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secondSeminar.secondSeminar.domain.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {

}
