package thirdseminar.thirdseminar.dto.response;

import thirdseminar.thirdseminar.domain.Category;

public record CategoryResponse(
        String category
) {
    public static CategoryResponse of(Category category){
        return new CategoryResponse(category.getContent());
    }
}
