package tech.makers.twitter;

import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
public class ClockService implements IClockService {
    private Clock clock;

    ClockService() {
        this.clock = Clock.systemUTC();
    }

    public Clock getClock() {
        System.out.println("CALLING THE REAL");
        return this.clock;
    }
}
