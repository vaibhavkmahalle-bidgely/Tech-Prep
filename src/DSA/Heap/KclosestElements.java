package dsa.heap;

import java.util.*;



class Pair{
    Integer first;
    Integer second;
    Pair(Integer first,Integer second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.first.equals(b.first)) {
                return b.second - a.second; // If distances are equal, compare values (max-heap based on values)
            }
            return b.first - a.first; // Max-heap based on distances
        });
        for(int i=0;i<arr.length;i++){
            Integer first= Math.abs(arr[i]-x);
            Integer second=arr[i];
            pq.add(new Pair(first,second));
            if(pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            list.add(pq.peek().second);
            pq.poll();
        }
        Collections.sort(list);
        return list;

    }
}



public class KclosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int N = arr.length;
        int[] dist = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<N; i++){
            dist[i] = arr[i] - x;
            map.put(dist[i],arr[i]);
        }
        System.out.println("Dist array: " + Arrays.toString(dist));

        for(int i=0; i<N; i++){
            maxHeap.add(dist[i]);
            if(maxHeap.size()> k){
                maxHeap.poll();
            }
        }



        while(!maxHeap.isEmpty()){
            result.add(0, map.get(maxHeap.poll()));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println("k closest elements : " + findClosestElements(arr,4,3));
    }
}
