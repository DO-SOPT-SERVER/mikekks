package secondseminar.secondseminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import secondseminar.secondseminar.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}