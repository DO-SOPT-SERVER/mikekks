package secondSeminar.secondSeminar.repository;

import static secondSeminar.secondSeminar.exception.ErrorMessage.MEMBER_NOT_FOUND_EXCEPTION;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import secondSeminar.secondSeminar.domain.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException(MEMBER_NOT_FOUND_EXCEPTION.getMessage()));
    }
}
