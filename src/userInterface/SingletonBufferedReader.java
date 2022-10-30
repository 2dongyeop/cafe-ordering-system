package userInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class SingletonBufferedReader extends BufferedReader {
    private volatile static SingletonBufferedReader bufferedReader;

    private SingletonBufferedReader(Reader in) {
        super(in);
    }

    public static SingletonBufferedReader getInstance() {
        if (bufferedReader == null) {
            synchronized (SingletonBufferedReader.class) {
                if (bufferedReader == null) {
                    bufferedReader = new SingletonBufferedReader(new InputStreamReader(System.in));
                }
            }
        }
        return bufferedReader;
    }
}
