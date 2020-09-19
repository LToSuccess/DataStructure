package com.hlx.linkList;

/**
 * @author hlx
 * @create 2020-09-19 11:58
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1=new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2=new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3=new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4=new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.add(hero1);
        doubleLinkList.add(hero2);
        doubleLinkList.add(hero3);
        doubleLinkList.add(hero4);
        doubleLinkList.list();


        //修改
        HeroNode2 newHeroNode=new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkList.update(newHeroNode);
        System.out.println("修改后");
        doubleLinkList.list();

        //删除
        doubleLinkList.delete(3);
        System.out.println("删除后");
        doubleLinkList.list();
    }
}

class DoubleLinkList {
    //定义一个头节点，不能动
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点到双向列表
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //修改
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {      //防止出现空指针异常
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有要删除的节点");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}
