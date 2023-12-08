package secondSeminar.secondSeminar.dto.request.post;

import secondSeminar.secondSeminar.domain.Category;
import secondSeminar.secondSeminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
) {

    public static PostGetResponse of(Post post, Category category) {
    return new PostGetResponse(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            category.getContent()
    );
}
}
