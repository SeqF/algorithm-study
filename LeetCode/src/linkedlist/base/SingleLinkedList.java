package linkedlist.base;

/**
 * 实现单链表，支持增删操作
 */
public class SingleLinkedList {

    private static ListNode head;

    /**
     * 查询链表长度
     *
     * @return length 链表长度
     */
    public static int linkedListLength(ListNode head) {
        int length = 0;
        //长度不包含头结点
        ListNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 用尾插法添加结点
     *
     * @param data 插入链表中的数据
     */
    public static void addNode(int data) {

        ListNode newListNode = new ListNode(data);
        while (head.next != null) {
            newListNode.next = head.next;
            head.next = newListNode;
        }
        head.next = newListNode;
    }

    /**
     * 在指定位置插入一个结点
     *
     * @param index 位置
     * @param data  数据
     */
    public static void insertNode(ListNode head, int index, int data) {

        if (index < 1 || index > linkedListLength(head) + 1) {
            return;
        }

        int currentPos = 0;
        ListNode temp = head;
        ListNode newListNode = new ListNode(data);

        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                newListNode.next = temp.next;
                temp.next = newListNode;
            }
            temp = temp.next;
            currentPos++;
        }
        temp.next = newListNode;
    }

    /**
     * 删除一个指定位置的结点
     *
     * @param index 要删除的位置
     */
    public static void deleteNode(ListNode head, int index) {

        if (index < 1 || index > linkedListLength(head) + 1) {
            return;
        }

        int currentPos = 0;
        ListNode temp = head;

        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
            currentPos++;
        }
        return;
    }

    /**
     * 使用头插法实现单链表反转
     */
    public static void reverse(ListNode head) {

        if (head.next == null) {
            return;
        }
        ListNode newhead = new ListNode();
        //保存拆出的节点
        ListNode temp;
        //遍历链表
        ListNode cursor = head.next;
        while (cursor != null) {
            //将旧链表的第一个节点拆出
            temp = cursor;
            head.next = cursor.next;
            //将从旧链表拆出的节点用头插法插入到新的链表中
            temp.next = newhead.next;
            newhead.next = temp;
            cursor = cursor.next;
        }
    }

    /**
     * 两个有序链表合并成一个有序链表 (从小到大)
     * 产生新的头结点
     */
    public static void merge(ListNode head1, ListNode head2) {
        if (head1.next == null && head2.next == null) {
            System.out.println("两个都为空链表");
        }
        ListNode a = head1.next;
        ListNode b = head2.next;
        ListNode head3 = new ListNode();
        //指向合并后链表的尾部
        ListNode c = head3;
        ListNode temp;

        //只要有一个链表为空时就停止遍历
        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp = a;

                head1.next = a.next;

                temp.next = c.next;
                c.next = temp;
                c = temp;

                a = a.next;
            } else {
                temp = b;

                head2.next = b.next;

                temp.next = c.next;
                c.next = temp;
                c = temp;

                b = b.next;
            }
        }
        if (b != null) {
            head2.next = null;
            c.next = b;
        }
        if (a != null) {
            head1.next = null;
            c.next = a;
        }
    }

    /**
     * 递归实现两链表合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     * 求链表的中间节点
     * 思路：使用双指针，先求出链表的长度，然后求出中间值，
     * 然后进行计数，当计数>=中间值时，另一个指针开始，那么当第一个指针遍历到尾部时，第二指针指向向的就是中间节点
     *
     * @return
     */
    public static ListNode findMiddleNode(ListNode head) {

        int middle = linkedListLength(head) / 2;
        int count = 0;
        ListNode cursor = head;
        ListNode middleListNode = head;
        while (cursor.next != null) {
            cursor = cursor.next;
            count++;
            if (count >= middle) {
                middleListNode = middleListNode.next;
            }
        }
        return middleListNode;
    }
}
