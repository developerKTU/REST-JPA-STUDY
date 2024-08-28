package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        // Model : view에 해당 데이터를 넘길 수 있는 객체
        model.addAttribute("data", "hello test!");

        // RestController와 다르게, view의 name를 리턴. (html 확장자명은 생략해도 됨.)
        return "hello";
    }
}
