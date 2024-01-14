package org.hms.room.entity.enums;

public enum RoomCode {
    Single ("SGL"),

    Dormitory ("DOM"),

    Special ("SPL"),

    ICO ("ICU");


    String roomCode;

    RoomCode(String roomCode){this.roomCode=roomCode;}
}
