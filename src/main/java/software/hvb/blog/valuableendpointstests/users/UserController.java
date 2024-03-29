package software.hvb.blog.valuableendpointstests.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserController {

    @GetMapping("/users")
    public List<User> listAllUsers() {
        return List.of(
                new User(1L, "Walter", "White"),
                new User(2L, "Jesse", "Pinkman")
        );
    }
}
