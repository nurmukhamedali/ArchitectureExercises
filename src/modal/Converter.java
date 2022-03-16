package modal;

public class Converter {
    public String DecimalToBinary(int decimal){
        return Integer.toBinaryString(decimal);
    }
    public Integer BinaryToDecimal(String binary){
        return Integer.parseInt(binary,2);
    }
    public String DecimalToHex(int decimal){
        return Integer.toHexString(decimal);
    }
    public Integer HexToDecimal(String hex){
        return Integer.parseInt(hex, 16);
    }
    public String DecimalToOctal(int decimal){
        return Integer.toOctalString(decimal);
    }
    public Integer OctalToDecimal(String octal){
        return Integer.parseInt(octal, 8);
    }
}
