package s30.dp.dp8;

import java.util.List;


//Algo: Bottom Up DP :-> for every element we have two decisions ans choose which is smaller, do that on the fly.

//TC: O(n^2);
//SC: O(1);
public class Triangle {


    public int minimumTotal(List<List<Integer>> triangle) {


        for(int i=1; i< triangle.size(); i++){

            List<Integer> prev = triangle.get(i-1);
            List<Integer> curr = triangle.get(i);


            curr.set(0, prev.get(0)+ curr.get(0));

            for(int j = 1; j < curr.size()-1; j++ ){

                int ele = Math.min(prev.get(j-1), prev.get(j));

                curr.set(j, ele + curr.get(j));

            }

            curr.set(curr.size()-1,
                    prev.get(prev.size()-1) + curr.get(curr.size()-1));
        }


        int ans = Integer.MAX_VALUE;

        for(int num: triangle.get(triangle.size()-1)){
            ans  = Math.min(ans, num);
        }


        return ans;

    }



    public static void main(String[] args) {

    }
}
