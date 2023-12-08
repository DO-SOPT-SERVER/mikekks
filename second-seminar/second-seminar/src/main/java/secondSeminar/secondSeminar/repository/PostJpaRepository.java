package secondSeminar.secondSeminar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import secondSeminar.secondSeminar.domain.Member;
import secondSeminar.secondSeminar.domain.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);
}
