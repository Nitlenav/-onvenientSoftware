package ru.onvenientSoftware.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

class DocServicesImplTest {

    private final DocServicesImpl doc = new DocServicesImpl();

    @Test
    void getMaxNumberByDoc() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:file.xlsx");
        Integer maxNumberByDoc = doc.getMaxNumberByDoc(file.getAbsolutePath(), 10);
        Assert.isTrue(maxNumberByDoc == 97, "");
    }
}