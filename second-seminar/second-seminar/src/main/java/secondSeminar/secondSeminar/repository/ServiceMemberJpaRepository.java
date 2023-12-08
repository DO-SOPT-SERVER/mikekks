package secondSeminar.secondSeminar.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import secondSeminar.secondSeminar.domain.ServiceMember;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);
}
