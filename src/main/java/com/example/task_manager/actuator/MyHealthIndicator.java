package com.example.task_manager.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(someCheck()) {
            return Health.up().build();
        }
        return Health.down().withDetail("reason", "Тут причина проблемы").build();
    }

    public boolean someCheck() {
        return true;
    }
}
