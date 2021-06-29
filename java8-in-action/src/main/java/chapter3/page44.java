package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class page44 {
    public static void main(String[] args) throws IOException {
        page44 p = new page44();
        p.runMain();
    }

    public String processFile(BufferedReadProcessor bufferedReadProcessor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("./java8-in-action/src/main/java/chapter3/data.txt"))) {
            return bufferedReadProcessor.process(br);
        }
    }

    public void runMain() throws IOException {
        String oneLine = processFile(BufferedReader::readLine);
        System.out.println("print one line :: " + oneLine);
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("print two line :: " + twoLine);
    }
}

interface BufferedReadProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}

