package home.work2;

import java.util.concurrent.Callable;

public class FormatWork implements Callable<String> {

    private  final Formatter formatter;
    private  final String str;

    public FormatWork(Formatter formatter,String str) {
        this.formatter = formatter;
        this.str=str;
    }

    @Override
    public String call() throws Exception {
        return formatter.format(str);
    }
}
