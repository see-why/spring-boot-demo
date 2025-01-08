package com.see_why.api.spring_boot_demo;

import java.util.List;

public record WelcomeMessage(
    String message,
    List<String> programmingLanguages
    ){} 