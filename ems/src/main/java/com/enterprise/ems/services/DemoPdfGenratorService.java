package com.enterprise.ems.services;

import org.springframework.stereotype.Service;
/*
import org.thymeleaf.TemplateEngine;
*/

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class DemoPdfGenratorService {

    private final TemplateEngine templateEngine;

    public DemoPdfGenratorService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateHtml(Map<String, Object> data) {
        Context context = new Context();
        context.setVariables(data);
        return templateEngine.process("invoice", context);
    }
}
