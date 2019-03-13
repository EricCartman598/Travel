/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190307.City.Service.Impl;

import Travel_20190307.City.Domain.City;
import Travel_20190307.City.Repo.CityRepo;
import Travel_20190307.City.Search.CitySearchCondition;
import Travel_20190307.City.Service.CityService;

import java.util.List;


/**
 * @author Виталий
 */
public class CityMemoryListService implements CityService {

    private final CityRepo cityRepo;

    public CityMemoryListService(CityRepo cityRepo){
        this.cityRepo = cityRepo;
    }


    @Override
    public City findByName(String name) {
        if(!name.trim().isEmpty())
            return cityRepo.findByName(name);

        return null;
    }

    @Override
    public List<City> findByCondition(CitySearchCondition citySearchCondition) {
        return cityRepo.findByCondition(citySearchCondition);
    }

    @Override
    public void add(City data) {
        if(data != null)
            cityRepo.add(data);
    }

    @Override
    public City findById(Long id) {
        if(id != null)
            return cityRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            cityRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public void update(City data) {
        cityRepo.update(data);
    }
}

