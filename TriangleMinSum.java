//Time complexity is O(m) m is size of triangle
//space complexity is O(m)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> li = new ArrayList<Integer>();
        li.add(triangle.get(0).get(0));
        if(triangle.size()==1)
        {
            return triangle.get(0).get(0);
        }
        int result = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<triangle.get(i).size();j++){
                int t = 0;
                if(j==0){
                    t= triangle.get(i).get(j)+li.get(0);
                }
                else if(j==(triangle.get(i).size()-1)){
                    t= triangle.get(i).get(j)+li.get(li.size()-1);
                }
                else{
                    t = Math.min(li.get(j-1), li.get(j))+triangle.get(i).get(j);
                }
                if(i==(triangle.size()-1)){
                    System.out.println(t);
                    result=Math.min(result, t);
                }
                temp.add(t);
            }
            li = new ArrayList<Integer>(temp);
        }
        return result;
    }
}
