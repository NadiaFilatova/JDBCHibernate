package src.jdbc.Homework2.Task3;

import java.util.Objects;

/**
 * Class is created for storing info for Unit
 *
 * @author Filatova Nadia
 * @version 1.0  April 28, 2023.
 */
public class Unit {

    private static int unitIdCounter = 1;

    private final int unitId;

    private final String unitName;

    private Room room;

    private final int power;

    private boolean isPowerOn;

    /**
     * Constructor - returns new Unit Object
     * @param unitName - String - name for new Unit
     * @param power    - power - for new Unit
     * @param room     - current Room object
     */
    public Unit(String unitName, int power, Room room) {
        unitId = unitIdCounter++;
        this.unitName = unitName;
        this.power = power;
        this.room = room;
    }

    /**
     * Method returns Unit ID number
     * @return - int - unit ID number
     */
    public int getUnitId() {
        return unitId;
    }

    /**
     * Method returns Unit power value
     * @return - int - unit power value
     */
    public int getUnitPower() {
        return power;
    }

    /**
     * Method returns Unit String Name
     * @return - String  - unit Name
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Method replace current room Object from current unit with Null value
     * @return nothing
     */
    public void removeRoomFromUnit() {
        room = null;
    }

    /**
     * Method switch currant Unit ON
     * @return nothing
     */
    public void powerOnUnit() {
        this.isPowerOn = true;
    }

    /**
     * Method switch currant Unit OFF
     * @return nothing
     */
    public void powerOffUnit() {
        this.isPowerOn = false;
    }

    /**
     * Method returns the current Unit power status
     * @return true - is unit is powered ON otherwise false
     */
    public boolean isUnitPoweredOn() {
        return isPowerOn;
    }

    /**
     * Overrided method toString - returns text description for Unit object
     * @return - String with the Unit fields
     */
    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", room=" + room +
                ", power=" + power +
                ", isPowerOn=" + isPowerOn +
                "}";
    }

    /**
     * Overrided method equals for Unit equals check
     * @param obj - another Unit Object
     * @return true, if Units are identic, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Unit unit = (Unit) obj;
        if (unitId != unit.unitId) return false;
        if (power != unit.power) return false;
        if (!unitName.equals(unit.unitName)) return false;
        return Objects.equals(room, unit.room);
    }

}
