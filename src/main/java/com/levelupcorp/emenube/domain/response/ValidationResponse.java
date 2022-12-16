package com.levelupcorp.emenube.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ValidationResponse {

    private List<String> validationMessages;
}
