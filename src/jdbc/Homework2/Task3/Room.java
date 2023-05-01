package src.jdbc.Homework2.Task3;

import java.util.ArrayList;

/**
 * Class used for storing Units in private ArrayList
 * @author Filatova Nadia
 * @version 1.0  April 28, 2023.
 */
public class Room {
    private final String roomName;

    private final ArrayList<Unit> roomUnits;

    /**
     * Constructor - returns new Room Object
     * @param roomName - Need to provide not Null or consists minimum one char Room Name
     * @throws  IllegalArgumentException in case when Room Name is Null
     */
    public Room(String roomName){
        if (roomName == null || roomName.equals("")) throw new IllegalArgumentException("Room Name Can't be Null");
        this.roomName = roomName;
        this.roomUnits= new ArrayList<>();
    }

    /**
     * Adding new Unit into room units Array
     * @param unit - Unit object needs to be not Null value;
     * @throws  IllegalArgumentException in case when Unit Object is Null
     */
    public void assignUnitToRoom(Unit unit){
        if (unit==null) throw new IllegalArgumentException("Unit can't be null");
        if (!checkExistsUnit(unit)) roomUnits.add(unit);
    }
    /**
     * Adding new Unit into room units Array
     * @param unit - Unit object needs to be not Null value;
     * @throws  IllegalArgumentException in case when Unit Object is Null
     */
    public void deleteUnit(Unit unit){
        if (unit==null) throw new IllegalArgumentException("Unit can't be null");
        if (checkExistsUnit(unit)) roomUnits.remove(unit);
    }

    /**
     * Method returns current room Object Name
     * @return - String with the Room Name
     */
    public String getRoomName(){
        return roomName;
    }

    /**
     * Method returns current room Object Units
     * @return - Units ArrayList
     */
    public ArrayList<Unit> getRoomUnits(){
        return roomUnits;
    }

    /**
     * Private method checks if the unit already exists
     * Used in adding new unit unto room;
     * @param unit -
     * @return - true if unit was found otherwise false
     */
    private boolean checkExistsUnit(Unit unit){
        for (Unit un : roomUnits) {
            if (un.equals(unit)) return true;
        }
        return false;
    }

    /**
     * Overrided method equals for Room equals check
     * @param o - another Room Object
     * @return true, if rooms are identic, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return roomName.equalsIgnoreCase(room.roomName);

    }

    /**
     * Overrided method toString - returns Room Name
     * @return - String with the Room Name
     */
    @Override
    public String toString() {
        return  roomName ;
    }
}
