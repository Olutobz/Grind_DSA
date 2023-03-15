public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        // initial direction of robot
        String directions = "North";
        /*
                    North
            West                East
                    South

        */

        // TC -> O(N), SC -> O(1)
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                /*
                switch (directions) {
                    case "North" -> y += 1;
                    case "South" -> y -= 1;
                    case "East" -> x += 1;
                    default -> x -= 1;
                }*/
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
