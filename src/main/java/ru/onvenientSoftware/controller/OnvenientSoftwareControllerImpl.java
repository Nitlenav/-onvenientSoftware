package ru.onvenientSoftware.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.onvenientSoftware.services.DocServices;


@AllArgsConstructor
@RestController
public class OnvenientSoftwareControllerImpl implements OnvenientSoftwareController {


    private final DocServices docServices;

    @GetMapping("/")
    @Override
    public Integer maxNumberDoc(@RequestParam Integer count,
                                @RequestParam String path) {
        return docServices.getMaxNumberByDoc(path, count);
    }
}
