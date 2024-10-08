package ru.onvenientSoftware.controller;

import io.swagger.v3.oas.annotations.Operation;


public interface OnvenientSoftwareController {

    @Operation(summary = "Метод должен вернуть N-ное максимальное число из файла")
    Integer maxNumberDoc(Integer count, String path);
}
