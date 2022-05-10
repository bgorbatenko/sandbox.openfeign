package my.sandbox.feign.serverSide;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pageable")
public class PageableController {

    @GetMapping (produces = "application/json")
    public String getMirror(Pageable pageable) {
        return pageable.toString();
    }

}
