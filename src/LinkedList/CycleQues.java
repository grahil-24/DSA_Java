package LinkedList;

import java.util.List;

public class CycleQues {


    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        }while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }

    private int findSquare(int num){
        int ans = 0;

        while(num > 0){
            int rem = num % 10;
            ans += num * num;
            num  = num / 10;
        }
        return ans;
    }
}

class ListNode{
    int val;

    ListNode next;

    ListNode(){

    }

    ListNode(int x){
        val = x;
        next = null;
    }
}
