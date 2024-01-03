package misc;

public class ZigZag {


    public String convert(String s, int numRows){

        String resString ="";
        boolean reverse = false;
        int length = s.length();
        char[][] arr = new char[numRows][length];
        int row = 0;
        for(int i = 0; i<length; i++){
            if(!reverse){
                arr[row][i] = s.charAt(i);
                row++;
                if(row == numRows){
                    reverse = true;
                    row = (row - 2)%numRows;
                }
            }else{
                arr[row][i] = s.charAt(i);
                row--;
                if(row == -1){
                    reverse = false;
                    row=(row+2)%numRows;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<numRows; i++){
           for(int j=0; j<length; j++){
               if(arr[i][j] != '\u0000'){
                   sb.append(arr[i][j]);
               }

           }
        }
        resString = sb.toString();

        return resString;
    }

    public static void main(String[] args) {
        ZigZag zg = new ZigZag();
        String res = zg.convert("AB", 1);
        System.out.println(res);
    }
}
