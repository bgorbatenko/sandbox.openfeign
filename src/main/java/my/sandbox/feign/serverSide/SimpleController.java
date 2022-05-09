package my.sandbox.feign.serverSide;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/simple")
public class SimpleController {

    @GetMapping(produces = "text/plain")
    public String getMirror(@RequestParam String message) {
        return message;
    }
}
