package my.sandbox.feign.clientSide;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(
        name = "pageableFeign",
        path = "/pageable"
)
public interface PageableFeign {

    @GetMapping
    String mirror(@SpringQueryMap Pageable parameter);

    @GetMapping
    String mirror(@RequestParam(required = false) Integer page,
                  @RequestParam(required = false) Integer size,
                  @RequestParam(required = false) Collection<String> sort);

}
