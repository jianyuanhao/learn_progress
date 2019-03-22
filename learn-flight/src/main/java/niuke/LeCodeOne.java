package niuke;

import com.joy.fresh.test.LeeCode;

/**
 * Created by jianyuanhao on 19-3-21.
 */
public class LeCodeOne {

    public boolean Find(int target, int[][] array) {
        int rows=array.length;
        int columns=array[0].length;
        boolean found=false;
        if(rows>0 &&columns>0)
        {
            int row=0;
            int column=columns-1;
            while(row<rows && column>=0)
            {
                if(array[row][column]==target)
                {
                    found=true;
                    break;
                }
                else if(array[row][column]>target)
                    --column;
                else
                    ++row;

            }
        }
        return found;


    }

    public static void main(String[] args) {
        int[][] array = { { 1, 4, 5 }, { 8, 10, 20 }, { 24, 30, 45 } };
        System.out.println(new LeCodeOne().Find(24,array));

    }
}
