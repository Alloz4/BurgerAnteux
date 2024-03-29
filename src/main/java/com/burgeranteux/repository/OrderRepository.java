package com.burgeranteux.repository;

import com.burgeranteux.model.Order;
import com.burgeranteux.model.Product;
import com.burgeranteux.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

        @Query("SELECT o FROM Order o WHERE o.user.user_id = :userId ORDER BY o.order_id DESC")
        List<Order> findByUserId(Long userId);


}
