package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.dto.CompanyDto;
import com.trackingsys.stocktrackingsystem.dto.converter.CompanyDtoConverter;
import com.trackingsys.stocktrackingsystem.entity.Company;
import com.trackingsys.stocktrackingsystem.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyDtoConverter companyDtoConverter;

    public CompanyService(CompanyRepository companyRepository, CompanyDtoConverter companyDtoConverter) {
        this.companyRepository = companyRepository;
        this.companyDtoConverter = companyDtoConverter;
    }


    public CompanyDto addCompany(Company company) {
        return companyDtoConverter.convertToDto(companyRepository.save(company));
    }


    public List<CompanyDto> getAllCompanies() {
        return companyDtoConverter.convertToDto(companyRepository.findAll());
    }

    public CompanyDto getCompanyById(String companyId) {
        return companyDtoConverter.convertToDto(companyRepository.findById(companyId).orElse(null));
    }

    public Company deleteCompanyById(String companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        companyRepository.deleteById(companyId);
        return company;
    }

    public CompanyDto updateCompanyById(Company company, String companyId) {
        Company updateCompany = companyRepository.findById(companyId).orElse(null);

        updateCompany.setCompanyName(company.getCompanyName());
        updateCompany.setWebAddress(company.getWebAddress());
        updateCompany.setTaxNumber(company.getTaxNumber());
        updateCompany.setCompanyPhoneNumber(company.getCompanyPhoneNumber());

        return companyDtoConverter.convertToDto(companyRepository.save(updateCompany));
    }
}
