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

    public static void main(String[] args) {
        String[] rh = new String[]{"A", "B", "C"};
        String[] newUser = new String[]{"B", "C", "D"};
        System.out.println(Arrays.toString(referUsers(rh, newUser)));
    }

    //1. Building the Referral Network:
    //A graph-like structure is created using a Map to represent users and their referrals.
    //Each user is represented as a Node with a list of referred users (children).
    //Referrals are added as edges between nodes in the graph.

    //2. Calculating Referrals:
    //A Depth-First Search (DFS) algorithm is used to
    // recursively count the number of referrals for each user.
    //The DFS starts from a user and traverses their referral tree,
    // incrementing the count for each child.

    //3. Building the Leaderboard:
    //A PriorityQueue is used to efficiently sort users based on their referral count.
    //Users with higher referral counts are prioritized, and ties are broken alphabetically.
    //The top 3 users are extracted from the queue and added to the leaderboard.

    /*
    * The Node class represents a user and their referrals.
    The buildReferralChain method constructs the referral network.
    The dfs function recursively calculates referrals.
    The PriorityQueue sorts users based on referrals and alphabetical order.
    The referUsers method orchestrates the entire process,
    * building the graph,
    * calculating referrals,
    *  and constructing the leaderboard.
    *
    * */

    private static String[] referUsers(String[] rh_users, String[] new_users) {
        Map<String, NodeReferral> graph = buildReferralChain(rh_users, new_users);

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p2.referrals == p1.referrals) {
                return p1.nodeReferral.user.compareTo(p2.nodeReferral.user);
            }
            return p2.referrals - p1.referrals;
        });

        for (String key : graph.keySet()) {
            NodeReferral nodeReferral = graph.get(key);
            int res = dfs(nodeReferral, 0);
            Pair curPair = new Pair(nodeReferral, res);
            pq.add(curPair);
        }

        List<String> list = new ArrayList<>();
        while (!pq.isEmpty() && list.size() < 3) {
            Pair curr = pq.poll();
            if (curr.referrals != 0) list.add(curr.nodeReferral.user + " " + curr.referrals);
        }

        String[] leaderBoard = new String[list.size()];
        for (int i = 0; i < list.size(); i++) leaderBoard[i] = list.get(i);

        return leaderBoard;
    }

    // To recursively count referrals.
    private static int dfs(NodeReferral nodeReferral, int count) {
        if (nodeReferral.children.isEmpty()) {
            return 0;
        }

        int res = 0;
        for (NodeReferral child : nodeReferral.children) {
            res += dfs(child, count + 1) + 1;
        }
        return res;
    }

    // The referral network is represented as a graph,
    // where nodes are users and edges represent referral relationships.
    private static Map<String, NodeReferral> buildReferralChain(String[] rhUsers, String[] newUsers) {
        Map<String, NodeReferral> map = new HashMap<>();

        for (int i = 0; i < rhUsers.length; i++) {
            String rhUser = rhUsers[i];
            String newUser = newUsers[i];

            NodeReferral rhUserNodeReferral = map.getOrDefault(rhUser, new NodeReferral(rhUser));
            NodeReferral newUserNodeReferral = map.getOrDefault(newUser, new NodeReferral(newUser));

            rhUserNodeReferral.addChild(newUserNodeReferral);

            map.put(rhUser, rhUserNodeReferral);
            map.put(newUser, newUserNodeReferral);
        }

        return map;
    }
}

// use Node
class NodeReferral {
    String user;
    List<NodeReferral> children;

    NodeReferral(String user) {
        this.user = user;
        children = new ArrayList<>();
    }

    void addChild(NodeReferral child) {
        this.children.add(child);
    }
}

class Pair {
    NodeReferral nodeReferral;
    int referrals;

    Pair(NodeReferral nodeReferral, int ref) {
        this.nodeReferral = nodeReferral;
        this.referrals = ref;
    }
}

