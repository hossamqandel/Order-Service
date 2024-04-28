package com.example.order.component.initializer;

import com.example.order.entity.Status;
import com.example.order.enums.StatusEnums;
import com.example.order.repo.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StatusInitializer implements CommandLineRunner {

    private final StatusRepository statusRepository;

    @Override
    public void run(String... args) {
        statusRepository.saveAll(createStatuses());
    }

    private List<Status> createStatuses(){
        var data = new Status(1L, StatusEnums.PAID.getValue(), true);
        var data2 = new Status(2L, StatusEnums.PENDING.getValue(), true);
        var data3 = new Status(3L, StatusEnums.CANCELLED.getValue(), true);
        return List.of(data, data2, data3);
    }
}
