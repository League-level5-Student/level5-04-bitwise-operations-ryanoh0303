package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		
		BinaryPrinter Bp = new BinaryPrinter();
		Byte bit = (byte) 10011;
		Short s = (short) 12321;
		long l = (long) 1221;
		//Bp.printByteBinary(bit);
		
		Bp.printLongBinary(l);
	}
	
	
	
	public void printByteBinary(byte b) {
		System.out.println(b);
	
	}
	
	public void printShortBinary(short decimalNum) {
	    String binaryStr = "";
	    
        do {
            // 1. Logical right shift by 1
            int quotient = decimalNum >>> 1;
        
            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            decimalNum = (short) quotient;
            
        // 3. Repeat until number is 0
        } while( decimalNum != 0 );
        
        System.out.println(binaryStr);
    
	}
	
	public String printIntBinary(int decimalNum) {
	    String binaryStr = "";
	    
        do {
            // 1. Logical right shift by 1
            int quotient = decimalNum >>> 1;
        
            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            decimalNum = quotient;
            
        // 3. Repeat until number is 0
        } while( decimalNum != 0 );
        
        return binaryStr;
    
	}
	
	public void printLongBinary(long decimalNum) {
	    String binaryStr = "";
	    
        do {
            // 1. Logical right shift by 1
            long quotient = decimalNum >>> 1;
        
            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            decimalNum = quotient;
            
        // 3. Repeat until number is 0
        } while( decimalNum != 0 );
        
        System.out.println(binaryStr);
    
		
	}
}
