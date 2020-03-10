package com.huang.linklist;

/*
 * 合并两个有序的单链表，合并后的单链表仍然是有序的
 * */
public class SingleLinkTest {
    public static void main(String[] args) {
        //进行测试。创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(5, "宋江", "及时雨");
        HeroNode heroNode6 = new HeroNode(6, "卢俊义", "玉麒麟");
        HeroNode heroNode7 = new HeroNode(7, "吴用", "智多星");
        HeroNode heroNode8 = new HeroNode(8, "林冲", "豹子头");
        //创建一个链表
        SingleLinkList singleLinkList1 = new SingleLinkList();
        SingleLinkList singleLinkList2 = new SingleLinkList();
        singleLinkList1.add(heroNode1);
        singleLinkList1.add(heroNode3);
        singleLinkList1.add(heroNode5);
        singleLinkList1.add(heroNode7);
        singleLinkList2.add(heroNode2);
        singleLinkList2.add(heroNode4);
        singleLinkList2.add(heroNode6);
        singleLinkList2.add(heroNode8);
        System.out.println("链表1------------------------");
        singleLinkList1.list();
        System.out.println("链表2------------------------");
        singleLinkList2.list();
        SingleLinkList singleLinkList = mergeSingleLink(singleLinkList1, singleLinkList2);
        System.out.println("链表3------------------------");
        singleLinkList.list();
    }

    public static SingleLinkList mergeSingleLink(SingleLinkList l1, SingleLinkList l2) {
        HeroNode cur1 = l1.getHead();
        HeroNode cur2 = l2.getHead();
        SingleLinkList singleLinkList3 = new SingleLinkList();
        HeroNode head = singleLinkList3.getHead();
        while (cur1.next != null && cur2.next != null) {
            if (cur1.next.no <= cur2.next.no) {
                head.next = cur1.next;
                cur1.next = cur1.next.next;
            } else {
                head.next = cur2.next;
                cur2.next = cur2.next.next;
            }
            head = head.next;
        }
        if (cur1.next == null) head.next = cur2.next.next;
        if (cur2.next == null) head.next = cur1.next.next;
        return singleLinkList3;
    }
}


