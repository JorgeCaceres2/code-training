package hackerrrank.interviewspreparation;


import java.util.List;

public class CloudsGame {

  public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
    int pos = 0;
    int jumps = 0;

    while (pos < c.size()) {
        if (canJump2Steps(pos, c)) {
          pos = pos + 2;
          jumps ++;
        } else if (canJump1Step(pos, c)) {
          pos = pos + 1;
          jumps ++;
        } else {
          pos ++;
        }
    }
    return jumps;

  }

  private static boolean canJump2Steps (int pos, List<Integer> c){
    return  (pos <= c.size() - 3 && c.get(pos+2) == 0);
  }

  private static boolean canJump1Step (int pos, List<Integer> c){
    return  (pos <= c.size() - 2 && c.get(pos+1) == 0);
  }

  public static void main(String[] args) {
    System.out.println("Jumps:" + jumpingOnClouds(List.of(0,0,0,0,1,0)));
    System.out.println("Jumps2:" + jumpingOnClouds(List.of(0,0,1,0,0,1,0)));
  }
}
