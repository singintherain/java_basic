package lvsong.club;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsong on 11/5/15.
 */
public class TableCreator {
    public void create(String classFileName) throws Exception {
        try {
            Class<?> clazz = Class.forName(classFileName);

            DBTable dbTable = clazz.getAnnotation(DBTable.class);

            if(dbTable == null) {
                System.out.println("No DBTable defined in class " + classFileName);
            }

            String tableName = dbTable.name();

            if(tableName.length() < 1) {
                tableName = clazz.getName().toUpperCase();
            }

            List<String> columns = new ArrayList<String>();
            for(Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if(annotations.length < 1) {
                    continue; // not a table column
                }

                if(annotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger)annotations[0];

                    if(sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }

                    columns.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                }

                if(annotations[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) annotations[0];

                    if(sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }

                    columns.add(columnName + " VARCHAR(" + sqlString.value() + ")" +
                            getConstraints(sqlString.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");

            for(String column : columns) {
                createCommand.append("\n " + column + ",");
            }

            //Remove trailing comma
            String tableCreate = createCommand.substring(
                    0, createCommand.length() - 1
            ) + ");";


            System.out.println("Table Create SQL for " +
                    classFileName + " is : \n" + tableCreate);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

            throw e;
        }
    }

    private String getConstraints(Constraints constraints){
        String cons = "";

        if(!constraints.allowNull()) {
            cons += " NOT NULL";
        }
        if(constraints.primaryKey()) {
            cons += " PRIMARY KEY";
        }
        if(constraints.unique()) {
            cons += " UNIQUE";
        }

        return cons;
    }
}
