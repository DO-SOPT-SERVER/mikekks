package thirdseminar.thirdseminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thirdseminar.thirdseminar.domain.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {

}
