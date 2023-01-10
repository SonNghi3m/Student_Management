package se.lexicon.data_access.IdGenerator;

public class StudentIdGenerator {
    private static int sequencer = 0;
    private static final int MAX = 999999;
    private static final int MIN = 100000;
    private static int nextId() {return ++sequencer;}
    private static int getRandomNumber() {return (int) ((Math.random() * (MAX - MIN)) + MIN);}
    public static int generateStudentIdNumber() {
        String result = nextId() + "" + getRandomNumber();
        return Integer.parseInt(result);
    }
}
