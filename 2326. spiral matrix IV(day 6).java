/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix =new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=-1;
            }
        }
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int dir=0;
        int row=0,col=0;
        int topBound=0,bottomBound=m-1,leftBound=0,rightBound=n-1;
        ListNode currentNode=head;
        while(currentNode!=null){

        matrix[row][col]=currentNode.val;
        currentNode=currentNode.next;
        int nextRow=row+directions[dir][0];
        int nextCol=col+directions[dir][1];
        if(nextRow>bottomBound||nextRow<topBound||nextCol>rightBound||nextCol<leftBound||matrix[nextRow][nextCol]!=-1){
            if(dir==0)topBound++;
            else if(dir==1)rightBound--;
            else if(dir==2) bottomBound--;
            else if(dir==3) leftBound++;
            dir=(dir+1)%4;
            nextRow=row+directions[dir][0];
            nextCol=col+directions[dir][1];

        }
        row=nextRow;
        col=nextCol;

    }
    return matrix;
}
        }