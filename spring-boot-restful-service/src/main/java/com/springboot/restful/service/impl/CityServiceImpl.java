package com.springboot.restful.service.impl;

import com.springboot.restful.entity.City;
import com.springboot.restful.repository.CityRepository;
import com.springboot.restful.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> queryAll() {
        List<City> cityList = cityRepository.findAll();
        return cityList;
    }

    @Override
    public City queryByCityId(Long cityId) {
//        return cityRepository.findOne(cityId);            //springboot 1.5.3.Release
        return cityRepository.findById(cityId).get();       //springboot 2.0.0.Release及以上
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long cityId, String city) {
        return cityRepository.save(new City().setCityId(cityId).setCity(city));
    }

}