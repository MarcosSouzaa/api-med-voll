package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Porque estamos trabalhando com uma API Rest
@RequestMapping("/hello")//diz qual url esse Controller vai responder/toda requisição em localhost:8080/hello cai aqui
public class HelloController {
    //de qual método HTTP é pra chamar esse método?
    @GetMapping
    public String olaMundo(){ //método que retorna uma String
        return "Hello World How are you today?";
    }
}
