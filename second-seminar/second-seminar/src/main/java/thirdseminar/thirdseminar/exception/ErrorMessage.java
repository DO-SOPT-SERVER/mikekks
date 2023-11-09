package thirdseminar.thirdseminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 회원입니다."),
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"해당하는 게시글이 없습니다."),
    CATEGORY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"해당하는 카테고리가 없습니다.");

    private final HttpStatus status;
    private final String message;
}
