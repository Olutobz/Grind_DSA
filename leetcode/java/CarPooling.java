package java;

public class CarPooling {

    /*  passengerCount: [...2,2,2,2,2,2,2,2....]
        point:          [...1,2,3,4,5,6,7,8....]
     */

    // TC -> O(N), SC -> O(N) or O(1001); where (N is the number of trips, M is the nums of stops)
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return false;

        int lastEndPoint = 0;
        for (int[] trip : trips) {
            lastEndPoint = Math.max(lastEndPoint, trip[2]);
        }

        int[] passengerCount = new int[lastEndPoint + 1];

        for (int[] trip : trips) {
            int start = trip[1], end = trip[2];
            passengerCount[start] += trip[0];
            passengerCount[end] -= trip[0];
        }

        int currCapacity = 0;
        for (int i = 0; i <= lastEndPoint; i++) {
            currCapacity += passengerCount[i];
            if (currCapacity > capacity) return false;
        }

        return true;
    }

    // TC -> O(N), SC -> O(1001); where (N is the number of trips, M is the nums of stops)
    public boolean carPoolingI(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return false;

        int[] numsOfTrips = new int[1001];
        for (int[] trip : trips) {
            numsOfTrips[1] += trip[0];
            numsOfTrips[2] += trip[0];
        }

        int currCapacity = 0;
        for (int num : numsOfTrips) {
            currCapacity += num;
            if (currCapacity > capacity) return false;
        }

        return true;
    }

    // TC -> O(N * M), SC -> O(1001); where (M is the number of stops)
    public boolean carPoolingII(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return false;

        // assuming we have 1000 trips
        int[] nums = new int[1001];

        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                nums[i] += trip[0];
            }
        }

        for (int num : nums) {
            if (num > capacity) return false;
        }

        return true;
    }


}
