package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.bean.reservation;

public interface reservationRepository  extends CrudRepository<reservation, String>{

}