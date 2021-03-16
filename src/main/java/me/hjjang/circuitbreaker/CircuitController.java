package me.hjjang.circuitbreaker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CircuitController {

    private final CircuitService circuitService;

    @GetMapping("/circuit/{id}")
    public String postsDetail(@PathVariable String id) {
        return circuitService.circuitPosts(id);
    }
}
