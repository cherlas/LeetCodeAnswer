package cn.istarx.java;

import java.util.ArrayList;
import java.util.List;

public class NO146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(1,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(1));
        System.out.println(cache.get(1));
    }

    static class LRUCache {
        List mKeys;
        Node mHead;
        Node mTail;
        private int mCapacity;
        public LRUCache(int capacity) {
            this.mCapacity = capacity;
            mKeys = new ArrayList(capacity);
            mHead = new Node(0, 0);
            mTail = mHead;
        }

        public int get(int key) {
            if (mKeys.contains(key)) {
                Node tmp = mHead.next;
                Node pre = null;
                while (tmp.key != key) {
                    pre = tmp;
                    tmp = tmp.next;
                }
                if (pre != null) {
                    pre.next = tmp.next;
                }
                tmp.next = mHead.next;
                mHead.next = tmp;
                return tmp.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (mCapacity == 0) {
                return;
            }
            if (mKeys.contains(key)) {
                Node tmp = mHead.next;
                while (tmp.key != key) {
                    tmp = tmp.next;
                }
                tmp.value = value;
            }
            if (mKeys.size() == mCapacity) {
                mKeys.remove(mTail.key);
                mKeys.add(key);
                mTail.key = key;
                mTail.value = value;
            } else {
                mKeys.add(key);
                mTail.next = new Node(key, value);
                mTail = mTail.next;
            }
        }

        private class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }
    }

}


