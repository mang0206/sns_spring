package sns_project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sns_project.web.dto.testControllerDto;

@RestController
public class testController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/hello/dto")
    public testControllerDto testdto(@RequestParam("name") String name, //
                                     @RequestParam("amount") int amount) {
        return new testControllerDto(name, amount);
    }
}
