package com.example.huydu.ledcontrol;

public enum LedStatus {

    LED_1_ON (65),
    LED_1_OFF (66),

    LED_2_ON (97),
    LED_2_OFF (98);

    private long value;

    LedStatus(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }
}
