package routines;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Talend {
    /**
     * @param projectName The project name, available as `projectName` in Talend components
     * @return the project path when run from Talend Open Studio or null when run as a standalone executable
     */
    public static Path projectPath(String projectName) {
        String[] classPathElements = System.getProperty("java.class.path", "").split(";");
        Stream<Path> classPaths = Arrays.stream(classPathElements).map(path -> Paths.get(path));
        Optional<Path> classesPath = classPaths.filter(path -> path.endsWith(Paths.get(".Java", "target", "classes"))).findAny();
        if (classesPath.isPresent()) {
            Path workspacePath = classesPath.get().getParent().getParent().getParent();
            Path projectPath = workspacePath.resolve(projectName);
            if (Files.isDirectory(projectPath)) {
                return projectPath;
            }
        }
        return null;
    }
    
}