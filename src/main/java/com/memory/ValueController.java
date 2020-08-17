package com.memory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ValueController {

    private final ValueRepository repository;

    public ValueController(ValueRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView show() {
        List<Value> values = (List<Value>) repository.findAll();
        return new ModelAndView("index", "value", values.isEmpty() ? null : values.get(0).getValue());
    }

    @PostMapping("memorize")
    public ModelAndView memorize(@RequestParam("value")String value, RedirectAttributes redirect) {
        List<Value> values = (List<Value>) repository.findAll();
        if(!values.isEmpty()) {
            repository.delete(values.get(0));
        }
        repository.save(new Value(value));
        return new ModelAndView("redirect:/");
    }
}
