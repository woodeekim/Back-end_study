package com.woodee.algorithm;

/**
    - 스택은 LIFO(Last In First Out)인 자료구조다.
        - 나중에 들어온 데이터가 먼저 나간다.
    - int Stack 구현
        - push, pop, peek, indexOf, clear, capacity,
          size, isEmpty, isFull, dump 메소드 구현
**/
public class IntStack {

    private int max;
    private int pointer;
    private int[] stackArray;

    public IntStack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            stackArray = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }
    //비어있는 스택에 값을 pop 할 경우 예외처리
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    //가득찬 스택에 값을 push 할 경우 예외처리
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    //push()
    public int push(int x) throws OverflowIntStackException {
        /* 관계연산자인 >= 보다 등가 연산자 == 를 사용하면
           스택 본체 배열(stackArray)의 상한과 하한을 벗어나서
           접근하는 것을 막을 수 있다 => 안정성을 높임 */
        if(pointer == max){
            throw new OverflowIntStackException();
        }
        return stackArray[pointer++] = x;
    }

    //pop()
    public int pop() throws EmptyIntStackException {
        if(pointer <= 0){
            throw new EmptyIntStackException();
        }
        return stackArray[--pointer];
    }

    //peek() - 스택의 꼭대기에 있는 데이터를 보는 메소드
    public int peek(int x) throws EmptyIntStackException {
        if(pointer <= 0){
            throw new EmptyIntStackException();
        }
        //스택의 꼭대기에 있는 값을 보려면 stackArray[pointer-1]
        return stackArray[pointer-1];
    }

    //indexOf() - 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x)  throws EmptyIntStackException {
        //pointer 는 스택에 쌓여있는 데이터의 수이기 때문에 -1 해야 인덱스와 같다.
        //꼭대기부터 선형검색
        for(int i = pointer-1 ; i >= 0 ; i--){
            if(stackArray[i] == x){
                return i;
            }
        }
        return -1;
    }

    //clear() - 스택을 비움
    public void clear() {
        pointer = 0;
    }

    //capacity() - 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    //size() - 스택에 쌓여 있는 데이터 수를 반환
    public int size() {
        return pointer;
    }

    //isEmpty() - 스택이 비어있으면 true, 아니면 false
    public boolean isEmpty() {
        return pointer <= 0;
    }

    //isFull() - 스택이 가득차있으면 true, 아니면 false
    public boolean isFull() {
        return pointer >= max;
    }

    //dump() - 스택 안의 데이터를 바닥-> 꼭대기 순서로 출력
    public void dump() {
        if(pointer <= 0) {
            System.out.println("스택이 비어있습니다.");
        }else {
            for(int i=0; i<pointer; i++){
                System.out.println("stackArray["+i+"]"+"="+stackArray[i]);
            }
        }//if~else
    }
    //main()
    public static void main(String[] args) {
        IntStack intStack = new IntStack(3);
        intStack.push(5);
        intStack.push(10);
        intStack.push(7);

        System.out.println("indexOf() :" + intStack.indexOf(7));
        System.out.println("capacity() :" + intStack.capacity());
        System.out.println("size() :" + intStack.size());
        System.out.println("isEmpty() :" + intStack.isEmpty());
        System.out.println("isFull() :" + intStack.isFull());
        System.out.println("dump() :");
        intStack.dump();
        /*for(int i = 0 ; i<intStack.stackArray.length; i++){
            System.out.println("stackArray["+i+"] : "+intStack.stackArray[i]);
        }
        System.out.println(intStack.pointer);
        intStack.pop();
        intStack.pop();
        for(int i = 0 ; i<intStack.stackArray.length; i++){
            System.out.println("stackArray["+i+"] : "+intStack.stackArray[i]);
        }
        System.out.println(intStack.pointer);*/

    }



}
