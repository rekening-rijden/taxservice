package com.rekeningrijden.taxservice;

import com.rekeningrijden.taxservice.entity.BasePrice;
import com.rekeningrijden.taxservice.repository.BasePriceRepository;
import com.rekeningrijden.taxservice.service.BasePriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BasePriceServiceTests {

    @Mock
    private BasePriceRepository basePriceRepo;

    @InjectMocks
    private BasePriceService basePriceService;

    private BasePrice basePrice;

    @BeforeEach
    public void setup(){
        basePrice = new BasePrice(new BigDecimal("0.20"), "diesel");
    }

    @DisplayName("BasePriceService JUNIT test for getKilometerTaxByEngineType method")
    @Test
    public void givenEngineType_whenGetKilometerTaxByEngineType_thenReturnBigDecimal(){
        // given
        given(basePriceRepo.findByEngineType("diesel")).willReturn(basePrice);

        // when
        BigDecimal result = basePriceService.getKilometerTaxByEngineType("diesel");

        // then
        assertThat(result).isEqualTo(new BigDecimal("0.20"));
    }
}
