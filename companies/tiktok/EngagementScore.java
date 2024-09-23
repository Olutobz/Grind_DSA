package tiktok;

import java.util.Collections;
import java.util.List;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 24, August 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Find the minimum number of days required for the AI model to reach the targetEngagement score
 * <p>
 * complete the function
 * static long minDaysToTargetEngagement(long initialEngagementScore,
 * long targetEngagementScore, List<Long> trainingEngagementScore
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * initialScore = 0
 * targetScore = 30
 * trainingScore = [15, 3, 2]
 * Output -> 6
 *
 * Explanation
 * On the first 2 days, the score of the Ai is increased by 1 and 2 respectively.
 * Score = 0 + 1 + 2 = 3
 * then, Ai can be trained on the 2nd data set. Score = 3 + 3 =6
 * on the 4th and 5th day, the score the Ai is increased by 4 & 5 respectively.
 * Score = 6 + 5 = 15
 * on the 6th day, the AI is trained on the 1st data set. Score = 15 + 15 = 30
 *
 * Example 2:
 * initialEngagementScore = 1
 * targetEngagementScore = 30
 * trainingEngagementScore = [17, 3, 2]
 * output = 7
 * </pre>
 * </blockquote>
 */

public class EngagementScore {

    // TC -> O(n^2), SC -> O(n)
    public static long minDaysToTargetEngagement(
            long initialEngagementScore,
            long targetEngagementScore,
            List<Long> trainingEngagementScore
    ) {

        long currentScore = initialEngagementScore;
        long day = 0;
        long dayIncrement = 1;

        trainingEngagementScore.sort(Collections.reverseOrder());

        while (currentScore < targetEngagementScore) {
            currentScore += dayIncrement;
            day++;

            for (long trainingScore : trainingEngagementScore) {
                if (currentScore >= trainingScore) {
                    currentScore += trainingScore;
                    break;
                }
            }

            dayIncrement++;
        }

        return day;
    }
}
