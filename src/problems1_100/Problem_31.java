package problems1_100;

import java.util.*;

/**
 * Created by Lagrange on 3/31/2017.
 */
public class Problem_31 {
    static int[] nums = {200,100,50,20,10,5,2,1};
    static int size = nums.length;

    static HashMap<Integer,Integer> pivots = new HashMap<>();

    public static int checkSum(HashMap<Integer,Integer> pivots){

        int target = 200;
        int sum = 0;

        for(Integer key: pivots.keySet()){
            int pivot = pivots.get(key);
            sum +=  nums[pivot];
            if(sum > target) return 1;
        }

        if(sum < target) return -1;

        return 0;
    }

    public static void shift(HashMap<Integer,Integer> pivots, int pivot_node){

        if(pivots.size() + nums[pivots.get(1)] == 201 && pivots.get(1) != 0){
            System.out.println("\n\n\ngot here\n\n\n");
            int p_1 = pivots.get(1);
            pivots.clear();
            pivots.put(1 , p_1);
            shift(pivots, 1);
            return;
        }

        if(pivots.get(pivot_node) != size - 1) {
            pivots.put(pivot_node, pivots.get(pivot_node) + 1);
        }
        else{
            shift(pivots , pivot_node - 1);
        }

    }



    public static void branch(HashMap<Integer,Integer> pivots){
        pivots.put(pivots.size() + 1, pivots.get(pivots.size()));
    }

    public static int ass(){
        int target  = 200;
        int ways = 0;

        for (int a = target; a >= 0; a -= 200) {
            for (int b = a; b >= 0; b -= 100) {
                for (int c = b; c >= 0; c -= 50) {
                    for (int d = c; d >= 0; d -= 20) {
                        for (int e = d; e >= 0; e -= 10) {
                            for (int f = e; f >= 0; f -= 5) {
                                for (int g = f; g >= 0; g -= 2) {
                                    ways++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ways;
    }




    public static int search(){
        int bool = checkSum(pivots);

        int n = 0;
        int count = 0;

        while(n < 25) {
            count++;
            if (bool == 0) {

                n++;


                System.out.println("\n--   N = " + n + "   --\n");
                for (Integer i : pivots.keySet()) {
                    System.out.println("count:" + count + "  node:" + i + " val: " + nums[pivots.get(i)]);
                }


                shift(pivots, pivots.size());
                System.out.print("\n---------------------\n");
            }else if (bool == -1) {

                for (Integer i : pivots.keySet()) {
                    System.out.println("count:" + count + "  node:" + i + " val: " + nums[pivots.get(i)]);
                }

                System.out.print("\n---------------------\n");
                branch(pivots);

            }else if (bool == 1) {

                for (Integer i : pivots.keySet()) {
                    System.out.println("count:" + count + "  node:" + i + " val: " + nums[pivots.get(i)]);
                }
                System.out.print("\n---------------------\n");

                shift(pivots, pivots.size());

            }

            bool = checkSum(pivots);

        }

        return n;

    }











    public static void solve(){
        HashMap<Integer,Integer> p = new HashMap<>();
        pivots.put(1,0);

        int n = search();

        System.out.print("\n\n------------\n\n"+ "n: " + n);

    }


}
//class MyTreeNode<T>{
//    private T data = null;
//    private List<MyTreeNode> children = new ArrayList<>();
//    private MyTreeNode parent = null;
//
//    public MyTreeNode(T data) {
//        this.data = data;
//    }
//
//    public void addChild(MyTreeNode child) {
//        child.setParent(this);
//        this.children.add(child);
//    }
//
//    public void addChild(T data) {
//        MyTreeNode<T> newChild = new MyTreeNode<>(data);
//        newChild.setParent(this);
//        children.add(newChild);
//    }
//
//    public void addChildren(List<MyTreeNode> children) {
//        for(MyTreeNode t : children) {
//            t.setParent(this);
//        }
//        this.children.addAll(children);
//    }
//
//    public List<MyTreeNode> getChildren() {
//        return children;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    private void setParent(MyTreeNode parent) {
//        this.parent = parent;
//    }
//
//    public MyTreeNode getParent() {
//        return parent;
//    }
//}
