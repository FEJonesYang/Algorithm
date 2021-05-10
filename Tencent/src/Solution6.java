import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 * <p>
 * Z 字形变换
 */
public class Solution6 {

    public String convert(String s, int numRows) {
        // 如果是少于一行的话
        if (numRows < 2) {
            return s;
        }
        // 根据题目中的 numRows 行，创建每一行对应的 StringBuilder
        List<StringBuilder> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(new StringBuilder());
        }

        // 遍历数组
        int i = 0,flag = -1;
        for (char c : s.toCharArray()){
            row.get(i).append(c);
            if (i == 0 || i == numRows - 1){
                flag = -flag; // 是否进行反转
            }
            i += flag;
        }

        // 把每一行的数据添加到一个 StringBuilder 中
        StringBuilder builder = new StringBuilder();
        for (StringBuilder sb : row){
            builder.append(sb);
        }
        return builder.toString();
    }
}
