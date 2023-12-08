package secondSeminar.secondSeminar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secondSeminar.secondSeminar.domain.Category;
import secondSeminar.secondSeminar.domain.CategoryId;
import secondSeminar.secondSeminar.dto.response.CategoryResponse;
import secondSeminar.secondSeminar.exception.ErrorMessage;
import secondSeminar.secondSeminar.repository.CategoryJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(CategoryId categoryId) {
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId())).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_EXCEPTION.getMessage()));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_EXCEPTION.getMessage())));
    }
}
