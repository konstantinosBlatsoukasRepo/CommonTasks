package kon.blats.reflection;

import java.lang.reflect.Field;

/**
 * Created by kon on 1/1/2018.
 */
public class FieldsToUpperCaseConverter {

    public Object convertFieldsToUpperCase(Object object) throws IllegalAccessException, NoSuchFieldException {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        Class objectClass = object.getClass();
        Field[] declaredFields = objectClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);
            if (declaredField.getType().isPrimitive() || isWrapperType(declaredField.getType())) {
                System.out.println("This is a primitive type");
            } else if (declaredField.getType().equals(String.class)) {
                String oldValue = (String) declaredField.get(object);
                if (oldValue != null) {
                    declaredField.set(object, oldValue.toUpperCase());
                }
            } else {
                convertFieldsToUpperCase(declaredField.get(object));
            }
        }

        return object;
    }

    private static boolean isWrapperType(Class<?> clazz) {
        return clazz.equals(Boolean.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class);
    }
}
