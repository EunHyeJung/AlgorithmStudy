import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 *  @date : 2020-03-21
 *  @source : https://www.acmicpc.net/problem/1431
 *  @email : ehye826@gamil.com
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        List<SerialNoInfo> serialNoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            serialNoList.add(new SerialNoInfo(br.readLine()));
        }

        Collections.sort(serialNoList);
        for (SerialNoInfo serialInfo : serialNoList) {
            System.out.println(serialInfo.getSerialNo());
        }
    }


}

class SerialNoInfo implements Comparable<SerialNoInfo> {
    String serialNo;
    int numSum;

    public SerialNoInfo(String serialNo) {
        this.serialNo = serialNo;
        this.numSum = 0;

        for (int i = 0, len = serialNo.length(); i < len; i++) {
            if (serialNo.charAt(i) - '0' >= 0 && serialNo.charAt(i) - '0' <= 9) {
                this.numSum += (serialNo.charAt(i) - '0');
            }
        }
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public int getSerialNoLength() {
        return this.serialNo.length();
    }

    public int getNumSum() {
        return this.numSum;
    }

    @Override
    public int compareTo(SerialNoInfo serialNoInfo) {
        if (this.getSerialNoLength() != serialNoInfo.getSerialNoLength()) {
            return this.getSerialNoLength() - serialNoInfo.getSerialNoLength();
        } else if (this.getNumSum() != serialNoInfo.getNumSum()) {
            return this.getNumSum() - serialNoInfo.getNumSum();
        }

        return this.getSerialNo().compareTo(serialNoInfo.getSerialNo());

    }
}
