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
        System.out.println("-----------------------------------------------------");
        //测试修改节点
        //创建一个新的节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟1234");
        singleLinkList.update(newHeroNode);
        singleLinkList.list();
        System.out.println("-----------------------------------------------------");
        singleLinkList.delete(4);
        singleLinkList.delete(2);
        singleLinkList.delete(1);
        singleLinkList.delete(3);
        singleLinkList.delete(3);
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

    //修改节点的信息，不能修改编号，No不能更改
    public void update(HeroNode newHeroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        //1.定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //到达链表最后，遍历结束
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d节点! \n", newHeroNode.no);
        }
    }

    //删除节点 先找到节点 temp.next = temp.next.next 剩下的垃圾节点会被回收
    //因此我们需要找到一个temp辅助节点，找到需要删除的节点的前一个节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//是否找到
        while (true) {
            if (temp.next == null) {
                //已经到链表的最后
                break;
            }

            if (temp.next.no == no) {
                //找到了待删除的节点的前一个节点 temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d这个节点不存在！", no);
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
