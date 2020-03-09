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
        singleLinkList.add(heroNode3);
        singleLinkList.add(heroNode4);
        singleLinkList.add(heroNode2);
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
        boolean flag = false;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //已经找到了
                break;
            } else if (temp.next.no == heroNode.no) { //说明添加的编号已经存在
                flag = true; //标志编号已经存在
                break;
            }
            //如果都不符合，后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            //说明编号已经存在，不能添加
            System.out.printf("当前的编号%d已经存在！\n", heroNode.no);
        } else {
            //添加到temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
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
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickName;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public HeroNode getNext() {
        return next;
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
