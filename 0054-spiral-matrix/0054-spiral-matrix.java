class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int buttom = matrix.length - 1;

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<Integer>();

        while(left <= right && top <= buttom){
            // left --> right (top row)
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            // top --> buttom (right column)
            for(int j = top; j <= buttom; j++){
                list.add(matrix[j][right]);
            }
            right--;

            // check if buttom row exist or not          
            if(top <= buttom){ 

                 // right --> left (buttom row)  
                for(int k = right; k >= left; k--){
                list.add(matrix[buttom][k]);
                }
                buttom--;
            }
            
            // check if left column exist or not    
            if(left <= right){ 

                // buttom --> top (left column)
                for(int l = buttom; l >= top; l--){
                list.add(matrix[l][left]);
                }
                left++;
            }
        }
        return list;
    }
}