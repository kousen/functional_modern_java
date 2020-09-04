package lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;

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

    @Test
    void listFiles_fileFilterMethodReference() {
        File root = new File("src/main/java");
        FileFilter filter = File::isDirectory;
        File[] dirs = root.listFiles(filter);
        assertEquals(16, dirs.length);
    }
}
