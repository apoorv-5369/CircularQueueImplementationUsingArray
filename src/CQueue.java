public class CQueue {
    int Size = 5;
    int front, rear;
    int[] items =  new int[Size];
    CQueue(){
        front = -1;
        rear = -1;
    }
    // Check if the queue is Empty.
    public boolean isEmpty(){
        return front == -1;
    }
    // Check if the queue is Full.
    public boolean isFull(){
        if(front==0&&rear==Size-1) return true;
        else if(front==rear+1) return true;
        else return false;
    }
    // Adding an Element.
    public void enQueue(int element){
        if(isFull()) System.out.println("Queue is Full.");
        else{
            if(front==-1) front = 0;
            rear = (rear+1)%Size;
            items[rear] = element;
            System.out.println("Inserted "+element);
        }
    }
    // Deleting an Element.
    public int deQueue(){
        int element=0;
        if(isEmpty()) System.out.println("Queue is Empty");
        else{
            element=items[front];
            if(front==rear){
                front = -1;
                rear = -1;
            }else{
                front = (front+1)%Size;
            }
            System.out.println("Deleted "+element);

        }
        return (element);
    }
    public void display(){
        int i;
        if(isEmpty()) System.out.println("Queue is Empty");
        else{
            System.out.println("Front Index-> "+front);
            System.out.println("Items-> ");
            for(i=front;i!=rear;i=(i+1)%Size)
                System.out.print(items[i]+" ");
            System.out.println(items[i]);
            System.out.println("Rear Index-> "+rear);
        }
    }
    public static void main(String[] args){
        CQueue q = new CQueue();
        q.deQueue();
        for(int i=1;i<7;i++){
            q.enQueue(i);
        }
        q.display();
        q.deQueue();
        q.enQueue(7);
        q.enQueue(8);
        q.display();
        q.deQueue();
        q.display();
    }
}
