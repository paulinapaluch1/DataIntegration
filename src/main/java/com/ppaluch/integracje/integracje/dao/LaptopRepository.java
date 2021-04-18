package com.ppaluch.integracje.integracje.dao;

import com.ppaluch.integracje.integracje.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository  extends JpaRepository<Laptop, Integer> {
}
