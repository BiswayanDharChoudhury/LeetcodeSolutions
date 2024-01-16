import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing2 {
    static class Jobs {
        int deadline;
        int profit;
        int id;

        public Jobs(int i, int d, int p) {
            deadline = d;
            profit = p;
            id = i;
        }
    }

    public static void main(String args[]) {
        Jobs jobsInfo[] = {new Jobs(0, 4, 20), new Jobs(1, 1, 10), new Jobs(2, 1, 40), new Jobs(3, 1, 30)};
        ArrayList<Jobs> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(jobsInfo[i]);
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Jobs curr = jobs.get(i);

            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Maximum number of jobs: " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
