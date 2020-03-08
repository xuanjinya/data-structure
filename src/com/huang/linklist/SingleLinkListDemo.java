package com.huang.linklist;

public class SingleLinkListDemo {
    public static void main(String[] args) {
        //进行测试。创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.add(heroNode1);
        singleLinkList.add(heroNode2);
        singleLinkList.add(heroNode3);
        singleLinkList.add(heroNode4);
        //显示
        singleLinkList.list();
    }
}

//定义一个 singleLinkList 管理我们的英雄
class SingleLinkList {
    //初始化一个头节点，头节点不要动,不存放具体数据，指向第一个节点
    private HeroNode head = new HeroNode(0, "", "");

    //（不考虑排序）添加一个节点，需要找到这个链表的最后，把最后节点的next域指向一个新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个遍历辅助temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到
            temp = temp.next;
        }
        //当 while 退出循环的时候，temp 就指向了最后
        temp.next = heroNode;
    }

    //显示链表
    public void list() {
        //1.先判断链表为空吗
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //2.因为头节点不能为空，因此我们需要一个辅助变量来遍历，head不能动
        HeroNode temp = head.next;
        while (true) {
            //判断链表是否走到最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //3.将temp后移
            temp = temp.next;
        }
    }
}


//定义一个heroNode ，每一个HeroNode 对象就是一个节点
class HeroNode {
    private int no;
    public String name;
    private String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
