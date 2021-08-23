package com.springdemo.project;

import com.springdemo.project.dao.CityRepository;
import com.springdemo.project.entity.City;
import com.springdemo.project.service.CityService;
import com.springdemo.project.service.CityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.springdemo.project.ProjectApplication.class})
class ProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	private CityService cityService;


	@Mock
	private CityRepository cityRepository;



	@BeforeEach
	void initUseCase(){
		cityService=new CityServiceImpl(cityRepository);
	}

	@Test
	void findByIdMocked()
	{

		City city = new City("city1","state1");
		when(cityRepository.findById(1)).thenReturn(java.util.Optional.of(city));
		assertEquals(city, cityService.findById(1));
		Mockito.verify(cityRepository).findById(1);

	}

	@Test
	void getCity()
	{

		when(cityRepository.findAll()).thenReturn(Stream.of(new City("city2","state2"),new City("city3","state3")).collect(Collectors.toList()));
		assertEquals(2,cityService.findAll().size());
	}

}

