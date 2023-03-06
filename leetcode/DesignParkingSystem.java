import java.util.HashMap;
import java.util.Map;

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
public class DesignParkingSystem {
    int big, medium, small;

    public DesignParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // TC -> O(1), SC -> O(1)
    public boolean addCar(int carType) {
        if (carType == 1 && big == 0 || carType == 2 && medium == 0 || carType == 3 && small == 0) {
            return false;
        }
        if (carType == 1) big--;
        if (carType == 2) medium--;
        if (carType == 3) small--;
        return true;
    }

    static class ParkingSystemII {
        private final Map<Integer, Integer> map = new HashMap<>();
        public ParkingSystemII(int big, int medium, int small) {
            this.map.put(1, big);
            this.map.put(2, medium);
            this.map.put(3, small);
        }

        // TC -> O(1), SC -> O(N)
        public boolean addCar(int carType) {
            int parkingSlot = map.get(carType);
            if (parkingSlot > 0) {
                map.put(carType, parkingSlot - 1);
                return true;
            }
            return false;
        }
    }
}
