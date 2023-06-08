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

    public List<Object[]> getDetailsByOrderId(long id) {
        return detailRepository.getDetailsByOrderId(id);
    }

    public List<Object[]> getDetailsByUserId(long orderId, long userId) {
        return detailRepository.getDetailsByUserId(orderId, userId);
    }

}
