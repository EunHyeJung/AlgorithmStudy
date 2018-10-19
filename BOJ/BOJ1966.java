import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @source https://www.acmicpc.net/problem/1966
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.10.20
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int casCnt = Integer.parseInt(br.readLine());
            StringBuilder res = new StringBuilder();

            while (casCnt-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int docCnt = Integer.parseInt(st.nextToken());
                int searchDoc = Integer.parseInt(st.nextToken());
                int[] docsImportance = new int[docCnt];
                st = new StringTokenizer(br.readLine(), " ");
                for (int docNo = 0; docNo < docCnt; docNo++) {
                    docsImportance[docNo] = Integer.parseInt(st.nextToken());
                }
                PrinterQueue printerQueue = new PrinterQueue(docCnt, searchDoc, docsImportance);
                res.append(printerQueue.getTurn() + "\n");
            }
            System.out.println(res);
        } catch (IOException e) {

        }
    }
}

class PrinterQueue {
    private int docCnt;
    private int searchDoc;
    private Queue<Document> docQueue;
    private Queue<Document> priorityDocQueue;

    public PrinterQueue(int docCnt, int searchDoc, int[] docsImportance) {
        this.docCnt = docCnt;
        this.searchDoc = searchDoc;
        this.docQueue = new LinkedList<>();
        this.priorityDocQueue = new PriorityQueue<>();
        for (int docNo = 0; docNo < docCnt; docNo++) {
            docQueue.add(new Document(docNo, docsImportance[docNo]));
            priorityDocQueue.add(new Document(docNo, docsImportance[docNo]));
        }
    }

    public int getTurn() {
        int turn = 0;

        while (!docQueue.isEmpty() && !priorityDocQueue.isEmpty()) {
            Document curDoc = docQueue.poll();
            if (curDoc.getImportance() >= priorityDocQueue.peek().getImportance()) {
                turn += 1;
                if (curDoc.getNo() == searchDoc) {
                    return turn;
                }
                priorityDocQueue.poll();
            } else {
                docQueue.add(curDoc);
            }
        }

        return turn;
    }
}

class Document implements Comparable<Document> {
    private int no;
    private int importance;

    public Document(int no, int importance) {
        this.no = no;
        this.importance = importance;
    }

    public int getNo() {
        return no;
    }

    public int getImportance() {
        return importance;
    }

    @Override
    public int compareTo(Document d) {
        return d.getImportance() - this.importance;
    }
}
