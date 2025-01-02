package com.joaquin.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.joaquin.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.joaquin.springboot.webapp.springboot_web.models.dto.ParamDtoMix;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal", name = "mensaje") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDtoMix bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDtoMix params = new ParamDtoMix();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
}
