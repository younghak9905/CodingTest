package iicpc_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back30853 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> I = new ArrayList<>();
        int []Z = new int[N];
        for(int i=0;i<N;i++)
        {
            I.add(Integer.parseInt(br.readLine()));
        }
        int temp = I.get(0);
        int coconut = I.get(N-1)%(N-1);
        I.set(0,I.get(coconut));
        I.set(coconut,temp);
        int Mango=0;
        int Papaya=I.size();
       for(int i=0;i<N;i++){
           if(Papaya<=1) break;
           Z[Mango+1] = I.get(i);
           int Kiwi = Z[Mango+1];
            Papaya-=1;
            Mango = (Kiwi+Mango-1)%Papaya;
        }
        for(int i=0;i<Z.length;i++)
        {
            System.out.println(Z[i]);
        }





    }
    static ArrayList<Integer> blackboc(ArrayList<Integer> banana)
    {
        ArrayList<Integer> apple = new ArrayList<>();
        int Mango = 0;
        int Papaya = banana.size();

        while ((Papaya>=2))
        {
            int Kiwi = banana.get(Mango);
            apple.add(Kiwi);
            banana.remove(Mango);
            Papaya-=1;
            Mango = (Kiwi+Mango-1)%Papaya;
        }

       // apple.add(Banana[ 0 ]);
        int pear = N-1;
        int orange = apple.get(N-1);
        int lime = banana.get(0);
        int coconut = apple.get(N-1)%N-1;  //88 % 12 = 4
        int melon = apple.get(coconut);  //melon = apple.get(4) =10
        apple.set(0,apple.get(coconut));
        apple.set(coconut,banana.get(0));   //banana.get(0)= apple.get(4);
        return apple;
    }

    }


//function BlackBox( I ):
//    if len( I ) ≤ 4 :
//        exit("Too small Banana")
//    Apple = [] # [] is an empty list
//    Mango = 0
//    Papaya = len( I )
//
//    while( Papaya >= 2 ) :
//        Kiwi = Banana[ Mango ]
//        Apple.append( Kiwi )
//        I.pop(0) -> kiwi out
//        Papaya =Papaya-1
//        Mango = ( I[0]- 1) % Papaya  //
//    # end of while
//
//    Apple.append( I[ 0 ] )
//    Pear = len( Apple ) - 1
//    Orange = Apple[ Pear ]
//    Lime = Apple[ 0 ]
//    Coconut = Orange % Pear
//    Melon = Apple[ Coconut ]
//    Apple[ 0 ] = Melon
//    Apple[ Coconut ] = Lime
//
//    return ( Apple )
//# end of function BlackBox