package crazy;

import java.util.List;

import com.google.common.collect.Lists;

public class Company {
    List<Task> taskList = Lists.newArrayList(Task.values());

    private FemaleProgramer femaleProgramer = new FemaleProgramer();
    private List<MaleProgramer> maleProgramers = Lists.newArrayList(new MaleProgramer(), new MaleProgramer());

    Boss boss = new Boss(femaleProgramer, maleProgramers);

    private void judgeEmployee() {
        for (int i = 0; i < 4; i++) {
            System.out.println("－－－－－－－－－测试第" + (i + 1) + "次任务－－－－－－－－－－");
            for (Task task : taskList) {
                boss.assignTask(task);
            }
        }
        FemaleProgramer femaleProgramer = boss.getFemaleProgramer();
        List<MaleProgramer> maleProgramers = boss.getMaleProgramers();
        System.out.println("－－－－－－－－－评 估 结　果－－－－－－－－－－");
        System.out.println("Female Programer score: " + femaleProgramer.getPerformance() + "  "
                + judge(femaleProgramer.getPerformance()));
        System.out.println("Male Programer1 score: " + maleProgramers.get(0).getPerformance() + "  "
                + judge(maleProgramers.get(0).getPerformance()));
        System.out.println("Male Programer2 score: " + maleProgramers.get(1).getPerformance() + "  "
                + judge(maleProgramers.get(1).getPerformance()));

    }

    private String judge(double performance) {
        if (performance <= 10) {
            return "You're a loser!";
        }
        if (performance <= 60) {
            return "You're still low!";
        }
        if (performance <= 90) {
            return "You're good!";
        }

        if (performance <= 100) {
            return "You're excellent!";
        }

        return "You're amazing!";
    }

    public static void main(String[] args) {
        Company company = new Company();
        company.judgeEmployee();
    }
}
