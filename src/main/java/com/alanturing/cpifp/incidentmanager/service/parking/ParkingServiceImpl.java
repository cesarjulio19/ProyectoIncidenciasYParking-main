package com.alanturing.cpifp.incidentmanager.service.parking;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserAlreadyHasParkingRequest;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingDto;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingRepository;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private final UserRepository userRepository;

    public ParkingServiceImpl(ParkingRepository repository, UserRepository repository2) {
        this.parkingRepository = repository;
        this.userRepository = repository2;
    }

    @Override
    public Iterable<ParkingEntity> getAll() {
        return parkingRepository.findAll();
    }

    @Override
    public ParkingEntity createRequest(ParkingDto request) throws UserDoesNotExistsException, UserAlreadyHasParkingRequest {
        int userId = request.getUser_id();
        UserEntity user = this.userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException());
        ParkingEntity newRequest = new ParkingEntity();
        BeanUtils.copyProperties(request, newRequest, "user_id");
        newRequest.setUser(user);
        newRequest.setDate(LocalDate.now());
        return parkingRepository.save(newRequest);
        
    }

    @Override
    public ParkingEntity updateRequest(int id, ParkingDto request) throws RequestDoesNotExistsException {
        ParkingEntity requestDB = parkingRepository.findById(id).orElseThrow(() -> new RequestDoesNotExistsException());
        requestDB.setState(request.getState());
        return parkingRepository.save(requestDB);
    }

    @Override
    public void deleteRequest(int id) {
        parkingRepository.deleteById(id);
    }
}
