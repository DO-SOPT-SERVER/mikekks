package secondSeminar.secondSeminar.dto.response;

import secondSeminar.secondSeminar.domain.Category;

public record CategoryResponse(
        String category
) {
    public static CategoryResponse of(Category category){
        return new CategoryResponse(category.getContent());
    }
}
