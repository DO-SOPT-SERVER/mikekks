package thirdseminar.thirdseminar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import thirdseminar.thirdseminar.domain.Member;
import thirdseminar.thirdseminar.domain.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);
}
