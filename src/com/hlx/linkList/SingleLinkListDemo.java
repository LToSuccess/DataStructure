package com.hlx.linkList;

/**
 * 单链表
 *
 * @author hlx
 * @create 2020-09-18 14:24
 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkList singleLinkList = new SingleLinkList();
        /*singleLinkList.add(heroNode1);
        singleLinkList.add(heroNode2);
        singleLinkList.add(heroNode3);
        singleLinkList.add(heroNode4);
        singleLinkList.list();*/


        //按照顺序添加
        singleLinkList.addByOrder(heroNode1);
        singleLinkList.addByOrder(heroNode4);
        singleLinkList.addByOrder(heroNode2);
        singleLinkList.addByOrder(heroNode3);
        singleLinkList.addByOrder(heroNode3);
        singleLinkList.list();


        //测试修改节点
        singleLinkList.update(new HeroNode(2, "小卢", "玉麒麟1"));
        //修改后的列表
        singleLinkList.list();
        System.out.println();
        //删除节点
        singleLinkList.delete(1);
        singleLinkList.delete(4);
        //删除后的列表
        singleLinkList.list();
    }

}

//定义一个SingleLinkList，管理英雄人物
class SingleLinkList {
    //定义一个头节点，不能动
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向列表
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    //第二种添加英雄（按顺序插入）
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;   //判断添加的编号是否存在
        while (true) {
            if (temp.next == null) {   //说明已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄的编号已经存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //修改
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;   //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到节点");
        }

    }


    //删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有要删除的节点");
        }
    }
}


//定义一个HeroNode，每个HeroNode节点就是一个对象
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}
