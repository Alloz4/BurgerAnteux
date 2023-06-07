package com.burgeranteux.repository;

import com.burgeranteux.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query("SELECT d FROM Detail d WHERE d.order.order_id = :orderId")
    List<Detail> findByOrderId(Long orderId);

    @Query("SELECT d FROM Detail d JOIN FETCH d.order JOIN FETCH d.product")
    List<Detail> getDetallesConPedidoYProducto();
}
