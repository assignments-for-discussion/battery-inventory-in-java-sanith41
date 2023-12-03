package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();

    //Iterate through each battery capacity
    for(int capacity: presentCapacities){
      
      //calculate state of health as percentage
      double stateofhealth=(double)capacity/120*100;

      //cataegorize battery based on state of health
      if(stateofhealth<=100&&stateofhealth>60 ){
        counts.healthy++;
      }
      else if( stateofhealth<=60&&stateofhealth>10){
      counts.exchange++;
      }
      else{
      counts.failed++;
      }
    }

    
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");

    //case 1 standard case
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);

    //Test case 2 all healthy batteries
    int[] presentCapacities2 = {110, 115, 118, 120, 112};
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities2);
    assert (counts2.healthy == 5);
    assert (counts2.exchange == 0);
    assert (counts2.failed == 0);

    // Test case 3 all failed batteries
    int[] presentCapacities3 = {50, 55, 60, 45, 58};
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities3);
    assert (counts3.healthy == 0);
    assert (counts3.exchange == 0);
    assert (counts3.failed == 5);

    // Test case 4 all exchange batteries
    int[] presentCapacities4 = {70, 75, 78, 85, 63};
    CountsBySoH counts4 = countBatteriesByHealth(presentCapacities4);
    assert (counts4.healthy == 0);
    assert (counts4.exchange == 5);
    assert (counts4.failed == 0);


    
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
     
    testBucketingByHealth();
  }
}
