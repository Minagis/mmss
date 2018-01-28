package com.example.mms.dao;

import com.example.mms.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {

    Address findAddressById(Integer id);

//    @Query("select h.city as city, h.name as name, avg(r.rating) as averageRating "
//            + "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
//    Page<HotelSummary> findByCity(City city, Pageable pageable);
}
