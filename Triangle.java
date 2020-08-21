/**
 * Path sum: calculated using falling path sum..modifying in the same list.
 * Path : calculated using-min ele which is on left and right of the ele contributing to the path.
 *
 * time: O(m*n) m- length of the triangle list, n- max length of the sub lists
 * space: O(m)
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }

        int dest = 0, res = triangle.get(0).get(0);
        List<Integer> lst = new ArrayList<>();

        for(int i=1;i<n;i++){
            int prev = Math.min(triangle.get(i).get(dest),triangle.get(i).get(dest+1));
            lst.add(res-prev);
            dest = prev == triangle.get(i).get(dest) ? dest : dest+1;
            res = prev;
        }
        lst.add(res);

        for(int i: lst)
            System.out.println(i);

        return triangle.get(0).get(0);
    }
}