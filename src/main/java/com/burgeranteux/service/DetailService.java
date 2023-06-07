package com.burgeranteux.service;

import com.burgeranteux.model.Detail;
import com.burgeranteux.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public Detail addDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    public List<Detail> getDetailsByOrderId(Long orderId) {
        return detailRepository.findByOrderId(orderId);
    }

    public List<Detail> getDetallesConPedidoYProducto() {
        return detailRepository.getDetallesConPedidoYProducto();
    }

    public Detail findById(Long id) {
        return detailRepository.findById(id).orElse(null);
    }
}
