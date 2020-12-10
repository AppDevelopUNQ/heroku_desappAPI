package ar.unq.dessap.groupa.backenddesappapi.archunit;

import ar.edu.unq.desapp.grupoa.backenddesappapi.BackendDesappApiApplication;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.Loader;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@AnalyzeClasses(packages = "ar.edu.unq.desapp.grupoa.backenddesappapi")
public class ArchUnit {

    private JavaClasses classes = new ClassFileImporter().importPackages("com.tngtech.archunit.example.layers");

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Controllers").definedBy("ar.edu.unq.desapp.grupoa.backenddesappapi.controllers..")
            .layer("Services").definedBy("ar.edu.unq.desapp.grupoa.backenddesappapi.service..")
            .layer("Repository").definedBy("ar.edu.unq.desapp.grupoa.backenddesappapi.dao..")

            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services")
            .ignoreDependency(BackendDesappApiApplication.class, Loader.class);
}
