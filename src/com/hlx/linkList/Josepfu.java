package com.hlx.linkList;

/**
 * @author hlx
 * @create 2020-09-19 23:06
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();
        circleSingleLinkList.addBoy(5);
        circleSingleLinkList.showBoy();


        //测试小孩出圈
        circleSingleLinkList.countBoy(1, 2, 5);
    }
}


//创建环形的单项链表
class CircleSingleLinkList {
    private Boy first = null;

    public void addBoy(int nums) {
        //数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy cureBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cureBoy = first;
            } else {
                cureBoy.setNext(boy);
                boy.setNext(first);
                cureBoy = boy;
            }

        }

    }

    //遍历环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入计算出出圈的顺序
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        Boy Helper = first;
        while (true) {
            if (Helper.getNext() == first) {
                break;
            }
            Helper = Helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            Helper = Helper.getNext();
        }
        while (true) {
            if (Helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                Helper = Helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            Helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号是"+first.getNo());
    }
}

//创建节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
