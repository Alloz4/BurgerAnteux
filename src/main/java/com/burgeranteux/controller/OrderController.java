package com.burgeranteux.controller;

import com.burgeranteux.model.Detail;
import com.burgeranteux.model.Order;
import com.burgeranteux.model.Product;
import com.burgeranteux.service.DetailService;
import com.burgeranteux.service.OrderService;
import com.burgeranteux.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;
    private final DetailService detailService;
    private final ProductService productService;

    public OrderController(OrderService orderService, DetailService detailService, ProductService productService) {
        this.orderService = orderService;
        this.detailService = detailService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Order> getOrder() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/user/{user_id}")
    public List<Order> getOrderByUser(@PathVariable("user_id") long user_id) {
        return orderService.getOrderByUser(user_id);
    }

    @GetMapping
    public List<Order> obtenerPedidosConDetalles() {
        List<Order> pedidos = orderService.getPedidosConDetalles();

        for (Order pedido : pedidos) {
            for (Detail detalle : pedido.getDetails()) {
                Long productoId = detalle.getProduct().getProduct_id();
                Product producto = productService.getProduct(productoId);
                if (producto != null) {
                    detalle.getProduct().setName(producto.getName());
                }
            }
        }

        return pedidos;
    }
}
