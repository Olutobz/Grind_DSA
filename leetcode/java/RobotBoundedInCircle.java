package java;

public class RobotBoundedInCircle {

    // TC -> O(N), SC -> O(1)
    public boolean isRobotBounded(String instructions) {
        if (instructions.isEmpty()) {
            return false;
        }
        int x = 0, y = 0;
        String directions = "North";

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                switch (directions) {
                    case "North":
                        y += 1;
                        break;
                    case "South":
                        y -= 1;
                        break;
                    case "East":
                        x += 1;
                        break;
                    default:
                        x -= 1;
                        break;
                }
            } else if (ch == 'L') {
                switch (directions) {
                    case "North":
                        directions = "West";
                        break;
                    case "West":
                        directions = "South";
                        break;
                    case "South":
                        directions = "East";
                        break;
                    default:
                        directions = "North";
                        break;
                }
            } else if (ch == 'R') {
                switch (directions) {
                    case "North":
                        directions = "East";
                        break;
                    case "East":
                        directions = "South";
                        break;
                    case "South":
                        directions = "West";
                        break;
                    default:
                        directions = "North";
                        break;
                }
            }
        }

        if (x == 0 && y == 0)
            return true;
        return !directions.equals("North");
    }
}
