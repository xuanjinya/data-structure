package com.huang.queue;

/*
 * 使用数组模拟队列
 * */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArraQueue arraQueue = new ArraQueue(3);
        arraQueue.addQueue(2);
        arraQueue.addQueue(3);
        arraQueue.addQueue(4);
        arraQueue.headQueue();
        int queue = arraQueue.getQueue();
        int queue1 = arraQueue.getQueue();
    }
}

//使用数组模拟队列 编写一个 ArrayQueue 类
class ArraQueue {
    private int maxSize; //表示队列的最大值
    private int front; //表示队列头
    private int rear; //表示队列尾
    private int[] arr; //该数组用于存放数据

    //创建队列的最大值
    public ArraQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        rear = -1; //指向队列尾部 指向队列尾的数据， 加数据的时候  rear++
        front = -1; //只想队列头部 分析出 front 是指向队列头的前一个位置，数据出队列的时候 front++
    }

    //判断队列是否满
    public boolean inFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (inFull()) {
            //队列满
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据 ，取数据
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示数据的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}