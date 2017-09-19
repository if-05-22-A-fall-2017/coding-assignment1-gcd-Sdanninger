/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author Simon
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] as =   { 13 , 37 , 20 , 624129 };
        int[] bs =   { 13 , 600 , 100 , 2061517 };
        int[] res  = { 13 , 1 , 20 , 18913};
        boolean succesful = true;
        for (int i = 0; i < res.length; i++) {
            succesful = true;
            if(gcdEucledian(as[i],bs[i]) != res[i]){
                System.out.println("\033[31m Eculedian was wrong with "+ as[i] + " and "+ bs[i] +" actual "+ gcdEucledian(as[i],bs[i]));
                succesful = false;
            }
            if(gcdPrimeFactors(as[i],bs[i]) != res[i]){
                System.out.println("\033[31m PrimeFactors was wrong with "+ as[i] + " and "+ bs[i] +" actual "+ gcdPrimeFactors(as[i],bs[i]));
                succesful = false;
            }
            if(succesful)
                System.out.println("\033[32m test with "+ as[i] + " and " + bs[i] + " was succesful");
        }
        
         
    }
    
    public static int gcdEucledian(int a, int b){
        if(b == 0)
            return a;
        
        return gcdEucledian(b,a % b);
    }
    
            
    public static int gcdPrimeFactors(int a, int b){
        int toReturn = 1;
        
        int aDivisor = 2,bDivisor = 2;
        while (a != 1 && b != 1){
            while(a % aDivisor != 0)
                while(!checkIfPrime(++aDivisor)){}
            a /= aDivisor;
            
            while(b % bDivisor != 0)
                while(!checkIfPrime(++bDivisor)){}
            b /= bDivisor;
            
            if(aDivisor == bDivisor)
                toReturn *= aDivisor;
        }
        
        
        
        return toReturn;
    }

    private static boolean checkIfPrime(int n) {
        if(n == 2)
            return true;
        if(n % 2 == 0 || n == 1|| n == 0)
            return true;
        
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
}

