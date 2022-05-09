package my.sandbox.feign.clientSide;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "simpleFeign",
        path = "/simple"
)
public interface SimpleFeign {

    @GetMapping
    String mirror(@RequestParam("message") String message);
}
