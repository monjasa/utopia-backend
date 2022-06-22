package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.employee.EmployeePositionItemDto;
import org.monjasa.utopia.service.EmployeePositionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employee-position")
@RequiredArgsConstructor
public class EmployeePositionAdminController {

    private final EmployeePositionService employeePositionService;

    @GetMapping("/item/all")
    @PreAuthorize("hasAuthority('SCOPE_READ_EMPLOYEE')")
    public List<EmployeePositionItemDto> getAllItems() {
        return employeePositionService.getAllItems();
    }
}
