package src.jdbc.Homework2.Task3;

/**
 * Class consists comparator for Units by Power decrement sorting
 * @author Filatova nadia
 * @version 1.0  April 28, 2023.
 */
public class UnitPowerComparator implements java.util.Comparator<Unit>{
        public int compare(Unit un1, Unit un2) {
            return (un1.getUnitPower() - un2.getUnitPower());
        }

}
