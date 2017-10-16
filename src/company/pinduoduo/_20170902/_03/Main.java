package company.pinduoduo._20170902._03;

import java.util.*;

public class Main {

    private static int actId = 0;

    private static Map<Integer, int[]> goods = new HashMap<>();

    private static Map<Integer, int[]> acts = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            String[][] req = new String[m][];
            for (int i = 0; i < n; ++i) {
                int[] info = new int[5];
                int id = in.nextInt();
                info[0] = in.nextInt(); // rq
                info[1] = in.nextInt(); // kc
                goods.put(id, info);
            }
            in.nextLine();
            for (int i = 0; i < m; ++i) {
                req[i] = in.nextLine().split(" ");
            }
            process(req);
        }
    }

    private static void process(String[][] req) {
        for (String[] r : req) {
            int curTime = Integer.valueOf(r[0]);
            String reqName = r[1];
            if ("add".equals(reqName)) {
                System.out.println(addActivity(Integer.valueOf(r[2]), Integer.valueOf(r[3]), Integer.valueOf(r[4]), Integer.valueOf(r[5])));
            } else if ("buy".equals(reqName)) {
                System.out.println(buyGoods(curTime, Integer.valueOf(r[2]), Integer.valueOf(r[3])));
            } else if ("list".equals(reqName)) {
                getActivityList(curTime);
            }
        }
    }

    public static int addActivity(int startTime, int endTime, int goodsId, int limitQuantity){
        if (limitQuantity > goods.get(goodsId)[1]) {
            return -1;
        }
        int[] info = new int[5];
        info[0] = goodsId;
        info[1] = startTime;
        info[2] = endTime;
        info[3] = limitQuantity;
        acts.put(actId, info);
        return actId++;
    }

    public static int buyGoods(int curTime, int activityId, int quantity) {


        if (activityId >= actId) {
            System.out.println(-1);
        }
        int[] actInfo = acts.get(activityId);
        if (curTime < actInfo[1] || curTime >= actInfo[2]) {
            return -1;
        }
        int[] goodsInfo = goods.get(actInfo[0]);
        if (quantity > actInfo[3]) {
            return -1;
        }
        actInfo[3] -= quantity;
        goodsInfo[1] -= quantity;
        actInfo[4] = curTime;
        return 0;
    }

    public static void getActivityList(int curTime) {
        Set<Map.Entry<Integer, int[]>> set = acts.entrySet();
        int[][] in = new int[1000][3];
        int[][] inEmpty = new int[1000][4];
        int[][] notStart = new int[1000][4];
        int inSize = 0, inEmptySize = 0, notStartSize = 0;
        for (Map.Entry<Integer, int[]> entry : set) {
            int actId = entry.getKey();
            int[] actInfo = entry.getValue();
            int goodsId = actInfo[0];
            int[] goodsInfo = goods.get(goodsId);
            if (curTime < actInfo[1]) {
                notStart[notStartSize][0] = actId;
                notStart[notStartSize][1] = actInfo[1];
                notStart[notStartSize][2] = goodsInfo[0];
                notStart[notStartSize++][3] = goodsId;
            } else if (curTime >= actInfo[1] && curTime < actInfo[2]) {
                if (actInfo[3] == 0) {
                    inEmpty[inEmptySize][0] = actId;
                    inEmpty[inEmptySize][1] = actInfo[4];
                    inEmpty[inEmptySize][2] = goodsInfo[0];
                    inEmpty[inEmptySize++][3] = goodsId;
                } else {
                    in[inSize][0] = actId;
                    in[inSize][1] = goodsInfo[0];
                    in[inSize++][2] = goodsId;
                }
            }
        }
        if (inSize + inEmptySize + notStartSize == 0) {
            System.out.println();
        } else {
            int i;
            for (i = 0; i < inSize; ++i) {
                System.out.print(in[i][0] + " ");
            }
            for (i = 0; i < inEmptySize; ++i) {
                System.out.print(inEmpty[i][0] + " ");
            }
            for (i = 0; i < notStartSize; ++i) {
                System.out.print(notStart[i][0] + " ");
            }
            System.out.println();
        }
    }
}
