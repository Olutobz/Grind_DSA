package robinhood;

import java.util.*;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Robinhood is famous for its referral program. It’s exciting to see our users
 * spreading the word across their friends and family.
 * One thing that is interesting about the program is the network effect it creates.
 * We would like to build a dashboard to track the status of the program. Specifically,
 * we would like to learn about how people refer others through the chain of referral.
 * <p>
 * For the purpose of this question, we consider that a person refers all other people down the referral chain. For example, A refers B, C, and D in a referral chain of A -> B -> C -> D. Please build a leaderboard for the top 3 users who have the most referred users along with the referral count.
 * Referral rules:
 * A user can only be referred once.
 * Once the user is on the RH platform, he/she cannot be referred by other users. For example: if A refers B, no other user can refer A or B since both of them are on the RH platform.
 * Referrals in the input will appear in the order they were made.
 * <p>
 * Leaderboard rules:
 * The user must have at least 1 referral count to be on the leaderboard.
 * The leaderboard contains at most 3 users.
 * The list should be sorted by the referral count in descending order.
 * If there are users with the same referral count, break the ties by the alphabetical order of the username.
 * <blockquote>
 * <pre>
 * Input
 * rh_users = ["A", "B", "C"]
 * | | |
 * v v v
 * new_users = ["B", "C", "D"]
 * Output
 * ["A 3", "B 2", "C 1"]
 * [execution time limit] 3 seconds (java)
 * [memory limit] 1 GB
 *
 *
 * [input] array.string rh_users
 * A list of referring users.
 * [input] array.string new_users
 * A list of user that was referred by the users in the referrers array with the same order.
 * [output] array.string
 * An array of 3 users on the leaderboard. Each of the element here
 * would have the "[user] [referral count]" format. For example, "A 4".
 *  </pre>
 * </blockquote>
 */

public class ReferralProgram {

    private String[] solution(String[] rh_users, String[] new_users) {
        Map<String, Node> graph = buildGraph(rh_users, new_users);

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p2.referrals == p1.referrals) {
                return p1.node.user.compareTo(p2.node.user);
            }
            return p2.referrals - p1.referrals;
        });

        for (String key : graph.keySet()) {
            Node node = graph.get(key);
            int res = graphTraversal(node, 0);
            Pair curPair = new Pair(node, res);
            pq.add(curPair);
        }

        List<String> list = new ArrayList<>();
        while (!pq.isEmpty() && list.size() < 3) {
            Pair curr = pq.poll();
            if (curr.referrals != 0) list.add(curr.node.user + " " + curr.referrals);
        }

        String[] leaderBoard = new String[list.size()];
        for (int i = 0; i < list.size(); i++) leaderBoard[i] = list.get(i);

        return leaderBoard;
    }

    private int graphTraversal(Node node, int count) {
        if (node.children.isEmpty()) {
            return 0;
        }

        int res = 0;
        for (Node child : node.children) {
            res += graphTraversal(child, count + 1) + 1;
        }
        return res;
    }

    private Map<String, Node> buildGraph(String[] rhUsers, String[] newUsers) {
        Map<String, Node> map = new HashMap<>();

        for (int i = 0; i < rhUsers.length; i++) {
            String rhUser = rhUsers[i];
            String newUser = newUsers[i];

            Node rhUserNode = map.getOrDefault(rhUser, new Node(rhUser));
            Node newUserNode = map.getOrDefault(newUser, new Node(newUser));

            rhUserNode.addChild(newUserNode);

            map.put(rhUser, rhUserNode);
            map.put(newUser, newUserNode);
        }

        return map;
    }
}

class Node {
    String user;
    List<Node> children;

    Node(String user) {
        this.user = user;
        children = new ArrayList<>();
    }

    void addChild(Node child) {
        this.children.add(child);
    }
}

class Pair {
    Node node;
    int referrals;

    Pair(Node node, int ref) {
        this.node = node;
        this.referrals = ref;
    }
}

