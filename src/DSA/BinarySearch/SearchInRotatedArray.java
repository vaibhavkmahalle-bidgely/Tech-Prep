package DSA.BinarySearch;

public class SearchInRotatedArray {

    public static int binarySearch(int[] nums, int target, int start, int end){
        System.out.println("Calling with : start: " + start + ", end : "+ end );
        while(start <= end){
            int mid = start + (end - start)/2 ;

            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]){
                end = mid - 1;
            }
            if(target > nums[mid]){
                start = mid + 1;
            }
        }

        return -1;
    }
    public static int search(int[] nums, int target) {
        // find minimum index
        // then apply binary search on two arrays

        int N = nums.length - 1;
        int start = 0, end = N ;
        int lowIdx = -1;
        boolean flag = false;

        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            int lMid = (mid + N - 1) % N;
            int rMid = (mid + 1) % N;

            if(nums[lMid] <= nums[mid] && nums[mid] >= nums[rMid]){
                flag = true;
                lowIdx = mid;
                break;
            }

            if(nums[mid] < nums[start]){
                end = mid - 1;
            }

            if(nums[end] < nums[mid]){
                start = mid + 1;
            }


            if(nums[end] >= nums[mid] && nums[mid] >= nums[start]){
                lowIdx = start;
                break;
            }
        }

        if(lowIdx == 0 && flag){
            return binarySearch(nums, target, 0, N);
        }


        return Math.max(binarySearch(nums, target, 0, lowIdx-1), binarySearch(nums, target,lowIdx, N)) ;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};

        System.out.println("Output :: "+ search(nums, 1));
    }
}
