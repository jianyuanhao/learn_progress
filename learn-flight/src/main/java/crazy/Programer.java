package crazy;

public class Programer implements Work {
    private int performance = 0;

    @Override
    public void doTask(Task task) {
        coding(task);
        performance += task.getLevel();
    }

    private void coding(Task task) {
        System.out.println(this.getClass().getName() + "　is doing" + task.getDesc());
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }
}
