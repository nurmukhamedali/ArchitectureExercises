package calculator;

import java.util.Locale;

import static java.lang.Integer.*;

enum Operator{
    ADD("ADD"){
        @Override
        public Data execute(Data a, Data b){
            NumSystem numSystem = a.getNumSystem();
            a.setValue(numSystem.value(parseInt(a.getValue(), numSystem.index) + parseInt(b.getValue(), numSystem.index)).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    },
    SUB("SUB"){
        @Override
        public Data execute(Data a, Data b){
            NumSystem numSystem = a.getNumSystem();
            int x = parseInt(a.getValue(), numSystem.index) - parseInt(b.getValue(), numSystem.index);
            a.setValue(numSystem.value(x).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    },
    MUL("MUL"){
        @Override
        public Data execute(Data a, Data b){
            NumSystem numSystem = a.getNumSystem();
            a.setValue(numSystem.value(parseInt(a.getValue(), numSystem.index) * parseInt(b.getValue(), numSystem.index)).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    },
    DIV("DIV"){
        @Override
        public Data execute(Data a, Data b){
            NumSystem numSystem = a.getNumSystem();
            a.setValue(numSystem.value(parseInt(a.getValue(), numSystem.index) / parseInt(b.getValue(), numSystem.index)).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    },
    INC("INC"){
        @Override
        public Data execute(Data a){
            NumSystem numSystem = a.getNumSystem();
            a.setValue(numSystem.value(parseInt(a.getValue(), numSystem.index) + 1).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a, Data b){
            return execute(a);
        }
    },
    DEC("DEC"){
        @Override
        public Data execute(Data a){
            NumSystem numSystem = a.getNumSystem();
            a.setValue(numSystem.value(parseInt(a.getValue(), numSystem.index) - 1).toUpperCase(Locale.ROOT));
            return a;
        }
        @Override
        public Data execute(Data a, Data b){
            return execute(a);
        }
    },
    MOV("MOV"){
        @Override
        public Data execute(Data a, Data b){
            a.setValue(b.getValue());
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    },
    XCHG("XCHG"){
        @Override
        public Data execute(Data a, Data b){
            String temp = a.getValue();
            a.setValue(b.getValue());
            b.setValue(temp);
            return a;
        }
        @Override
        public Data execute(Data a){
            return a;
        }
    };
    public final String text;
    Operator(String text){
        this.text = text;
    }
    public abstract Data execute(Data a, Data b);
    public abstract Data execute(Data a);
}
enum NumSystem{
    DEC(10, "VAR", ' '){
        @Override
        public String value(Integer number){
            return String.valueOf(number);
        }
    },
    HEX(16, "HEX", 'h') {
        @Override
        public String value(Integer number){
            return toHexString(number);
        }
    },
    OCT(8, "OCT", 'o'){
        @Override
        public String value(Integer number){
            return toOctalString(number);
        }
    },
    BIN(2, "BIN", 'b'){
        @Override
        public String value(Integer number){
            return toBinaryString(number);
        }
    },
    CHAR(16, "CHAR", 'h') {
        @Override
        public String value(Integer number){
            return String.valueOf(number);
        }
    };
    public final int index;
    public final String code;
    public final char suffix;
    NumSystem(int index, String code, char suffix){
        this.index = index;
        this.code = code;
        this.suffix = suffix;
    }
    public abstract String value(Integer number);
}
class Data{
    private String name;
    private String value;
    private char suffix;
    private NumSystem numSystem;

    public Data(String name, String value, NumSystem numSystem) {
        this.name = name;
        this.value = value;
        this.suffix = numSystem.suffix;
        this.numSystem = numSystem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String s) {
        this.value = s;
    }

    public NumSystem getNumSystem() {
        return numSystem;
    }

    public void setNumSystem(NumSystem numSystem) {
        this.numSystem = numSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSuffix() {
        return suffix;
    }

    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }
}
