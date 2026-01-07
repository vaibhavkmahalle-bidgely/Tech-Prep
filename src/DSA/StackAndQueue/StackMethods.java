package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

class StackMethods {
    class Pair{
        int idx ;
        int val ;
        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] NSL(int[] arr){
        int N = arr.length;
        int[] result = new int[N];
        ArrayDeque<Pair> stack = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && stack.peek().val >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().val < arr[i]){
                result[i] = stack.peek().idx ;
            }else if(stack.isEmpty()){
                result[i] = -1;
            }

            stack.push(new Pair(i,arr[i]));
        }
        return result;
    }
    public int[] NSR(int[] arr){
        int N = arr.length;
        int[] result = new int[N];
        ArrayDeque<Pair> stack = new ArrayDeque<>();

        for(int i=N-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek().val >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().val < arr[i]){
                result[i] = stack.peek().idx;
            }else if(stack.isEmpty()){
                result[i] = N ;
            }

            stack.push(new Pair(i,arr[i]));
        }
        return result;
    }
    public int maxArea(int[] left, int[] right, int idx, int[][] histoGram){
        int N = left.length;
        int maxArea = 0;
        for(int i=0; i < N ; i++){
            int area = (right[i] - left[i] - 1)* histoGram[idx][i] ;

            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        int[][] intMatrix = new int[rows][cols];
        int[][] histoGram = new int[rows][cols];


        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == '1')
                    intMatrix[i][j] = 1 ;
                else if(matrix[i][j] == '0')
                    intMatrix[i][j] = 0;
            }
        }

        if(rows == 1 && cols == 1){
            return intMatrix[0][0];
        }


        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(i == 0){
                    histoGram[i][j] = intMatrix[i][j];
                }else{
                    if(intMatrix[i][j] == 0){
                        histoGram[i][j] = 0;
                    }else{
                        histoGram[i][j] = intMatrix[i][j] + histoGram[i-1][j];
                    }
                }
            }
        }



        for(int i=0; i<rows; i++){
            int area = maxArea(NSL(histoGram[i]),NSR(histoGram[i]), i, histoGram);

            maxArea = Math.max(maxArea, area);
        }



        return maxArea;
    }

    public static void main(String[] args) {
        StackMethods obj = new StackMethods();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(obj.maximalRectangle(matrix));
    }
}
