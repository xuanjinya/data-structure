package com.huang.queue;

/*
 * 环形的数组队列
 * */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4); //说明是4，其队列的有效数值个数为3
        circleArray.addQueue(2);
        circleArray.addQueue(3);
        circleArray.addQueue(4);
        circleArray.headQueue();
        circleArray.showQueue();
        int queue = circleArray.getQueue();
        int queue1 = circleArray.getQueue();
        circleArray.addQueue(3);
        circleArray.addQueue(2);
        circleArray.showQueue();
    }
}

class CircleArray {
    private int maxSize; //表示队列的最大值
    private int front; //表示队列头
    private int rear; //表示队列尾的后一个位置，希望空出一个位置
    private int[] arr; //该数组用于存放数据

    public CircleArray(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
//        front = 0;
//        rear = 0;
    }

    //判断队列是否满
    public boolean inFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //将 rear 后移。这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据 ，取数据
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里要分析出 front 是指向队列的第一个元素
        //1.先把 front 对应的值保存到一个临时的变量
        int value = arr[front];
        //2.先将 front 后移，还要考虑是否会越界，所以要进行取模
        front = (front + 1) % maxSize;
        //将临时保存的变量返回
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        //1.从 front 开始遍历，需要遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示数据的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
}