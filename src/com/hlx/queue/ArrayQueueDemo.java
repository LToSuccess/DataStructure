package com.hlx.queue;

import java.util.Scanner;

/**
 * 数组实现队列
 *
 * @author hlx
 * @create 2020-09-09 18:30
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queueDemo = new ArrayQueue(3);
        char key = ' ';
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("s(show):显示=队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queueDemo.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int i = scanner.nextInt();
                    queueDemo.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = queueDemo.getQueue();
                        System.out.printf("取出的数据是%d\n", queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = queueDemo.headQueue();
                        System.out.printf("头部数据是%d\n", headQueue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列，编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;   //数组的最大容量
    private int front;      //队列头
    private int rear;      //队列尾
    private int arr[];     //存放数据模拟队列


    public ArrayQueue(int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;    //指向队列头部，队列头的前一个数据
        rear = -1;          //指向队列尾部。指向队列的最后一个数据
    }

    //判断队列是否已满
    public boolean isFall() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //往队列中添加数据
    public void addQueue(int num) {
        //判断队列是否为满
        if (isFall()) {
            System.out.println("队列已满，不能添加数据~");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    //获取队列的数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isFall()) {
            System.out.println("队列空没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\t\n", i, arr[i]);
        }
    }

    //显示队列的头部数据，注意不是取出队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空没有数据");
        }
        return arr[front + 1];
    }


}


