package thirdseminar.thirdseminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thirdseminar.thirdseminar.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}