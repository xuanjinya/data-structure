package com.huang.linklist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        //添加
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(heroNode4);
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.list();
        System.out.println("----------------------------------------------");
        //修改
        HeroNode2 heroNode5 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(heroNode5);
        doubleLinkedList.list();

        System.out.println("----------------------------------------------");
        //删除
        doubleLinkedList.delete(3);
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示双向链表的全部节点
    public void list() {
        if (head.next == null) {
            System.out.println("link null!");
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

    //添加一个双向链表的最后
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("link null!");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;
        } else {
            System.out.println("要更新的节点没找到");
        }
    }

    //删除一个节点,根据一个 No
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("link null!");
            return;
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
            //如果删除的是最后一个节点，这句话不需要执行
            if (temp.next == null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点不存在");
        }
    }
}

//定义一个heroNode ，每一个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}