package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.OrderDto;
import com.trackingsys.stocktrackingsystem.dto.UserDto;
import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convertToDto(User user){
        return UserDto.builder()
                .mail(user.getMail())
                .password(user.getPassword())
                .creationDate(LocalDateTime.now(ZoneId.of("Africa/Addis_Ababa")))
                .build();
    }

    public List<UserDto> convertToDto(List<User> users){
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
