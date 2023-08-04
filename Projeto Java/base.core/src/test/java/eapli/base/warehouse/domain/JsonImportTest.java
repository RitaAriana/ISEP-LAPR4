package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonImportTest {

    @Test
    void importJson() {
        assertEquals(false, new JsonImport().importJson("warehouse2.json"));
    }
}