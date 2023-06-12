package com.burgeranteux.repository;

import com.burgeranteux.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query("SELECT d.quantity, p.name, o.order_id " +
            "FROM Detail d " +
            "JOIN d.product p " +
            "JOIN d.order o " +
            "WHERE o.order_id = :orderId")
    List<Object[]> getDetailsByOrderId(@Param("orderId") Long orderId);

    @Query("SELECT d.quantity, p.name, o.order_id " +
            "FROM Detail d " +
            "JOIN d.product p " +
            "JOIN d.order o " +
            "JOIN o.user u " +
            "WHERE o.order_id = :orderId " +
            "AND u.user_id = :userId")
    List<Object[]> getDetailsByUserId(@Param("orderId") Long orderId, @Param("userId") Long userId);
}
