package com.woodee.queue;

/**
    - 큐는 FIFO(First In First Out)인 자료구조이다.
        - 먼저 넣은 데이터를 먼저 꺼낸다.
    - int Queue 구현
        - enque, deque, peek, indexOf, clear, capacity,
           size, isEmpty, isFull, dump 메소드 구현
**/
public class IntQueue {
    private int max;    //큐의 용량
    private int front;  //첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int number; //현재 데이터 수
    private int[] queue;//큐 본체

    //큐안에 비어있는데 데이터를 꺼낼 경우 예외 처리
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }
    //큐안에 가득차있는데 데이터를 넣을 경우 예외 처리
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException(){}
    }

    //생성자
    public IntQueue(int capacity)  {
        number = front = rear = 0;
        max = capacity;
        try {
            queue = new int[max];
        }catch (OutOfMemoryError error){
            max = 0;
        }
    }

    //enque()
    public int enque(int x) throws OverflowIntQueueException {
        if(number >= max) {
            throw new OverflowIntQueueException();
        }
        //인큐가 들어오면 마지막 요소 커서인 rear 에 x가 대입 후 증가
        queue[rear++] = x;
        number++;

        //max 와 같을 때 rear 는 0으로 값을 대입해줘야 된다. 안하면 max 보다 초과해서 에러
        if(rear == max){
            rear = 0;
        }
        return x;
    }

    //deque()
    public int deque() throws EmptyIntQueueException {
        if(number <= 0){
            throw new EmptyIntQueueException();
        }
        //선입선출 구조기 때문에 front 자리가 먼저 나가야된다.
        //x인 변수이름 말고 좋은 이름이 없을까?
        int x = queue[front++];
        number--;
        if(front == max) {
            front = 0;
        }

        return x;
    }

    //peek() - front 데이터를 본다.
    public int peek() throws EmptyIntQueueException {
        if(number <= 0){
            throw new EmptyIntQueueException();
        }
        return queue[front];
    }

    //indexOf() - 해당하는 index 를 반환, 없으면 -1를 반환
    public int indexOf(int x) {
        //front 부터 선형검색
        //front 는 queue[idx]의 가장 맨 앞이 아니기 때문에 idx 를 구해야한다.
        for(int i = 0 ; i<number; i++) {
            int idx = (i + front) % max;
            if(queue[idx] == x){
                return idx;
            }//if
        }//for
       return -1;
    }

    //clear() - 큐를 비움
    public void clear() {
        number = front = rear = 0;
    }

    //capacity() - 큐의 용량응 반환
    public int capacity() {
        return max;
    }

    //size() - 큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return number;
    }

    //isEmpty() - 큐가 비어있으면 true, 아니면 false
    public boolean isEmpty() {
        return number <= 0;
    }

    //isFull() - 큐가 가득차 있으면 true, 아니면 false
    public boolean isFull() {
        return number >= max;
    }

    //dump() - front 부터 rear 순서로 모든 데이터 출력
    public void dump() {
            if(number <= 0) {
                System.out.println("큐가 비어있습니다.");
            } else {
                for (int i = 0; i < number; i++) {
                    System.out.println(queue[(i + front) % max]);
            }//for
        }//if~else
    }

    public static void main(String[] args) {
        IntQueue que = new IntQueue(5);
        System.out.println("max : "+que.max);
        System.out.println("front : "+que.front);
        System.out.println("rear : "+que.rear);
        System.out.println("number : "+que.number);

        que.enque(5);
        que.enque(7);
        que.enque(10);
        que.enque(12 );

        for(int i = que.front; i<que.rear; i++){
            System.out.println(que.queue[i]);
        }

        /*que.deque();
        que.deque();
        que.deque();
        que.deque();
        que.deque();
        for(int i = que.front; i<que.rear; i++){
            System.out.println(que.queue[i]);
        }*/
        System.out.println("peek : " + que.peek());
        System.out.println("indexOf : " + que.indexOf(12));
        System.out.println("capacity : " + que.capacity());
        System.out.println("size : " + que.size());
        System.out.println("isEmpty : " + que.isEmpty());
        System.out.println("isFull : " + que.isFull());
        System.out.println("dump");
        que.dump();;

    }
}
