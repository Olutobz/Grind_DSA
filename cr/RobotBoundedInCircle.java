public class RobotBoundedInCircle {

    // TC -> O(N), SC -> O(1)
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0) {
            return false;
        }

        // initial points of the robot
        int x = 0, y = 0;
        // initial direction of robot
        String directions = "North";

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (directions.equals("North"))
                    y += 1;
                else if (directions.equals("South"))
                    y -= 1;
                else if (directions.equals("East"))
                    x += 1;
                else
                    x -= 1;
            } else if (ch == 'L') {
                if (directions.equals("North"))
                    directions = "West";
                else if (directions.equals("West"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "East";
                else directions = "North";
            } else if (ch == 'R') {
                if (directions.equals("North"))
                    directions = "East";
                else if (directions.equals("East"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "West";
                else directions = "North";
            }
        }

        if (x == 0 && y == 0)
            return true;
        return !directions.equals("North");
    }
}
