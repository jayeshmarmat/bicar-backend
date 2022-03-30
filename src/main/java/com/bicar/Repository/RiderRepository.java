package com.bicar.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicar.entity.Rider;

@Repository
@Transactional
public interface RiderRepository extends JpaRepository<Rider, Integer> {

}
