package com.alanturing.cpifp.incidentmanager.service.vehicle;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.vehicle.VehicleDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleDto;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleEntity;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final UserRepository userRepository;


    public VehicleServiceImpl(VehicleRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<VehicleEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public VehicleEntity addVehicle(VehicleDto vehicleDto) throws UserDoesNotExistsException {
        int userId = vehicleDto.getUser_id();
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException());
        VehicleEntity vehicle = new VehicleEntity();
        BeanUtils.copyProperties(vehicleDto, vehicle, "user_id");
        vehicle.setUser(user);
        return repository.save(vehicle);
    }

    @Override
    public VehicleEntity updateVehicle(int id, VehicleDto vehicleDto) throws VehicleDoesNotExistsException {
        VehicleEntity vehicleDB = this.repository.findById(id).orElseThrow(() -> new VehicleDoesNotExistsException());
        vehicleDB.setColor(vehicleDto.getColor());
        vehicleDB.setLicensePlate(vehicleDto.getLicensePlate());
        vehicleDB.setModel(vehicleDto.getModel());
        return repository.save(vehicleDB);
    }

    @Override
    public void deleteVehicle(int id) {
        repository.deleteById(id);
    }

    @Override
    public VehicleEntity getVehicle(int idV) throws VehicleDoesNotExistsException {
        return repository.findById(idV).orElseThrow(() -> new VehicleDoesNotExistsException());
    }
    
}
