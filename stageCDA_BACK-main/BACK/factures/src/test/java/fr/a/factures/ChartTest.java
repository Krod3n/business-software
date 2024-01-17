package fr.a.factures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.a.factures.dto.Chart;
import fr.a.factures.dto.ChartDTO;
import fr.a.factures.dto.ChartImpl;
import fr.a.factures.dto.mapper.ChartMapper;

public class ChartTest {

	/**
	 * Test the toDTOs method with valid input.
	 */
	@Test
	public void testToDTOs() {
		List<Chart> actuCh = new ArrayList<>();
		actuCh.add(new ChartImpl("Jan", 100.0));
		actuCh.add(new ChartImpl("Feb", 200.0));
		actuCh.add(new ChartImpl("Mar", 300.0));

		List<Chart> prevCh = new ArrayList<>();
		prevCh.add(new ChartImpl("Jan", 50.0));
		prevCh.add(new ChartImpl("Feb", 150.0));
		prevCh.add(new ChartImpl("Mar", 250.0));

		List<Chart> forecastCh = new ArrayList<>();
		forecastCh.add(new ChartImpl("Jan", 75.0));
		forecastCh.add(new ChartImpl("Feb", 175.0));
		forecastCh.add(new ChartImpl("Mar", 325.0));

		List<ChartDTO> dtos = ChartMapper.toDTOs(actuCh, prevCh, forecastCh);

		assertEquals(12, dtos.size());

		ChartDTO janDTO = dtos.get(0);
		assertEquals("Jan", janDTO.getMonth());
		assertEquals(100.0, janDTO.getMonthTurnover(), 0.001);
		assertEquals(50.0, janDTO.getPastMonthTurnover(), 0.001);
		assertEquals(75.0, janDTO.getForecast(), 0.001);

		ChartDTO febDTO = dtos.get(1);
		assertEquals("Feb", febDTO.getMonth());
		assertEquals(200.0, febDTO.getMonthTurnover(), 0.001);
		assertEquals(150.0, febDTO.getPastMonthTurnover(), 0.001);
		assertEquals(175.0, febDTO.getForecast(), 0.001);

		ChartDTO marDTO = dtos.get(2);
		assertEquals("Mar", marDTO.getMonth());
		assertEquals(300.0, marDTO.getMonthTurnover(), 0.001);
		assertEquals(250.0, marDTO.getPastMonthTurnover(), 0.001);
		assertEquals(325.0, marDTO.getForecast(), 0.001);

	}

	/*
	 * Test the constructor of ChartMapper
	 *
	 */
	@Test
	void ChartMapperContructor() {
		// given

		// when
		ChartMapper m = new ChartMapper();

		// then
		assertEquals(m.getClass(), ChartMapper.class);

	}
}