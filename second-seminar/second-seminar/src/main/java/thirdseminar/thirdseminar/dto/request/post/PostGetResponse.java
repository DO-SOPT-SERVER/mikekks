package thirdseminar.thirdseminar.dto.request.post;

import thirdseminar.thirdseminar.domain.Category;
import thirdseminar.thirdseminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
) {

    public static PostGetResponse of(Post post, Category category) {
    return new PostGetResponse(
            post.getPostId(),
            post.getTitle(),
            post.getContent(),
            category.getContent()
    );
}
}
