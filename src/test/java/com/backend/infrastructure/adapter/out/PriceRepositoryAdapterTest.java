package com.backend.infrastructure.adapter.out;

import com.backend.domain.port.PricePort;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import com.backend.infrastructure.adapter.out.PriceRepositoryAdapter;
import com.backend.infrastructure.persistence.entity.Prices;
import com.backend.infrastructure.persistence.repository.PriceJPARepository;
import com.backend.util.Utilities;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class PriceRepositoryAdapterTest {
    private PriceJPARepository priceJPARepository;

    private PriceRepositoryAdapter priceRepositoryAdapter;

    @BeforeEach
    public void initEach() {
        priceJPARepository = mock(PriceJPARepository.class);
        priceRepositoryAdapter = new PriceRepositoryAdapter(priceJPARepository);
    }

    @Test
    void shouldBeOkCase1() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest1();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        List<Prices> priceList = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assert.assertEquals(1, priceList.size());
        Assert.assertEquals(new BigDecimal("35.50"), priceList.get(0).getPrice());

    }

    @Test
    void shouldBeOkCase2() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest2();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        List<Prices> priceList = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assert.assertEquals(2, priceList.size());
        Assert.assertEquals(new BigDecimal("25.45"), priceList.get(0).getPrice());

    }

    @Test
    void shouldBeOkCase3() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest3();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        List<Prices> priceList = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assert.assertEquals(1, priceList.size());
        Assert.assertEquals(new BigDecimal("35.50"), priceList.get(0).getPrice());
    }

    @Test
    void shouldBeOkCase4() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest4();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        List<Prices> priceList = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assert.assertEquals(2, priceList.size());
        Assert.assertEquals(new BigDecimal("30.50"), priceList.get(0).getPrice());
    }

    @Test
    void shouldBeOkCase5() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest5();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());
        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        List<Prices> priceList = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assert.assertEquals(2, priceList.size());
        Assert.assertEquals(new BigDecimal("38.95"), priceList.get(0).getPrice());
    }
}
