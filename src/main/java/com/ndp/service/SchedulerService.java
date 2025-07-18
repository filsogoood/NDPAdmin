package com.ndp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    private AgentService agentService;

    // 1분마다 실행
    @Scheduled(fixedRate = 60000)
    public void checkTelemetryAndUpdateStatus() {
        agentService.updateStaleNodesToPre();
    }
}
