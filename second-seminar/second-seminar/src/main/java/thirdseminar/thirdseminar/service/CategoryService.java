package thirdseminar.thirdseminar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thirdseminar.thirdseminar.domain.Category;
import thirdseminar.thirdseminar.dto.response.CategoryResponse;
import thirdseminar.thirdseminar.exception.ErrorMessage;
import thirdseminar.thirdseminar.repository.CategoryJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(Short categoryId) {
        return categoryJpaRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_EXCEPTION.getMessage()));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_EXCEPTION.getMessage())));
    }
}
