package thirdseminar.thirdseminar.repository;

import static thirdseminar.thirdseminar.exception.ErrorMessage.MEMBER_NOT_FOUND_EXCEPTION;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import thirdseminar.thirdseminar.domain.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException(MEMBER_NOT_FOUND_EXCEPTION.getMessage()));
    }
}
