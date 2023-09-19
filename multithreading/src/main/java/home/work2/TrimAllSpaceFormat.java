package home.work2;

public class TrimAllSpaceFormat implements Formatter{
    @Override
    public String format(String str) {
        System.out.println("Run thread name -"+Thread.currentThread().getName());
        return str.replaceAll("\\s", "");
    }
}
