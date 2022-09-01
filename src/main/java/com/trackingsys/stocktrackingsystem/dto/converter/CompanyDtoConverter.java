package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.CompanyDto;
import com.trackingsys.stocktrackingsystem.entity.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyDtoConverter {

    public CompanyDto convertToDto(Company company){
        return CompanyDto.builder()
                .companyName(company.getCompanyName())
                .webAddress(company.getWebAddress())
                .taxNumber(company.getTaxNumber())
                .companyPhoneNumber(company.getCompanyPhoneNumber())
                .build();
    }

    public List<CompanyDto> convertToDto(List<Company> companies){
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
