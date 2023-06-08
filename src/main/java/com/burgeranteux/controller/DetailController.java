package com.burgeranteux.controller;

import com.burgeranteux.model.Detail;
import com.burgeranteux.service.DetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/details")
@CrossOrigin("*")
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/{id}")
    public List<Object[]> getDetailsByOrderId(@PathVariable("id") long id) {
        return detailService.getDetailsByOrderId(id);
    }

    @PostMapping("/add")
    public Detail addDetail(@RequestBody Detail detail) {
        return detailService.addDetail(detail);
    }

    @GetMapping("/{orderId}/{userId}")
    public List<Object[]> getDetailsByUserId(@PathVariable("orderId") long orderId, @PathVariable("userId") long userId) {
        return detailService.getDetailsByUserId(orderId, userId);
    }
}
