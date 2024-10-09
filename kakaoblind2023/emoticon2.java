package kakaoblind2023;
class emoticon2 {

    static int service, money;
    static int[] result;
    static int[] sales = {10, 20, 30, 40};

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        result = new int[emoticons.length];
        service = 0;
        money = 0;
        recur(users, emoticons, 0);

        return new int[] {service, money};
    }

        static void recur(int[][] users, int[] emoticons, int cnt) {
            if (cnt == emoticons.length) {//40 10 20 40

                int currentservice = 0;
                int currentmoney = 0;
                for(int i=0;i<users.length;i++)
                {  int sum=0;

                    for(int j=0;j<emoticons.length;j++)
                    {
                        if(users[i][0]<=result[j])
                        {
                            sum+=emoticons[j]*(100-result[j])/100;

                        }
                    }

                    if(sum>=users[i][1])
                    {
                        currentservice++;
                    }
                    else
                    {
                        currentmoney+=sum;
                    }
                }
                if(service>currentservice) {
                    return;
                }
                if(service<currentservice)
                {
                    service=currentservice;
                    money=currentmoney;
                }
                else if(money<currentmoney)
                {

                       money=currentmoney;

                }


                return;
            }
                for (int i = 0; i < 4; i++) {
                    result[cnt] = sales[i];
                    recur(users, emoticons, cnt + 1);

                }

        }
    public static void main(String[] args) {

        // 테스트 케이스 1: [[40, 10000], [25, 10000]], [7000, 9000]
        int[][] users1 = {{40, 10000}, {25, 10000}};
        int[] emoticons1 = {7000, 9000};
        int[] result1 = solution(users1, emoticons1);
        System.out.println("Test 1 결과: " + result1[0] + ", " + result1[1]);  // 기대값: [1, 5400]

        // 테스트 케이스 2: [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]], [1300, 1500, 1600, 4900]
        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};
        int[] result2 = solution(users2, emoticons2);
        System.out.println("Test 2 결과: " + result2[0] + ", " + result2[1]);  // 기대값: [4, 13860]
    }

    }
