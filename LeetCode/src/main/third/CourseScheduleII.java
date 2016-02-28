package third;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap();
        for(int i=0;i<n;i++) {
            map.put(i, new Node(i));
        }

        for(int i=0;i<prerequisites.length;i++) {
            Node parent = map.get(prerequisites[i][0]);
            Node child = map.get(prerequisites[i][1]);

            parent.depends++;
            child.parents.add(parent);
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>(n, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.depends < b.depends) {
                    return -1;
                } else if(a.depends == b.depends) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int[] r = new int[n];
        int pos = 0;
        q.addAll(map.values());

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.depends > 0) {
                return new int[0];
            }
            r[pos++] = node.val;

            for(Node p : node.parents) {
                p.depends--;

                // Remove and add node again after priority changed
                q.remove(p);
                q.add(p);
            }
        }

        return r;
    }

    private class Node {
        int val;
        int depends = 0;
        List<Node> parents = new ArrayList();

        public Node(int x) {
            val = x;
        }
    }
}
