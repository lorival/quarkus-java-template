package br.com.lorival.reactivejavatemplate;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

public class InterfaceToImplementationMapService {

  public static Map<Class<?>, Class<?>> getMap(String packageName, String interfaceSuffix) {
    Reflections reflections = new Reflections(packageName, Scanners.SubTypes);

    return reflections.getAll(Scanners.SubTypes).stream()
        .filter(className -> className.endsWith(interfaceSuffix))
        .map(InterfaceToImplementationMapService::getClassForName)
        .filter(Class::isInterface)
        .collect(
            Collectors.toMap(
                interfaceClass -> interfaceClass,
                interfaceClass -> getUniqueImplementation(reflections, interfaceClass)));
  }

  private static Class<?> getUniqueImplementation(
      Reflections reflections, Class<?> interfaceClass) {
    Set<Class<?>> implementations =
        reflections.getSubTypesOf(interfaceClass).stream()
            .filter(implementationClass -> !implementationClass.isInterface())
            .collect(Collectors.toSet());

    if (implementations.size() != 1) {
      String implementationsList =
          implementations.stream().map(Class::getName).collect(Collectors.joining(", "));
      throw new IllegalStateException(
          String.format(
              "Exactly one implementation is required for interface: %s, found: %s",
              interfaceClass.getName(), implementationsList));
    }
    return implementations.iterator().next();
  }

  @SneakyThrows
  private static Class<?> getClassForName(String className) {
    return Class.forName(className);
  }
}
