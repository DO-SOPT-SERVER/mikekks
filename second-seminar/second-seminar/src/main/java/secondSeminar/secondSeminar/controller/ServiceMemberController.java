package secondSeminar.secondSeminar.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import secondSeminar.secondSeminar.dto.request.servicemember.ServiceMemberRequest;
import secondSeminar.secondSeminar.service.ServiceMemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class ServiceMemberController {

    private final ServiceMemberService serviceMemberService;

    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(@RequestBody ServiceMemberRequest request) {
        URI location = URI.create(serviceMemberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @PostMapping("sign-in")
    public ResponseEntity<Void> signIn(@RequestBody ServiceMemberRequest request) {
        serviceMemberService.signIn(request);
        return ResponseEntity.noContent().build();
    }
}
