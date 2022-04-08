package br.com.itau.pix.domain.model.util;

import org.junit.jupiter.api.Test;

import static br.com.itau.pix.domain.model.util.CnpjValidator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CnpjValidatorTest {

    @Test
    public void shouldValidateCnpj(){
        assertTrue(validate("50409461000190"));
        assertFalse(validate("50409461000199"));
    }
}
