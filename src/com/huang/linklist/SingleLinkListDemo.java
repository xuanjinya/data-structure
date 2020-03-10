package com.huang.linklist;

import java.util.Stack;

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
//        singleLinkList.delete(4);
//        singleLinkList.delete(2);
//        singleLinkList.delete(1);
//        singleLinkList.delete(3);
//        singleLinkList.delete(3);

        singleLinkList.list();
        //测试单链表头节点的个数
        System.out.println("有效的节点个数：" + getLength(singleLinkList.getHead()));

        //查找倒数第 K 个节点
//        HeroNode res = findLastIndexNode(singleLinkList.getHead(), 1);
//        System.out.println(res);
        System.out.println("-----------------------------------------------------");
        reverseHead(singleLinkList.getHead());
        singleLinkList.list();
        System.out.println("-----------------------------------------------------");
        reversePrint(singleLinkList.getHead());

    }

    //要求：将链表的节点进行逆序打印 可以利用栈的数据结构
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; //空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    //要求：将单链表进行反转
    public static void reverseHead(HeroNode head) {
        //判断如果链表为空,或则只有一个节点，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针，帮助遍历原来的单链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，将其取出，并放在新的链表的 reverseHead 的最前端
        while (cur != null) {
            next = cur.next; //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next; //将cur的下一个节点指向链表的 reverseHead.next;
            reverseHead.next = cur; //将 cur 连接到新的链表上
            cur = next;
        }
        head.next = reverseHead.next;
    }


    //要求： 求单链表倒数第 index 个节点
    //1.编写一个方法，接收head节点。同时接收一个index
    //2.index 表示是倒数第 index 个节点
    //3.先把链表从头到尾进行遍历，得到链表的总长度，总的长度 - N = 正向遍历的个数

    /**
     * @param head  传一个要查询的单链表的头节点
     * @param index 查倒数第几个的节点
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //先做一个 index 的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 获取单链表的有效节点的个数 ，如果有头节点，不需要统计头节点
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量
        HeroNode cur = head.next; //不统计头节点
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义一个 singleLinkList 管理我们的英雄
class SingleLinkList {
    //初始化一个头节点，头节点不要动,不存放具体数据，指向第一个节点
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

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
