package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String, Data> data = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        while (true) {
            String[] line = scn.nextLine().split(" ");
            if(line[0].equals("0"))
                break;
            /*
             line[0] - data name
             line[1] - data size
             line[2] - data value
             */
            for (NumSystem numSystem: NumSystem.values()){
                if (line[0].contains(numSystem.code)){
                    Data temp = new Data(line[0], line[2].replace(String.valueOf(numSystem.suffix), ""), numSystem);
                    data.put(temp.getName(), temp);
                }
            }
            for (Operator operator: Operator.values()){
                if (line[0].contains(operator.text)){
                    Data a = data.get(line[1]);
                    if (line.length > 2){
                        Data b = data.get(line[2]);
                        operator.execute(a, b);
                        System.out.println(a.getValue() + a.getSuffix());
                    } else {
                        operator.execute(a);
                        System.out.println(a.getValue() + a.getSuffix());
                    }

                }
            }

        }
        for (Data item: data.values()) {
            System.out.println(item.getValue());
        }
    }
}

