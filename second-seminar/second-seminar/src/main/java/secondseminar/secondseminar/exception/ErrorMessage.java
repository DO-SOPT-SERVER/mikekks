package secondseminar.secondseminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ErrorMessage {
    ERROR_NOT_FOUND("존재하지 않는 회원입니다.");

    private final String message;
}
