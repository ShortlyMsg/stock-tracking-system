package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.dto.CompanyDto;
import com.trackingsys.stocktrackingsystem.entity.Company;
import com.trackingsys.stocktrackingsystem.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") String companyId){
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable("id") String companyId){
        companyService.deleteCompanyById(companyId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompanyById(@RequestBody Company company,
                                                    @PathVariable("id") String companyId){
        return ResponseEntity.ok(companyService.updateCompanyById(company, companyId));
    }
}
