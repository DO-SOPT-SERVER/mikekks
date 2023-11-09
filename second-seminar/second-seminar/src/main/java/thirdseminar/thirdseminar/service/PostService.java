package thirdseminar.thirdseminar.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thirdseminar.thirdseminar.domain.Category;
import thirdseminar.thirdseminar.domain.Member;
import thirdseminar.thirdseminar.domain.Post;
import thirdseminar.thirdseminar.dto.request.post.PostCreateRequest;
import thirdseminar.thirdseminar.dto.request.post.PostGetResponse;
import thirdseminar.thirdseminar.dto.request.post.PostUpdateRequest;
import thirdseminar.thirdseminar.exception.ErrorMessage;
import thirdseminar.thirdseminar.repository.MemberJpaRepository;
import thirdseminar.thirdseminar.repository.PostJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryService categoryService;


    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getPostId().toString();
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessage.POST_NOT_FOUND_EXCEPTION.getMessage()));
        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException(ErrorMessage.POST_NOT_FOUND_EXCEPTION.getMessage()));
        postJpaRepository.delete(post);
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        List<Post> allByMemberId = postJpaRepository.findAllByMemberId(memberId);

        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
                .toList();
    }


    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException(ErrorMessage.POST_NOT_FOUND_EXCEPTION.getMessage()));
        return PostGetResponse.of(post, getCategoryByPost(post));
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }

}
