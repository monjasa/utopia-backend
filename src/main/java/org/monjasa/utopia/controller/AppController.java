package org.monjasa.utopia.controller;

import org.monjasa.utopia.dto.AppDataDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/app")
public class AppController {

    @GetMapping(path = "/test")
    @PreAuthorize("hasAuthority('READ')")
    public AppDataDto test(Principal principal) {
        return new AppDataDto(principal.getName());
    }
}
