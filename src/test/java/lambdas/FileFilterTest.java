package lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ConstantConditions")
public class FileFilterTest {

    @Test
    public void listFiles() {
        File root = new File("src/main/java");
        File[] files = root.listFiles();
        assertEquals(22, files.length);
    }

    @Test
    void listFiles_fileFilterAnonInnerClass() {
        File root = new File("src/main/java");
        File[] dirs = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        assertEquals(16, dirs.length);
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    void listFiles_fileFilterLambda() {
        File root = new File("src/main/java");
        File[] dirs = root.listFiles(pathname -> pathname.isDirectory());
        assertEquals(16, dirs.length);
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    void listFiles_fileFilterLambdaAsVariable() {
        File root = new File("src/main/java");
        FileFilter filter = pathname -> pathname.isDirectory();
        File[] dirs = root.listFiles(filter);
        assertEquals(16, dirs.length);
    }

    private String getErrorMessage(int num) {
        System.out.println("Creating the error message");
        return "Should be " + num + " directories";
    }

    @Test
    void listFiles_fileFilterMethodReference() {
        File root = new File("src/main/java");
        FileFilter filter = File::isDirectory;
        File[] dirs = root.listFiles(filter);
        assertEquals(16, dirs.length, () -> getErrorMessage(16));
    }

    @Test
    void mapBiConsumerDemo() {
        Map<String, Integer> map =
                ofEntries(
                        entry("a", 1),
                        entry("b", 2),
                        entry("c", 2));

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        assertAll(
                () -> assertEquals(1, map.get("a")),
                () -> assertEquals(2, map.get("b")),
                () -> assertEquals(2, map.get("c"))
        );
    }
}
