package pccp;

public class pcce_bus {
    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;
        for(int i=0; i<passengers.length; i++){
            num_passenger += func4(passengers[i]);

            num_passenger -= func3(passengers[i]);

        }
        int answer = func1(seat-num_passenger);


        return answer;
    }

    public int func1(int num){
        if(0 > num){
            return 0;
        }
        else{
            return num;
        }
    }
    public int func2(int num){
        if(num > 0){
            return 0;
        }
        else{
            return num;
        }
    }

    public int func3(String[] station){
        int num = 0;
        for(int i=0; i<station.length; i++){
            if(station[i].equals("Off")){
                num += 1;
            }
        }
        return num;
    }

    public int func4(String[] station){
        int num = 0;
        for(int i=0; i<station.length; i++){
            if(station[i].equals("On")){
                num += 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        pcce_bus sol = new pcce_bus();
        int seat = 5;
        //[["On", "On", "On"], ["Off", "On", "-"], ["Off", "-", "-"]]
        String[][] passengers = {{"On", "On", "On"}, {"Off", "On", "-"}, {"Off", "-", "-"}};
        int ret = sol.solution(seat, passengers);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }

}
