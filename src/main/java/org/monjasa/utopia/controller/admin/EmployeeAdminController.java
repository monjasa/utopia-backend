package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.employee.EmployeeConciseDto;
import org.monjasa.utopia.dto.employee.request.EmployeeRequest;
import org.monjasa.utopia.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employee")
@RequiredArgsConstructor
public class EmployeeAdminController {

    private final EmployeeService employeeService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_WRITE_EMPLOYEE')")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeRequest request) {
        employeeService.create(request);
    }

    @GetMapping("/concise/all")
    @PreAuthorize("hasAuthority('SCOPE_READ_EMPLOYEE')")
    public List<EmployeeConciseDto> getAllConcise() {
        return employeeService.getAllConcise();
    }
}
