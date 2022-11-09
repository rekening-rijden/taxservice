package com.rekeningrijden.taxservice;

import com.rekeningrijden.taxservice.entity.RoadTax;
import com.rekeningrijden.taxservice.repository.RoadTaxRepository;
import com.rekeningrijden.taxservice.service.RoadTaxService;
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
public class RoadTaxServiceTests {

    @Mock
    private RoadTaxRepository roadTaxRepo;

    @InjectMocks
    private RoadTaxService roadTaxService;

    private RoadTax roadTax;

    @BeforeEach
    public void setup(){
        roadTax = new RoadTax(new BigDecimal("0.05"), "highway");
    }

    @DisplayName("RoadTaxService JUNIT test for getSurTaxByRoadType method")
    @Test
    public void givenRoadType_whenGetSurTaxByRoadType_thenReturnBigDecimal(){
        // given
        given(roadTaxRepo.findRoadTaxByRoadType("highway")).willReturn(roadTax);

        // when
        BigDecimal result = roadTaxService.getSurTaxByRoadType("highway");

        // then
        assertThat(result).isEqualTo(new BigDecimal("0.05"));
    }
}
