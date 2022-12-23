// TC: O(n ^ 2)
// SC: O(1)
//Top down approach

public class triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> t) {
            for (int i = 1; i < t.size(); i++) {
                for (int j = 0; j < t.get(i).size(); j++) {
                    int sum = 0;
    
                    if (j == 0) {
                        sum = t.get(i).get(j) + t.get(i - 1).get(j);
                    }
                    else if (j == t.get(i).size() - 1) {
                        sum = t.get(i).get(j) + t.get(i - 1).get(t.get(i - 1).size() - 1);
                    }
                    else {
                        int min = Math.min(t.get(i - 1).get(j), t.get(i - 1).get(j - 1));
                        sum = min + t.get(i).get(j);
                    }
    
                    t.get(i).set(j, sum);
                }
            }
    
            return Collections.min(t.get(t.size() - 1));
        }
    }
    
    
}
