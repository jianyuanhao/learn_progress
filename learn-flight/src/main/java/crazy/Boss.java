package crazy;

import java.util.List;

public class Boss {
    private FemaleProgramer femaleProgramer;
    private List<MaleProgramer> maleProgramers;

    public void assignTask(Task task) {
        if (task.getLevel() > 1) {
            MaleProgramer maleProgramer = randomChooseMaleProgramer();
            maleProgramer.doTask(task);
        } else {
            femaleProgramer.doTask(task);
        }
    }

    public Boss(FemaleProgramer femaleProgramer, List<MaleProgramer> maleProgramers) {
        this.femaleProgramer = femaleProgramer;
        this.maleProgramers = maleProgramers;
    }

    private MaleProgramer randomChooseMaleProgramer() {
        return maleProgramers.get((int) (Math.random() * maleProgramers.size()));
    }

    public FemaleProgramer getFemaleProgramer() {
        return femaleProgramer;
    }

    public List<MaleProgramer> getMaleProgramers() {
        return maleProgramers;
    }
}
