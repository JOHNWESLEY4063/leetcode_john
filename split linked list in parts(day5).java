class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
    int length=0;
    ListNode current=head;
    while (current !=null){
        length++;
        current=current.next;
    } 
    int baseSize=length/k;
    int extraNodes=length%k;
    ListNode[] result=new ListNode[k];
    current=head;
    for(int i=0;i<k;i++){
        result[i]=current;
        int partSize=baseSize+(i<extraNodes?1:0);
        for(int j=0;j<partSize-1;j++){
            if(current!=null){
                current=current.next;
            }
        }
        if(current!=null){
            ListNode nextpart=current.next;
            current.next=null;
            current=nextpart;
        }
    }   
    return result;
    }
}