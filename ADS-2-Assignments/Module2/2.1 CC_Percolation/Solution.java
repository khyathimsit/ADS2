import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Percolation p = new Percolation(n);
        while(sc.hasNextLine()){
          String line = sc.nextLine();
          String[] input = line.split(" ");
          p.open(Integer.parseInt(input[0])-1, Integer.parseInt(input[input.length-1])-1);
        }
        System.out.println(p.isconnected());
    }   
}