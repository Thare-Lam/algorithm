package com.thare.algorithm.archive.company.u51._20170918._02;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        MyRunnalbe myRunnalbe = new MyRunnalbe(queue);
        Thread t1 = new Thread(myRunnalbe);
        Thread t2 = new Thread(myRunnalbe);
        Thread t3 = new Thread(myRunnalbe);
        t1.start();
        t2.start();
        t3.start();
        int n = 200000;
        while (n-- > 0) {
            queue.add(in.next());
        }
        Thread.sleep(500);
        System.out.println(myRunnalbe.res);
    }

    static class MyRunnalbe implements Runnable {

        Queue<String> queue;

        volatile int count;

        int res;

        public MyRunnalbe(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String str;
            while (count < 200000) {
                str = readLine();
                if (!"".equals(str)) {
                    process(str);
                }
            }
        }

        private synchronized String readLine() {
            if (!queue.isEmpty()) {
                ++count;
                return queue.poll();
            }
            return "";
        }

        private void process(String s) {
            if (s.contains("u51")) {
                synchronized(this) {
                    ++res;
                }
            }
        }
    }

}
