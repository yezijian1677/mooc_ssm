package com.imooc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AnnotationHandler {

    @RequestMapping("/modelAndViewTest")
    public ModelAndView modelAndViewTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "jerry");
        modelAndView.setViewName("show");

        return modelAndView;
    }

    @RequestMapping("/modelTest")
    public String modelTest(Model model){
        model.addAttribute("name", "lily");

        return "show";
    }

    @RequestMapping("/mapTest")
    public String mapTest(Map<String, String>map){
        map.put("name", "tom");

        return "show";
    }
}
