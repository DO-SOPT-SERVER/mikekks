package secondSeminar.secondSeminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secondSeminar.secondSeminar.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}