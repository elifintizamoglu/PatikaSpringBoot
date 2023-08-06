package com.elifintizam.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// hibernate yapısını sağlayacak kod işlemleri kullanacağımız yapılar
// jparepository > crudrepository daha geniştir
// repository yapısı interfacedir

@Repository
public interface EmployeeRepository extends CrudRepository {
}
