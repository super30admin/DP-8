import java.util.List;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        for(int i=triangle.size()-2; i>=0; i--) {
            List<Integer> list1 = triangle.get(i);
            List<Integer> list2 = triangle.get(i+1);
            for(int j=0; j<list1.size(); j++) {
                int num = list1.get(j);
                num = num + Math.min(list2.get(j), list2.get(j+1));
                list1.set(j, num);
            }
        }

        return triangle.get(0).get(0);
    }
}
