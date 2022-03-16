package test;

import modal.Octal;

public class TestOctal {
    public void run(){
        this.testOctalAddition();
        this.testOctalMultiplication();
        this.testOctalSubtraction();
    }
    public void testOctalAddition() {
        String number;
        System.out.println("--- octal addition test started ---");
        number = Octal.add("7", "17");
        System.out.println("26".equals(number) ? true : number);
        number = Octal.add("0", "0");
        System.out.println("0".equals(number) ? true : number);
        number = Octal.add("156", "621");
        System.out.println("777".equals(number) ? true : number);
        System.out.println("--- octal addition test executed ---");
    }
    public void testOctalMultiplication(){
        String number;
        System.out.println("--- octal multiplication test started ---");
        number = Octal.multiple("15", "2");
        System.out.println("32".equals(number) ? true : number);
        number = Octal.multiple("3", "7");
        System.out.println("25".equals(number) ? true : number);
        number = Octal.multiple("0", "20");
        System.out.println("0".equals(number) ? true : number);
        System.out.println("--- octal multiplication test executed ---");
    }
    public void testOctalSubtraction(){
        String number;
        System.out.println("--- octal subtraction test started ---");
        number = Octal.subtract("31", "4");
        System.out.println("25".equals(number) ? true : number);
        number = Octal.subtract("13", "4");
        System.out.println("7".equals(number) ? true : number);
        number = Octal.subtract("14", "4");
        System.out.println("10".equals(number) ? true : number);
        System.out.println("--- octal subtraction test executed ---");
    }
}
