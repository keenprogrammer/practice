package com.paypal.bfs.test.employeeserv.Repository;

import com.paypal.bfs.test.employeeserv.data.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddresRepository extends JpaRepository<AddressEntity, Integer> {
}
