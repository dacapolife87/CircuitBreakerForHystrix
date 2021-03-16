package me.hjjang.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class CircuitService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "methodName")
    public String circuitPosts(String id) {
        URI uri = URI.create("http://localhost:18081/posts/"+id);

        return restTemplate.getForObject(uri, String.class);
    }

    public String methodName(String id) {
        return "This's fallback Method!!! id : "+id;
    }
}
