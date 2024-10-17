package pccp;

public class pcce_neighbor_board {
    static int [] dw = {1,0,0,-1};
    static int [] dh = {0,1,-1,0};
    public int solution(String[][] board, int h, int w) {

        int n = board.length;

        int count=0;
        System.out.println(board[h][w]);
        for(int k=0;k<=3;k++)
        {
            int h_check= h+dh[k];
            int w_check= w+dw[k];
            if(h_check>=0 && h_check<n && w_check>=0 && w_check<n)
            {
                if(board[h][w].equals(board[h_check][w_check]))
                {
                    count++;
                }
                System.out.println("h_check: "+h_check+" w_check: "+w_check);

            }

        }

        return count;
    }

    public static void main(String[] args) {
        pcce_neighbor_board sol = new pcce_neighbor_board();
        //[["blue", "red", "orange", "red"], ["red", "red", "blue", "orange"], ["blue", "orange", "red", "red"], ["orange", "orange", "red", "blue"]]
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        int ret = sol.solution(board, h, w);
        System.out.println(ret);
    }
}
