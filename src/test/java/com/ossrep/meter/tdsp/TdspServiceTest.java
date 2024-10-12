package com.ossrep.meter.tdsp;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class TdspServiceTest {

    @Inject
    TdspService tdspService;

    @Test
    public void findAll() {
        List<Tdsp> list = tdspService.findAll();
        assertNotNull(list);
        Log.info(list);
    }

}
