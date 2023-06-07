package com.burgeranteux.repository;

import com.burgeranteux.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

        @Query("SELECT o FROM Order o WHERE o.user.user_id = :userId ORDER BY o.order_id DESC")
        List<Order> findByUserId(Long userId);

        @Query("SELECT DISTINCT p FROM Order p JOIN FETCH p.details d JOIN FETCH d.product")
        List<Order> getPedidosConDetalles();
}
