package google;

/*  You are given a string that represents time in the format hh:mm. Some digits are blank (represented by ?).
    Fill in ? such that the time represented by this string is the maximum possible.
    Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.

    Examples:
    Input: "?4:5?"
    Output: "14:59"

    Input: "2?:22"
    Output: "23:22"

    Input: "0?:??"
    Output: "09:59"

    Input: "??:??"
    Output: "23:59"

* */
public class MaximumTime {

    // TC -> O(1), SC -> O(64)
    public String getMaxTime(String time) {
        if (time == null || time.length() == 0) return "";

        char[] timeChar = time.toCharArray();

        if (time.charAt(0) == '?') {
            timeChar[0] = (timeChar[1] <= '3' || timeChar[1] == '?') ? '2' : '1';
        }

        if (time.charAt(1) == '?') {
            timeChar[1] = (timeChar[0] == '2') ? '3' : '2';
        }

        timeChar[3] = (timeChar[3] == '?') ? '5' : timeChar[3];
        timeChar[4] = (timeChar[4] == '?') ? '9' : timeChar[3];

        return new String(timeChar);
    }

}
