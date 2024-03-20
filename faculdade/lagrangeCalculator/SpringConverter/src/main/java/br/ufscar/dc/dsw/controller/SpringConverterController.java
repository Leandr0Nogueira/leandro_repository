package br.ufscar.dc.dsw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringConverterController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/indexG1")
    public String index_G1() {
        return "indexG1";
    }
    @GetMapping("/indexG2")
    public String index_G2() {
        return "indexG2";
    }
    @GetMapping("/indexG3")
    public String index_G3() {
        return "indexG3";
    }


    @RequestMapping(path = "/grau1", method = {RequestMethod.GET, RequestMethod.POST})
    public String conversao1(@RequestParam(required = true, defaultValue = "0") float x0,
                            @RequestParam(required = true, defaultValue = "0") float img0,
                            @RequestParam(required = true, defaultValue = "0") float x1,
                            @RequestParam(required = true, defaultValue = "0") float img1,
                            @RequestParam(required = true, defaultValue = "0") float x,
                            Model model) {

        float result = lagrange1(x0, img0, x1, img1, x);

        model.addAttribute("resultado", result);

        return "grau1";
    }

    @RequestMapping(path = "/grau2", method = {RequestMethod.GET, RequestMethod.POST})
    public String conversao2(@RequestParam(required = true, defaultValue = "0") float x0,
                            @RequestParam(required = true, defaultValue = "0") float img0,
                            @RequestParam(required = true, defaultValue = "0") float x1,
                            @RequestParam(required = true, defaultValue = "0") float img1,
                            @RequestParam(required = true, defaultValue = "0") float x2,
                            @RequestParam(required = true, defaultValue = "0") float img2,
                            @RequestParam(required = true, defaultValue = "0") float x,
                            Model model) {

        float result = lagrange2(x0, img0, x1, img1, x2, img2, x);

        model.addAttribute("resultado", result);

        return "grau2";
    }

    @RequestMapping(path = "/grau3", method = {RequestMethod.GET, RequestMethod.POST})
    public String conversao3(@RequestParam(required = true, defaultValue = "0") float x0,
                            @RequestParam(required = true, defaultValue = "0") float img0,
                            @RequestParam(required = true, defaultValue = "0") float x1,
                            @RequestParam(required = true, defaultValue = "0") float img1,
                            @RequestParam(required = true, defaultValue = "0") float x2,
                            @RequestParam(required = true, defaultValue = "0") float img2,
                            @RequestParam(required = true, defaultValue = "0") float x3,
                            @RequestParam(required = true, defaultValue = "0") float img3,
                            @RequestParam(required = true, defaultValue = "0") float x,
                            Model model) {

        float result = lagrange3(x0, img0, x1, img1, x2, img2, x3, img3, x);

        model.addAttribute("resultado", result);

        return "grau3";
    }

    private static float lagrange1(float x0, float img0, float x1, float img1, float x) {
        float aprox = ((x-x1)/(x0-x1))*img0 + ((x-x0)/(x1-x0))*img1;
        return aprox;
    }

    private static float lagrange2(float x0, float img0, float x1, float img1, float x2, float img2, float x) {
        float aprox = (((x-x1)*(x-x2))/((x0-x1)*(x0-x2)))*img0 + (((x-x0)*(x-x2))/((x1-x0)*(x1-x2)))*img1 + (((x-x0)*(x-x1))/((x2-x0)*(x2-x1)))*img2;
        return aprox;
    }

    private static float lagrange3(float x0, float img0, float x1, float img1, float x2, float img2, float x3, float img3, float x) {
        float aprox = (((x-x1)*(x-x2)*(x-x3))/((x0-x1)*(x0-x2)*(x0-x3)))*img0 + (((x-x0)*(x-x2)*(x-x3))/((x1-x0)*(x1-x2)*(x1-x3)))*img1 + (((x-x0)*(x-x1)*(x-x3))/((x2-x0)*(x2-x1)*(x2-x3)))*img2 + (((x-x0)*(x-x1)*(x-x2))/((x3-x0)*(x3-x1)*(x3-x2)))*img3;
        return aprox;
    }
}
